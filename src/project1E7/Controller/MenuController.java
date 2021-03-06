package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.*;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class MenuController {
    MenuView view;
    Menu model;
    Scanner input = new Scanner(System.in);

    public MenuController(MenuView view) {
    }

    public MenuController(MenuView view, Menu model) {
        this.view = view;
        this.model = model;
    }

    /**
     * @param room
     * @param currentRoom
     * @return
     */
    public boolean encounterHeroFirst(Hero theHero, HeroView heroView, HeroController heroController, Monster monsterModel,
                                      MonsterView monsterView, MonsterController monsterController, MapView mapView, Controls controls,
                                      ControlsController controlsController, ControlsView controlsView, User user, Room[][] room,
                                      Room currentRoom, ArrayList<Item> backPack, Room previousRoom) {

        boolean run = true;
        int tempSpeed = theHero.getSpeed();
        int tempStrength = theHero.getStrength();
        String encounterChoice = "0";
        do {

            view.encounterMenu();
            encounterChoice = input.nextLine();
            switch (encounterChoice) {

                case "1":
                    if (theHero.isAlive()) {
                        if (heroController.attack(monsterController)) {
                            heroView.hitMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();
                        } else {
                            heroView.missMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();
                        }
                    }
                    if (monsterModel.isAlive() && theHero.isAlive()) {
                        if (monsterController.attack(heroController, theHero)) {
                            monsterView.monsterHitFlavorText(monsterModel);
                            heroView.printStatus(theHero, currentRoom);
                            run = theHero.isAlive();
                        } else {
                            monsterView.monsterMissFlavorText(monsterModel);
                            heroView.printStatus(theHero, currentRoom);
                            run = theHero.isAlive();
                        }
                    }
                    run = true;
                    break;
                case "2":
                    if (heroController.flee(theHero)) {
                        heroView.fleeSuccess();
                        heroController.turnCounter();
                        run = false;
                    } else {
                        heroView.fleeFail();
                        heroController.turnCounter();
                        run = true;

                        if (monsterModel.isAlive() && theHero.isAlive()) {
                            if (monsterController.attack(heroController, theHero)) {
                                monsterView.monsterHitFlavorText(monsterModel);
                                monsterView.printStatus(monsterModel);
                                heroView.printStatus(theHero, currentRoom);
                            } else {
                                monsterView.monsterMissFlavorText(monsterModel);
                                monsterView.printStatus(monsterModel);
                                heroView.printStatus(theHero, currentRoom);
                            }
                        }
                    }
                    break;
                case "3":
                    if (theHero.getAbilityCounter() <= 2) {
                        switch (theHero.getCharacterClass()) {
                            case "Warrior":
                                heroController.useWarriorAbility(currentRoom);
                                heroView.viewAbility(theHero, currentRoom);
                                heroController.abilityCounter();
                                heroController.turnCounter();
                                break;
                            case "Thief":
                                if (!(currentRoom == room[1][3])) {
                                    heroController.useThiefAbility(theHero, currentRoom);
                                    heroView.viewAbility(theHero, currentRoom);
                                    heroController.abilityCounter();
                                    heroController.turnCounter();
                                } else {
                                    System.out.println("The Boss was too powerful and resisted your ability!");
                                }
                                break;
                            case "Mage":
                                if (!(currentRoom == room[1][3])) {
                                    heroController.useMageAbility(currentRoom);
                                    heroView.viewAbility(theHero, currentRoom);
                                    heroController.abilityCounter();
                                    heroController.turnCounter();
                                } else {
                                    System.out.println("The Boss was too powerful and resisted your ability!");
                                }
                                break;
                        }
                    } else System.out.println("you don't have any power to use an ability");
                    break;
                case "4":
                    if (theHero.getSuperAbilityCounter() < 1) {
                        switch (theHero.getCharacterClass()) {
                            case "Warrior":
                                if (theHero.getHealth() <= 30) {
                                    if (!(currentRoom == room[1][3])) {
                                        heroController.useWarriorSuperAbility(currentRoom);
                                        heroView.viewSuperAbility(theHero, currentRoom);
                                        heroController.superAbilityCounter();
                                        heroController.turnCounter();
                                    } else {
                                        System.out.println("The Boss was too powerful and resisted your ability!");
                                    }
                                } else
                                    System.out.println("You can not use your super ability, your health must 30 or lower to use it!!");
                                break;
                            case "Thief":
                                if (theHero.getHealth() <= 30) {
                                    if (!(currentRoom == room[1][3])) {
                                        heroController.useThiefSuperAbility(currentRoom);
                                        heroView.viewSuperAbility(theHero, currentRoom);
                                        heroController.superAbilityCounter();
                                        heroController.turnCounter();
                                    } else {
                                        System.out.println("The Boss was too powerful and resisted your ability!");
                                    }
                                } else
                                    System.out.println("You can not use your super ability, your health must 30 or lower to use it!");
                                break;
                            case "Mage":
                                if (theHero.getHealth() <= 30) {
                                    if (!(currentRoom == room[1][3])) {
                                        heroController.useMageSuperAbility(currentRoom);
                                        heroView.viewSuperAbility(theHero, currentRoom);
                                        heroController.superAbilityCounter();
                                        heroController.turnCounter();
                                    } else {
                                        System.out.println("The Boss was too powerful and resisted your ability!");
                                    }
                                } else
                                    System.out.println("You can not use your super ability, your health must 30 or lower to use it!");
                                break;
                        }
                    } else System.out.println("You have already used your super ability");
                    break;
                case "5":
                    heroController.printItem(backPack);
                    heroController.useItem(backPack);
                    heroController.turnCounter();
                    break;
                case "6":
                    subMenu(controlsController, controlsView, mapView, room, theHero, heroView, currentRoom, user, controls, heroController,previousRoom);
                    break;
                default:
                    System.out.println("Please enter a proper value.");
                    run = true;
                    break;
            }

        }
        while (run && (monsterModel.isAlive() && theHero.isAlive()));
        if (theHero.getCharacterClass().equals("Warrior")) {
            theHero.setSpeed(tempSpeed);
        }
        if (theHero.getCharacterClass().equalsIgnoreCase("Thief")) {
            theHero.setStrength(tempStrength);
        }
        return run;
    }

    /**
     * encounter with monster monster goes first
     *
     * @param theHero
     * @param heroView
     * @param heroController
     * @param monsterModel
     * @param monsterView
     * @param monsterController
     * @return
     */
    public boolean encounterMonsterFirst(Hero theHero, HeroView heroView, HeroController heroController, Monster monsterModel,
                                         MonsterView monsterView, MonsterController monsterController, MapView mapView, Controls controls,
                                         ControlsController controlsController, ControlsView controlsView, User user, Room[][] room,
                                         Room currentRoom, ArrayList<Item> backPack, Room previousRoom) {
        String encounterChoice = "0";
        int tempSpeed = theHero.getSpeed();
        int tempStrength = theHero.getStrength();
        boolean run = true;
        monsterView.encounter(monsterModel);
        do {

            if (monsterController.attack(heroController, theHero) && monsterModel.isAlive()) {
                monsterView.monsterHitFlavorText(monsterModel);
                heroView.printStatus(theHero, currentRoom);
                if (theHero.isAlive()) {
                    view.encounterMenu();
                    encounterChoice = input.nextLine();
                }
            } else {
                monsterView.monsterMissFlavorText(monsterModel);
                heroView.printStatus(theHero, currentRoom);
                if (theHero.isAlive()) {
                    view.encounterMenu();
                    encounterChoice = input.nextLine();
                }
            }

            switch (encounterChoice) {

                case "1":
                    if (theHero.isAlive()) {
                        if (heroController.attack(monsterController)) {
                            heroView.hitMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();

                        } else {
                            heroView.missMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();
                        }
                    }
                    run = true;
                    break;
                case "2":
                    if (heroController.flee(theHero)) {
                        heroController.turnCounter();
                        heroView.fleeSuccess();
                        run = false;
                        return run;
                    } else
                        heroView.fleeFail();
                    heroController.turnCounter();
                    run = true;
                    break;
                case "3":
                    if (theHero.getAbilityCounter() <= 2) {
                        switch (theHero.getCharacterClass()) {
                            case "Warrior":
                                heroController.useWarriorAbility(currentRoom);
                                heroView.viewAbility(theHero, currentRoom);
                                heroController.abilityCounter();
                                heroController.turnCounter();
                                break;
                            case "Thief":
                                if (!(currentRoom == room[1][3])) {
                                    heroController.useThiefAbility(theHero, currentRoom);
                                    heroView.viewAbility(theHero, currentRoom);
                                    heroController.abilityCounter();
                                    heroController.turnCounter();
                                } else {
                                    System.out.println("The Boss was too powerful and resisted your ability!");
                                }
                                break;
                            case "Mage":
                                if (!(currentRoom == room[1][3])) {
                                    heroController.useMageAbility(currentRoom);
                                    heroView.viewAbility(theHero, currentRoom);
                                    heroController.abilityCounter();
                                    heroController.turnCounter();
                                } else {
                                    System.out.println("The Boss was too powerful and resisted your ability!");
                                }
                                break;
                        }
                    } else System.out.println("you don't have any power to use an ability");
                    break;
                case "4":
                    if (theHero.getSuperAbilityCounter() < 1) {
                        switch (theHero.getCharacterClass()) {
                            case "Warrior":
                                if (theHero.getHealth() <= 30) {
                                    if (!(currentRoom == room[1][3])) {
                                        heroController.useWarriorSuperAbility(currentRoom);
                                        heroView.viewSuperAbility(theHero, currentRoom);
                                        heroController.superAbilityCounter();
                                        heroController.turnCounter();
                                    } else {
                                        System.out.println("The Boss was too powerful and resisted your ability!");
                                    }
                                } else
                                    System.out.println("You can not use your super ability, your health must 30 or lower to use it!");
                                break;
                            case "Thief":
                                if (theHero.getHealth() <= 30) {
                                    if (!(currentRoom == room[1][3])) {
                                        heroController.useThiefSuperAbility(currentRoom);
                                        heroView.viewSuperAbility(theHero, currentRoom);
                                        heroController.superAbilityCounter();
                                        heroController.turnCounter();
                                    } else {
                                        System.out.println("The Boss was too powerful and resisted your ability!");
                                    }
                                } else
                                    System.out.println("You can not use your super ability, your health must 30 or lower to use it!");
                                break;
                            case "Mage":
                                if (theHero.getHealth() <= 30) {
                                    if (!(currentRoom == room[1][3])) {
                                        heroController.useMageSuperAbility(currentRoom);
                                        heroView.viewSuperAbility(theHero, currentRoom);
                                        heroController.superAbilityCounter();
                                        heroController.turnCounter();
                                    } else {
                                        System.out.println("The Boss was too powerful and resisted your ability!");
                                    }
                                } else
                                    System.out.println("You can not use your super ability, your health must 30 or lower to use it!");
                                break;
                        }
                    } else System.out.println("You have already used your super ability");
                    break;
                case "5":
                    heroController.printItem(backPack);
                    heroController.useItem(backPack);
                    heroController.turnCounter();
                    break;
                case "6":
                    subMenu(controlsController, controlsView, mapView, room, theHero, heroView, currentRoom, user, controls, heroController,previousRoom);
                    break;
                default:
                    if (theHero.isAlive()) {
                        System.out.println("Please enter a proper value.");
                    }
                    run = true;
                    break;
            }
        } while (run && (monsterModel.isAlive() && theHero.isAlive()));
        if (theHero.getCharacterClass().equals("Warrior")) {
            theHero.setSpeed(tempSpeed);
        }
        if (theHero.getCharacterClass().equalsIgnoreCase("Thief")) {
            theHero.setStrength(tempStrength);
        }
        return run;
    }

    /**
     * select hero menu
     *
     * @return
     */

    public Hero selectHero() {
        Hero warrior = new Hero(120, 70, 40, "Normal Ability: War Cry: Doubles speed for current room and boosts health by 20 points.\n" +
                "Super Ability: Great Cleave: Deal double your attack damage. Cannot miss.", "Warrior", 100, "Warrior", "Long Sword");
        HeroView heroViewWarrior = new HeroView(warrior);
        heroViewWarrior.printStats();

        Hero mage = new Hero(80, 80, 50, "Normal Ability: Partial Possession: Reduce enemy attack damage by 10 for current room.\n" +
                "Super Ability: Magic Missile: Instantly destroy the enemy.", "Mage", 100, "Mage", "Magic Scepter");
        HeroView heroViewMage = new HeroView(mage);
        heroViewMage.printStats();

        Hero thief = new Hero(100, 60, 80, "Normal Ability: Poisoned Blade: Adds 30 damage to your dagger for the current room.\n" +
                "Super Ability: Neuropoison: Reduce targets speed to 0 and casue them to deal 15 less damage to you.", "Thief", 100, "Thief", "Curved Dagger");
        HeroView heroViewThief = new HeroView(thief);
        heroViewThief.printStats();

        boolean selected = true;

        while (selected) {

            view.chooseHeroMenu();

            String userInput = "0";
            userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    selected = heroViewWarrior.selectHero(warrior);
                    warrior.setCharacterClass("Warrior");
                    if (!selected) {
                        return warrior;
                    } else
                        selected = true;
                    break;
                case "2":
                    selected = heroViewWarrior.selectHero(mage);
                    mage.setCharacterClass("Mage");
                    if (!selected) {
                        return mage;
                    } else
                        selected = true;
                    break;
                case "3":
                    selected = heroViewWarrior.selectHero(thief);
                    thief.setCharacterClass("Thief");
                    if (!selected) {
                        return thief;
                    } else
                        selected = true;
                    break;
                default:
                    System.out.println("Please enter a valid option...");
                    break;
            }

        }
        return null;
    }

    /**
     * start menu
     *
     * @return
     */
    public String startMenu() {

        String userInput = "0";
        int tempCount = 0;
        boolean run = true;
        boolean chosen = false;

        do {
            view.startMenu();
            userInput = input.nextLine();
            String correct;
            switch (userInput) {

                case "1":
                    System.out.println("You have selected Start Game is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes") || correct.equalsIgnoreCase("y")) {
                        System.out.println("The game is Starting");
                        run = false;
                        return userInput;
                    } else
                        run = true;
                    break;
                case "2":
                    System.out.println("You have selected to Load a saved Game is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes") || correct.equalsIgnoreCase("y")) {
                        System.out.println("The game is Starting");
                        return userInput;
                    } else
                        run = true;
                    break;
                case "3":
                    System.out.println("You have selected to View HighScore is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes") || correct.equalsIgnoreCase("y")) {
                        run = false;
                        return userInput;
                    } else run = true;
                    break;
                case "4":
                    System.out.println("You have selected Instructions is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes") || correct.equalsIgnoreCase("y")) {
                        System.out.println("Opening Instructions");
                        run = false;
                        return userInput;
                    } else run = true;
                    break;
                case "5":
                    System.out.println("You have selected Quit is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes") || correct.equalsIgnoreCase("y")) {
                        System.out.println("Quiting Game");
                        run = false;
                        return userInput;
                    } else run = true;
                    break;
                default:
                    System.out.println("Please enter a proper value. ");
                    run = true;
                    break;
            }


        } while (run);

        return userInput;
    }

    /**
     * sub menu
     *
     * @param controlsController
     * @param controlsView
     * @param mapView
     * @param room
     * @param theHero
     * @param heroView
     * @param currentRoom
     * @param controls
     * @param user
     */
    public void subMenu(ControlsController controlsController, ControlsView controlsView, MapView mapView, Room[][] room,
                        Hero theHero, HeroView heroView, Room currentRoom, User user, Controls controls, HeroController heroController, Room previousRoom) {

        boolean run = true;

        do {
            view.subMenu();
            String choice = input.nextLine();
            switch (choice) {

                case "0":
                    System.out.println("Exited menu");
                    run = false;
                    break;

                case "1":
                    controlsView.viewControls();
                    break;

                case "2":
                    controlsController.changeControls();
                    break;

                case "3":
                    heroView.gameInstructions();
                    break;

                case "4":
                    mapView.mapPrinter(room);
                    break;

                case "5":
                    Save save = new Save(theHero, room, controls, user, heroController.currentRoom(currentRoom, room));
                    heroController.getICurrent(currentRoom, room, save);
                    heroController.getJCurrent(currentRoom, room, save);
                    heroController.getIPrevious(previousRoom, room, save);
                    heroController.getJPrevious(previousRoom, room, save);
                    Game game = new Game(theHero, room, controls, user, currentRoom, save.getCurrentI(), save.getCurrentJ(),save.getPreviousI(),save.getPreviousJ());
                    SaveView saveView = new SaveView(save);
                    SaveController saveController = new SaveController(save, saveView);
                    saveController.saveGame(game);
                    break;

                case "6":
                    String fileName = "SavedGame.json";
                    File gameFile = new File("SavedGame.json");
                    Load gameLoad = new Load(gameFile, fileName);
                    LoadView gameLoadView = new LoadView(gameLoad);
                    LoadController gameLoadController = new LoadController(gameLoad, gameLoadView);
                    gameLoadController.loadGame();
                    break;
                case "7":
                    File file = new File("HighScore.txt");
                    Load load = new Load(file, "HighScore.txt");
                    LoadView loadView = new LoadView(load);
                    LoadController loadController = new LoadController(load, loadView);
                    loadController.loadHighestScore();
                    break;
                case "8":
                    System.out.println("Are you sure you want to quit the game? yes/no");
                    String exit = input.nextLine();
                    if (exit.equalsIgnoreCase("yes") || exit.equalsIgnoreCase("y")) {
                        System.exit(0);
                    } else

                        break;
                default:
                    System.out.println("Please enter a proper value");
            }
        } while (run);
    }
}



