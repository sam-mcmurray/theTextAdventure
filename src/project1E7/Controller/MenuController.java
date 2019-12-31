package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    MenuView view;
    Scanner input = new Scanner(System.in);

    public MenuController(MenuView view) {
        this.view = view;
    }

    public boolean encounterHeroFirst(Hero theHero, HeroView heroView, HeroController heroController, Monster monsterModel,
                                      MonsterView monsterView, MonsterController monsterController) {

        boolean run = true;
        String encounterChoice = "0";
        do {
            view.encounterMenu();
            encounterChoice = input.nextLine();
            switch (encounterChoice) {

                case "1":
                    if (theHero.isAlive() == true) {
                        if (heroController.attack(monsterController) == true) {
                            heroView.hitMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();
                        } else {
                            heroView.missMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();
                        }
                    }
                    if (monsterModel.isAlive() == true) {
                        if (monsterController.attack(heroController) == true) {
                            monsterView.monsterHitFlavorText(theHero);
                            heroView.printStatus(theHero);
                        } else
                            monsterView.monsterMissFlavorText(theHero);
                        heroView.printStatus(theHero);
                    }
                    run = true;
                    break;
                case "2":
                    if (heroController.flee(theHero) == true) {
                        heroController.turnCounter();
                        run = false;
                    } else
                        heroController.turnCounter();
                        run = true;

                    break;
                case "3":
                    heroController.turnCounter();
                    heroView.inventory(theHero.getBackPack());
                    break;
                default:
                    System.out.println("Please enter a proper value.");
                    run = true;
                    break;
            }

        } while (run == true && (monsterModel.isAlive() == true && theHero.isAlive() == true));
        return run;
    }
    public boolean encounterMonsterFirst(Hero theHero, HeroView heroView, HeroController heroController, Monster monsterModel,
                                         MonsterView monsterView, MonsterController monsterController) {
        String encounterChoice = "0";
        boolean run = true;
        monsterView.encounter(monsterModel);
        do {

            if (monsterController.attack(heroController) == true && monsterModel.isAlive() == true) {
                monsterView.monsterHitFlavorText(theHero);
                heroView.printStatus(theHero);
                view.encounterMenu();
                encounterChoice = input.nextLine();

            } else
                monsterView.monsterMissFlavorText(theHero);
            heroView.printStatus(theHero);
            view.encounterMenu();
            encounterChoice = input.nextLine();


            switch (encounterChoice) {

                case "1":
                    if (theHero.isAlive() == true) {
                        if (heroController.attack(monsterController) == true) {
                            heroView.hitMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();

                        } else
                            heroView.missMonsterFlavorText(monsterModel);
                            monsterView.printStatus(monsterModel);
                            heroController.turnCounter();

                        }
                    run = true;
                    break;
                case "2":
                    if (heroController.flee(theHero) == true) {
                        heroController.turnCounter();
                        run = false;
                        return run;
                    } else
                        heroController.turnCounter();
                        run = true;
                    break;
                case "3":
                    heroView.inventory(theHero.getBackPack());
                    heroController.turnCounter();
                    break;
                default:
                    System.out.println("Please enter a proper value.");
                    break;
            }
        } while (run == true && (monsterModel.isAlive() == true && theHero.isAlive() == true));
        return run;
    }
    public Hero selectHero() {
        Hero warrior = new Hero(100, 70, 30, "The Warrior...", "Warrior", 100, "Warrior");
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
                    if (selected == false) {
                        return warrior;
                    } else
                        selected = true;
                    break;
                case "2":
                    selected = heroViewWarrior.selectHero(mage);
                    mage.setCharacterClass("Mage");
                    if (selected == false) {
                        return mage;
                    } else
                        selected = true;
                    break;
                case "3":
                    selected = heroViewWarrior.selectHero(thief);
                    thief.setCharacterClass("Thief");
                    if (selected == false) {
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
                    } else ;
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


        } while (run == true);

        return userInput;
    }

    public void subMenu(ControlsController controlsController, ControlsView controlsView, MapView mapView, Room[][] room,
                        Hero theHero, HeroView heroView, Room currentRoom, Controls controls, User user){
        view.subMenu();
        boolean run = true;

        do {
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

                    break;

                case "4":
                    mapView.mapPrinter(room);
                    break;

                case "5":
                    Save save = new Save();
                    save.saveGame(room,currentRoom,theHero,controls,user);
                    break;

                case "6":

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
        } while (run == true);
    }
}



