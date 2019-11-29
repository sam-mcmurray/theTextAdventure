package project1E7;

import project1E7.Controller.HeroController;
import project1E7.Controller.MonsterController;
import project1E7.Controller.RoomController;
import project1E7.Model.Hero;
import project1E7.Model.Monster;
import project1E7.Model.Room;
import project1E7.View.HeroView;
import project1E7.View.MonsterView;
import project1E7.View.RoomView;

import java.util.*;

public class TheTextAdventure {
    Scanner input = new Scanner(System.in);
    String userName;

    public  Hero warrior = new Hero(100, 80, 30, "The Warrior...", "Warrior", 40);
    public  Hero mage = new Hero(100, 60, 40, "The Mage...", "Mage", 50);
    public  Hero thief = new Hero(100, 40, 60, "The Thief...", "Thief", 60);

    public static void main(String[] args) {

        TheTextAdventure myApp = new TheTextAdventure();
        int choice = myApp.startMenu();
        if (choice == 1) {
            Room [][] room = new Room[10][10];
            Hero theHero = (myApp.selectHero());
            HeroView heroView = new HeroView(theHero);
            heroView.printStats();
            myApp.story();
            HeroController heroController = new HeroController(theHero, heroView);
            for (int i = 0;; i++) {
                Room currentRoom = room[0][0];
                RoomView roomView = new RoomView(currentRoom);
                RoomController roomController = new RoomController(currentRoom, roomView);
                Monster monster = roomController.getMonster(currentRoom);
                MonsterView monsterView = new MonsterView(monster);
                MonsterController monsterController = new MonsterController(monster, monsterView);
                if (roomController.roomHasMonster() == true) {
                   if (heroController.attackFirst(theHero, monster) == true) {
                       if (heroController.attack(monsterController) == true) {

                       }
                   }
                }
            }

        } else if (choice == 2) {
            System.out.println("Load Game");

        } else if (choice == 3) {
            System.out.println("View HighScore");

        } else if (choice == 4) {
            System.exit(0);
        }

    }

    public Hero selectHero() {
        HeroView heroViewWarrior = new HeroView(warrior);
        heroViewWarrior.printStats();

        HeroView heroViewMage = new HeroView(mage);
        heroViewMage.printStats();


        HeroView heroViewThief = new HeroView(thief);
        heroViewThief.printStats();


        boolean selected = true;
        while (selected == true) {

            System.out.println("Select Character :" +
                    " \n 1.Warrior : \n 2.Mage : \n 3.Thief");

            System.out.println("Please enter your choice");
            int userInput = input.nextInt();
            input.nextLine();
            switch (userInput) {
                case 1:
                    selected = heroViewWarrior.selectHero(warrior);
                    if (selected == false) {
                        return warrior;
                    } else
                        selected = true;
                    break;
                case 2:
                    selected = heroViewWarrior.selectHero(mage);
                    if (selected == false) {
                        return mage;
                    } else
                        selected = true;
                    break;
                case 3:
                    selected = heroViewWarrior.selectHero(thief);
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

    public int startMenu() {
        System.out.println("1.Start Game\n2.Load Game\n3.View High Scores \n4.Quit");
        int userInput = input.nextInt();
        do {

             String correct;
            switch (userInput) {
                case 1:
                    System.out.println("You have selected Start Game is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes")) {
                        System.out.println("The game is Starting");
                    } else userInput = 0;
                    break;
                case 2:
                    System.out.println("You have selected to Load a saved Game is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes")) {
                        System.out.println("The game is Starting");
                    } else userInput = 0;
                    break;
                case 3:
                    System.out.println("You have selected to View HighScore is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes")) {
                        System.out.println("High Score");
                    } else userInput = 0;
                    break;
                case 4:
                    System.out.println("You have selected Quit is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes")) {
                        System.out.println("Quiting Game");
                    } else userInput = 0;
                    break;
                default:
                    System.out.println("Please enter a proper value. ");
                    break;
            }
        } while (userInput >= 5 && userInput <= 0);
        return userInput;
    }

    public void setUserName() {

        this.userName = userName;
    }

    public void encounterMenu() {
        System.out.printf("%nYou have encountered a monster!%n" +
                "What is your next move?%n" +
                "To run away enter 'flee'%n" +
                "To fight enter 'fight' %n" +
                "To use one of your item enter 'item'%n");

        String temp = input.nextLine();

    }
    public void story() {
        System.out.println("The story description...");
    }
}
