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
     *
     * @param room
     * @param currentRoom
     * @return
     */
    public boolean encounterHeroFirst(Hero theHero, HeroView heroView, HeroController heroController, Monster monsterModel,
                                      MonsterView monsterView, MonsterController monsterController, MapView mapView, Controls controls,
                                      ControlsController controlsController, ControlsView controlsView, User user, Room[][] room, Room currentRoom ,ArrayList<Item> backPack) {

        boolean run = true;
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
                        if (monsterController.attack(heroController)) {
                            monsterView.monsterHitFlavorText(monsterModel);
                            heroView.printStatus(theHero);
                        } else {
                            monsterView.monsterMissFlavorText(monsterModel);
                            heroView.printStatus(theHero);
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
                            if (monsterController.attack(heroController)) {
                                monsterView.monsterHitFlavorText(monsterModel);
                                heroView.printStatus(theHero);
                            } else
                                monsterView.monsterMissFlavorText(monsterModel);
                            heroView.printStatus(theHero);

                        }
                    }
                    break;
                case "3":
                    heroController.printItem(backPack);
                    heroController.useItem(backPack);
                    heroController.turnCounter();
                    break;
                case "4":
                    subMenu(controlsController,controlsView, mapView, room, theHero, heroView, currentRoom, user, controls);
                    break;
                default:
                    System.out.println("Please enter a proper value.");
                    run = true;
                    break;
            }

        } while (run && (monsterModel.isAlive() && theHero.isAlive()));
        return run;
    }

    /**
     * encounter with monster monster goes first
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
                                         ControlsController controlsController, ControlsView controlsView, User user, Room[][] room, Room currentRoom,ArrayList<Item> backPack) {
        String encounterChoice = "0";
        boolean run = true;
        monsterView.encounter(monsterModel);
        do {

            if (monsterController.attack(heroController) && monsterModel.isAlive()) {
                monsterView.monsterHitFlavorText(monsterModel);
                heroView.printStatus(theHero);
                view.encounterMenu();
                encounterChoice = input.nextLine();

            } else
                monsterView.monsterMissFlavorText(monsterModel);
            heroView.printStatus(theHero);
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
                    heroController.printItem(backPack);
                    heroController.useItem(backPack);
                    heroController.turnCounter();
                    break;
                case "4":
                    subMenu(controlsController,controlsView, mapView, room, theHero, heroView, currentRoom, user, controls);
                        break;
                default:
                    System.out.println("Please enter a proper value.");
                    run = true;
                    break;
            }
        } while (run && (monsterModel.isAlive() && theHero.isAlive()));
        return run;
    }

    /**
     * select hero menu
     * @return
     */
    public Hero selectHero() {
        Hero warrior = new Hero(1000, 70, 30, "The Warrior...", "Warrior", 100, "Warrior");
        HeroView heroViewWarrior = new HeroView(warrior);
        heroViewWarrior.printStats();

        Hero mage = new Hero(60, 60, 40, "The Mage...", "Mage", 100, "Warrior");
        HeroView heroViewMage = new HeroView(mage);
        heroViewMage.printStats();

        Hero thief = new Hero(80, 60, 80, "The Thief...", "Thief", 100, "Warrior");
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
                        Hero theHero, HeroView heroView, Room currentRoom, User user, Controls controls){

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

                    File file = new File("HighScore.txt");
                    Load load = new Load(file, "HighScore.txt");
                    LoadView loadView = new LoadView(load);
                    LoadController loadController = new LoadController(load, loadView);
                    loadController.loadHighestScore();
                    break;

                case "4":
                    mapView.mapPrinter(room);
                    break;

                case "5":
                    Game game = new Game(theHero, room, controls, user, currentRoom);
                    Save save = new Save(theHero,room, controls, user, currentRoom);
                    SaveView saveView = new SaveView(save);
                    SaveController saveController = new SaveController(save, saveView);
                    saveController.saveGame(game);
                    break;

                case "6":
                    String fileName = "SavedGame.json";
                    file = new File("SavedGame.json");
                    load = new Load(file, fileName);
                    loadView = new LoadView(load);
                    loadController = new LoadController(load, loadView);
                    loadController.loadGame();
                    break;

                case "7":
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



