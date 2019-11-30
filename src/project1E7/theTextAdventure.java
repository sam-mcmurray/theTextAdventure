package project1E7;


import project1E7.Controller.HeroController;
import project1E7.Controller.ItemController;
import project1E7.Controller.MonsterController;
import project1E7.Controller.RoomController;
import project1E7.Model.Hero;
import project1E7.Model.Item;
import project1E7.Model.Monster;
import project1E7.Model.Room;
import project1E7.View.HeroView;
import project1E7.View.ItemView;
import project1E7.View.MonsterView;
import project1E7.View.RoomView;

import java.util.*;

public class theTextAdventure {
    Scanner input = new Scanner(System.in);
    String userName;

    public  Hero warrior = new Hero(100, 80, 30, "The Warrior...", "Warrior", 40);
    public  Hero mage = new Hero(100, 60, 40, "The Mage...", "Mage", 50);
    public  Hero thief = new Hero(100, 40, 60, "The Thief...", "Thief", 60);


    public static void main(String[] args) {

        theTextAdventure myApp = new theTextAdventure();
        int choice = myApp.startMenu();
        if (choice == 1) {
            Room [][] room = new Room[10][10];
            Hero theHero = (myApp.selectHero());
            HeroView heroView = new HeroView(theHero);
            heroView.printStats();
            myApp.story();
            HeroController heroController = new HeroController(theHero, heroView);
            for (int i = 0;; i++) { //this will become a do while when the leaving room is chosen while(currentRoom != leavingRoom)
                Room currentRoom = room[0][0];
                Room previousRoom = room[0][0];
                RoomView roomView = new RoomView(currentRoom);
                RoomController roomController = new RoomController(currentRoom, roomView);
                Monster monster = roomController.getMonster(currentRoom);
                MonsterView monsterView = new MonsterView(monster);
                MonsterController monsterController = new MonsterController(monster, monsterView);

                if (roomController.roomHasMonster() == true) {

                    boolean run = true;
                    int encounterChoice = 0;
                    System.out.println("Flavor text monster present");

                   if (heroController.attackFirst(monsterController) == true) {

                       do {
                           monsterView.encounterMenu();

                           switch (encounterChoice) {

                               case 1:
                                   if (heroController.attack(monsterController) == true) {
                                       System.out.println("Flavor text hit");
                                       monsterView.printStatus(monster);

                                   } else
                                       System.out.println("flavor text miss");
                                   monsterView.printStatus(monster);

                                   if (monsterController.attack(heroController) == true) {
                                       System.out.println("flvaor text hit");
                                       heroView.printStatus(theHero);

                                   } else
                                       System.out.println("flavor text miss");
                                   heroView.printStatus(theHero);
                                   break;
                               case 2:
                                    if (heroController.flee(theHero) == true){
                                        currentRoom = previousRoom;
                                        run = false;
                                    } else
                                        run = true;
                                    break;
                               case 3:
                                    heroView.inventory(theHero);
                                    break;
                               default:
                                   System.out.println("Please enter a proper value.");
                           }
                       } while (run == true) ;

                   } else

                       do {

                           if (monsterController.attack(heroController) == true) {
                               System.out.println("flavor text hit");
                               heroView.printStatus(theHero);
                               monsterView.encounterMenu();
                           } else
                               System.out.println("flavor text miss");
                           heroView.printStatus(theHero);
                           monsterView.encounterMenu();

                           switch (encounterChoice) {

                               case 1:

                                   if (heroController.attack(monsterController) == true) {
                                       System.out.println("Flavor text hit");
                                       monsterView.printStatus(monster);


                                   } else
                                       System.out.println("flavor text miss");
                                   monsterView.printStatus(monster);
                                   break;
                               case 2:
                                   if (heroController.flee(theHero) == true) {
                                       currentRoom = previousRoom;
                                       run = false;
                                   } else
                                       run = true;
                                   break;
                               case 3:
                                   heroView.inventory(theHero);
                                   break;
                               default:
                                   System.out.println("Please enter a proper value.");
                           }
                       } while (run == true);

                } if (roomView.roomHasItem(currentRoom) == true) {
                    Item item = roomController.getItem(currentRoom);
                    ItemView itemView = new ItemView(item);
                    ItemController itemController = new ItemController(item, itemView);
                    itemView.viewItem(item);
                    

                } else if (roomView.roomHasItem(currentRoom) == false){
                    Item item = roomController.getItem(currentRoom);
                    ItemView itemView = new ItemView(item);
                    ItemController itemController = new ItemController(item, itemView);
                    item = itemController.setRandomItem();
                    if (item != null) {
                        itemView.viewItem(item);
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

    public void story() {
        System.out.println("flavor text story or call from another method ");
    }
}
