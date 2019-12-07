package project1E7;


import project1E7.Controller.HeroController;
import project1E7.Controller.ItemController;
import project1E7.Controller.MonsterController;
import project1E7.Controller.RoomController;
import project1E7.Model.*;
import project1E7.View.HeroView;
import project1E7.View.ItemView;
import project1E7.View.MonsterView;
import project1E7.View.RoomView;

import java.util.*;

public class theTextAdventure {
    Scanner input = new Scanner(System.in);
    String userName;
    Room[][] room = new Room[10][10];
    public Treasure treasure;
    public Key key;
    public Random rand = new Random();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        theTextAdventure myApp = new theTextAdventure();
        int choice = myApp.startMenu();

        if (choice == 1) {
            Random rand = new Random();
            myApp.createWorld();
            Hero theHero = (myApp.selectHero());
            HeroView heroView = new HeroView(theHero);
            HeroController heroController = new HeroController(theHero, heroView);
            heroView.printStats();
            heroView.heroStory();
            Room currentRoom = myApp.room[8][5];

            do { //this will become a do while when the leaving room is chosen while(currentRoom != leavingRoom)
                boolean fleeRun2 = true;
                Room roomModel = currentRoom;
                RoomView roomView = new RoomView(roomModel);
                RoomController roomController = new RoomController(roomModel, roomView);

                if (roomController.roomHasMonster()) {
                    Monster monsterModel = roomController.getMonster();
                    MonsterView monsterView = new MonsterView(monsterModel);
                    MonsterController monsterController = new MonsterController(monsterModel, monsterView);

                    boolean run = true;
                    int encounterChoice = 0;
                    System.out.println("Flavor text monster present");

                    if (heroController.attackFirst(monsterController) == true) {

                        do {
                            monsterView.encounterMenu();
                            encounterChoice = input.nextInt();
                            switch (encounterChoice) {

                                case 1:
                                    if (monsterModel.isAlive() == true && theHero.isAlive() == true){
                                    if (heroController.attack(monsterController) == true) {
                                        System.out.println("Flavor text hit");
                                        monsterView.printStatus(monsterModel);
                                    } else
                                        System.out.println("flavor text miss");
                                    monsterView.printStatus(monsterModel);
                                } else
                                    if (monsterController.attack(heroController) == true ) {
                                        System.out.println("flavor text hit");
                                        heroView.printStatus(theHero);

                                    } else
                                        System.out.println("flavor text miss");
                                    heroView.printStatus(theHero);
                                    break;
                                case 2:
                                    if (heroController.flee(theHero) == true) {
                                        run = false;
                                        fleeRun2 = false;
                                    } else
                                        run = true;
                                    break;
                                case 3:
                                    heroView.inventory(theHero.getBackPack());
                                    break;
                                default:
                                    System.out.println("Please enter a proper value.");
                            }
                        } while (run == true && (monsterModel.isAlive() == true && theHero.isAlive() == true));

                    } else

                        do {

                            if (monsterController.attack(heroController) == true) {
                                System.out.println("flavor text hit");
                                heroView.printStatus(theHero);
                                monsterView.encounterMenu();
                                encounterChoice = input.nextInt();
                            } else
                                System.out.println("flavor text miss");
                            heroView.printStatus(theHero);
                            monsterView.encounterMenu();
                            encounterChoice = input.nextInt();
                            switch (encounterChoice) {

                                case 1:

                                    if (heroController.attack(monsterController) == true) {
                                        System.out.println("Flavor text hit");
                                        monsterView.printStatus(monsterModel);


                                    } else
                                        System.out.println("flavor text miss");
                                    monsterView.printStatus(monsterModel);
                                    break;
                                case 2:
                                    if (heroController.flee(theHero) == true) {

                                        run = false;
                                        fleeRun2 = false;
                                    } else
                                        run = true;
                                    break;
                                case 3:
                                    heroView.inventory(theHero.getBackPack());
                                    break;
                                default:
                                    System.out.println("Please enter a proper value.");
                            }
                        } while (run == true&& (monsterModel.isAlive() == true && theHero.isAlive() == true));

                }
                int chooseItem = 0;
                while (theHero.isAlive() == true && fleeRun2 == true) {
                    if (roomController.roomHasItem() == true) {
                        Item item = roomController.getItem();
                        ItemView itemView = new ItemView(item);
                        ItemController itemController = new ItemController(item, itemView);
                        fleeRun2 = false;

                        do {
                            itemView.viewItem(item);
                            if (itemController.checkUseItem(item) == true) {
                                System.out.println("Would you like to use " + item + "or save in your satchel?" +
                                        "\n 1)Use " + item + "\n 2) Save " + item + " in satchel");
                                switch (chooseItem) {
                                    case 1:
                                        heroController.useItemExternal(item);
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Please enter a proper value.");
                                }
                            }
                        } while (chooseItem >= 3 || chooseItem <= 0);


                    } else if (roomController.roomHasItem() == false) {

                        Item item = roomController.setRandomItem();
                        fleeRun2 = false;
                        if (item != null) {
                            ItemView itemView = new ItemView(item);
                            ItemController itemController = new ItemController(item, itemView);
                            if (item != myApp.treasure || item != myApp.key) {
                                do {
                                    System.out.println("Would you like to use " + item.getName() + "or save in your satchel?" +
                                            "\n 1)Use " + item.getName() + "\n 2)Save " + item.getName() + " in satchel");
                                    chooseItem = input.nextInt();
                                    switch (chooseItem) {
                                        case 1:
                                            heroController.useItemExternal(item);
                                            break;
                                        case 2:
                                            break;
                                        default:
                                            System.out.println("Please enter a proper value.");
                                    }

                                } while (chooseItem >= 3 || chooseItem <= 0);
                            } else if (item == myApp.treasure) {
                                heroController.addTreasure(item);
                                heroView.currentTreasure();
                            }
                        }
                    }
                }
            } while (theHero.isAlive() == true);

        } else if (choice == 2) {
            System.out.println("Load Game");

        } else if (choice == 3) {
            System.out.println("View HighScore");

        } else if (choice == 4) {
            System.exit(0);
        }

    }

    public Hero selectHero() {
        Hero warrior = new Hero(100, 80, 30, "The Warrior...", "Warrior", 40);
        HeroView heroViewWarrior = new HeroView(warrior);
        heroViewWarrior.printStats();

        Hero mage = new Hero(100, 60, 40, "The Mage...", "Mage", 50);
        HeroView heroViewMage = new HeroView(mage);
        heroViewMage.printStats();

        Hero thief = new Hero(100, 40, 60, "The Thief...", "Thief", 60);
        HeroView heroViewThief = new HeroView(thief);
        heroViewThief.printStats();


        boolean selected = true;
        while (selected == true) {

            System.out.println("Select the hero: ");
            System.out.println("1)Warrior");
            System.out.println("2)Mage ");
            System.out.println("3)Thief ");

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
        System.out.println("1)Start Game");
        System.out.println("2)Load Game");
        System.out.println("3)View High Score");
        System.out.println("4)Quit");

        int userInput = input.nextInt();
        do {
            input.nextLine();
            String correct;
            switch (userInput) {
                case 1:
                    System.out.println("You have selected Start Game is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equalsIgnoreCase("yes")) {
                        System.out.println("The game is Starting");
                        return userInput;
                    } else userInput = 0;
                    break;
                case 2:
                    System.out.println("You have selected to Load a saved Game is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equals("yes")) {
                        System.out.println("The game is Starting");
                        return userInput;
                    } else userInput = 0;
                    break;
                case 3:
                    System.out.println("You have selected to View HighScore is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equals("yes")) {
                        System.out.println("High Score");
                        return userInput;
                    } else userInput = 0;
                    break;
                case 4:
                    System.out.println("You have selected Quit is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equals("yes")) {
                        System.out.println("Quiting Game");
                        return userInput;
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

    public void createWorld() {


        // random generate
       /* for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {

                row = rand.nextInt(10);
                col = rand.nextInt(10);
                rooms[row][col] = room1;

            }
        }*/

        Coffee coffee = new Coffee("Coffee");
        Treasure treasure = new Treasure("Gold Box", 10);
        Heart heart = new Heart("Heart");
        HealthPotion healthPotion = new HealthPotion("Health portion");
        Key goldKey = new Key("Golden key");
        Monster monster1 = new Monster(50, 40, 15, "Monster 1", "The Monster", treasure, true, 3);
        MonsterView monsterView = new MonsterView(monster1);
        MonsterController monsterController = new MonsterController(monster1, monsterView);
        Monster monster2 = new Monster(40, 30, 10, "Monster 2", "The Monster", coffee, true, 2);
        MonsterView monster2View = new MonsterView(monster2);
        MonsterController monster2Controller = new MonsterController(monster2, monster2View);
        Monster monster3 = new Monster(30, 20, 8, "Monster 3", "The Monster", healthPotion, true, 1);
        MonsterView monster3View = new MonsterView(monster3);
        MonsterController monster3Controller = new MonsterController(monster3, monster3View);
        Monster boss = new Monster(100, 40, 60, "the boss...", "The Boss ", goldKey, true, 40);
        MonsterView monsterViewBoss = new MonsterView(boss);
        MonsterController monsterControllerBoss = new MonsterController(boss, monsterViewBoss);
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (i == 8 && j == 5) {
                    Room roomModel = new Room("Room description", true);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                } else if (i == 0 && j == 3) {
                    Room roomModel = new Room("Room description", false);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 3) {
                    Room roomModel = new Room("Room Description", treasure, true, false, boss, true);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if ((i == 1 && j == 1) || (i == 3 && j == 6)) {
                    Room roomModel = new Room("Room Description", false, heart, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 5 && j == 8) {
                    Room roomModel = new Room("Room description", healthPotion, true, false, monster1, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 && j == 3) {
                    Room roomModel = new Room("Room description", coffee, true, false, monster2, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 7 && j == 8) {
                    Room roomModel = new Room("Room Description", false, treasure, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;
                } else if (i == 0 || j == 0 || i == 9 || j == 9 || i == 4) {
                    Room roomModel = new Room("Room description", false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 || j == 7 || (i == 2 && j == 3) || i == 3) {
                    Room roomModel = new Room("Room description", false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 || i == 7) {
                    int chanceForMonster = rand.nextInt(2);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, monster1, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room("Room Descrition", false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 5) {
                    int chanceForMonster = rand.nextInt(2);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, monster2, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room("Room Descrition", false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 1 || i == 2) {
                    int chanceForMonster = rand.nextInt(2);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, monster3, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room("Room Descrition", false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    }
                }
            }

        }


//
//
//                if (rooms[i][j] != null) {
//                    System.out.print("Full" + "*");
//                } else if (rooms[i][j] == null) {
//                    System.out.print("Empty" + "*");
//                }
//            }
//            System.out.println();
//        }
 /*       for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] == wall) {
                    System.out.print("---------");
                } else if (room[i][j] == null) {
                    System.out.print("* Empty *");
                } else if (room[i][j] == start) {
                    System.out.print("StartPoint");
                } else System.out.print("Chance" + " * ");
            }
            System.out.println();
        }*/

    }
}

