package project1E7;


import project1E7.Controller.*;
import project1E7.Model.*;
import project1E7.View.*;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;

public class theTextAdventure {

    Scanner input = new Scanner(System.in);
    String userName;
    static ArrayList<User> users;
    Room[][] room = new Room[10][10];
    public Random rand = new Random();
    public String controls[] = new String[4];
    ArrayList<Key> keyRing = new ArrayList<>();


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        theTextAdventure myApp = new theTextAdventure();
        Controls control = new Controls("w", "s", "d", "a");

        myApp.controls[0] = control.getMoveUp();
        myApp.controls[1] = control.getMoveDown();
        myApp.controls[2] = control.getMoveRight();
        myApp.controls[3] = control.getMoveLeft();


        int choice;
        choice = myApp.startMenu();

        while (choice == 0) {

            System.out.println("Improper value entered");
            choice = myApp.startMenu();
        }

        if (choice == 1) {


            Random rand = new Random();
            myApp.createWorld();
            Hero theHero = (myApp.selectHero());
            HeroView heroView = new HeroView(theHero);
            HeroController heroController = new HeroController(theHero, heroView);
            heroView.printStats();
            heroView.heroStory();
            Room currentRoom = myApp.room[8][5];
            do {
                boolean run = true;
                Room roomModel = currentRoom;
                RoomView roomView = new RoomView(roomModel);
                RoomController roomController = new RoomController(roomModel, roomView);
                roomView.flavorTextRoom();

                theHero.setKeyRing(myApp.keyRing);
                if (roomModel.getFound() == false) {
                    if (roomController.roomHasMonster()) {
                        Monster monsterModel = roomController.getMonster();
                        MonsterView monsterView = new MonsterView(monsterModel);
                        MonsterController monsterController = new MonsterController(monsterModel, monsterView);


                        int encounterChoice = 0;
                        monsterView.flavorTextMonster();

                        if (heroController.attackFirst(monsterController) == true) {

                            do {
                                encounterChoice = monsterView.encounterMenu();

                                switch (encounterChoice) {

                                    case 1:
                                        if (theHero.isAlive() == true) {
                                            if (heroController.attack(monsterController) == true) {
                                                heroView.hitMonsterFlavorText(monsterModel);
                                                monsterView.printStatus(monsterModel);

                                            } else {
                                                heroView.missMonsterFlavorText(monsterModel);
                                                monsterView.printStatus(monsterModel);
                                            }
                                        }
                                        if (monsterModel.isAlive() == true) {
                                            if (monsterController.attack(heroController) == true) {
                                                monsterView.monsterHitFlavorText(theHero);
                                                heroView.printStatus(theHero);
                                            } else
                                                monsterView.monsterMissFlavorText(theHero);
                                            heroView.printStatus(theHero);
                                        } else {
                                            run = false;
                                        }
                                        run = true;
                                        break;
                                    case 2:
                                        if (heroController.flee(theHero) == true) {
                                            run = false;
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

                                if (monsterController.attack(heroController) == true && monsterModel.isAlive() == true) {
                                    monsterView.monsterHitFlavorText(theHero);
                                    heroView.printStatus(theHero);
                                    encounterChoice = monsterView.encounterMenu();

                                } else
                                    monsterView.monsterMissFlavorText(theHero);
                                heroView.printStatus(theHero);
                                encounterChoice = monsterView.encounterMenu();

                                switch (encounterChoice) {

                                    case 1:
                                        if (theHero.isAlive() == true) {
                                            if (heroController.attack(monsterController) == true) {
                                                heroView.hitMonsterFlavorText(monsterModel);
                                                monsterView.printStatus(monsterModel);


                                            } else
                                                heroView.missMonsterFlavorText(monsterModel);
                                            monsterView.printStatus(monsterModel);
                                        } else {
                                            run = false;
                                        }
                                        run = true;
                                        break;
                                    case 2:
                                        if (heroController.flee(theHero) == true) {

                                            run = false;
                                        } else
                                            run = true;
                                        break;
                                    case 3:
                                        heroView.inventory(theHero.getBackPack());
                                        break;
                                    default:
                                        System.out.println("Please enter a proper value.");
                                }
                            } while (run == true && (monsterModel.isAlive() == true));

                    }
                    int chooseItem = 0;
                    while (theHero.isAlive() == true && run == true) {
                        if (roomController.roomHasItem() == true) {
                            Item item = roomController.getItem();
                            ItemView itemView = new ItemView(item);
                            ItemController itemController = new ItemController(item, itemView);


                            do {
                                itemView.viewItem(item);
                                if (itemController.checkIfTreasure(item) == true) {
                                    Treasure treasure = (Treasure) item;
                                    itemController.checkTreasureValue(treasure);

                                    heroController.addTreasure(treasure.getAmount());
                                    run = false;
                                    break;
                                } else if (itemController.checkIfKey(item)) {
                                    Key key = (Key) item;
                                    KeyView keyView = new KeyView(key);
                                    KeyController keyController = new KeyController(key, keyView);
                                    keyView.foundKey();
                                    myApp.keyRing = heroController.addKey(myApp.keyRing, key);
                                    run = false;
                                    break;
                                } else
                                    itemView.chooseWhatToDoWithItem(item);
                                chooseItem = input.nextInt();
                                switch (chooseItem) {
                                    case 1:
                                        heroController.useItemExternal(item);
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Please enter a proper value.");
                                        break;
                                }

                            } while (chooseItem >= 3 || chooseItem <= 0);


                        } else if (roomController.roomHasItem() == false) {

                            Item item = roomController.setRandomItem();
                            if (item != null) {
                                ItemView itemView = new ItemView(item);
                                ItemController itemController = new ItemController(item, itemView);

                                do {
                                    boolean selected = false;
                                    if (itemController.checkIfTreasure(item) == true) {
                                        Treasure treasure = (Treasure) item;
                                        itemController.checkTreasureValue(treasure);

                                        heroController.addTreasure(treasure.getAmount());
                                        run = false;
                                        break;
                                    } else
                                        itemView.chooseWhatToDoWithItem(item);

                                    while (!selected) {
                                        try {
                                            chooseItem = input.nextInt();
                                            switch (chooseItem) {
                                                case 1:
                                                    heroController.useItemExternal(item);
                                                    run = false;
                                                    break;
                                                case 2:
                                                    break;

                                                default:
                                                    System.out.println("Please enter a proper value.");

                                            }
                                            selected = true;

                                        } catch (InputMismatchException e) {

                                            System.out.println("Invalid choice!");
                                            selected = false;
                                        }
                                    }
                                } while ((chooseItem >= 3 || chooseItem <= 0) && run == true);
                                run = false;
                            }
                            run = false;
                        }
                    }
                }

                roomController.setFound(currentRoom);
                roomView.roomDoors(myApp.room, currentRoom);
                currentRoom = heroController.moveHero(myApp.room, currentRoom);
                run = false;

            } while (theHero.isAlive() == true || theHero.getLives() > 0);


        } else if (choice == 2) {
            System.out.println("Load Game");

        } else if (choice == 3) {

            if (!myApp.printUsers(users)) {

                boolean decision = false;

                while (!decision) {
                    System.out.printf("%n" +
                            "There are no current users, would you like to create a new user? (Yes/No)");

                    String answer = input.nextLine();
                    if (answer == "Yes") {
                        if (!myApp.createUser()) {

                            choice = 0;
                            decision = true;
                        }
                    } else if (answer == "No") {

                        choice = 0;
                        decision = true;
                    } else {

                        System.out.println("Invalid answer!");
                        decision = false;
                    }

                }
            }

        } else if (choice == 4) {
            System.exit(0);

        } else if (choice == 5) {
            {

                int temp = myApp.subMenu();

                switch (temp) {

                    case 0:

                        System.out.println("Exited menu");

                        break;

                    case 1:

                        System.out.println("The following are the commands in place:");

                        System.out.printf("Moving up: %s %n" +
                                "Moving down: %s %n" +
                                "Moving right: %s %n" +
                                "Moving left: %s %n", control.getMoveUp(), control.getMoveDown(), control.getMoveRight(), control.getMoveLeft());

                        break;

                    case 2:

                        boolean chosen = false;

                        while (!chosen) {

                            try {

                                System.out.printf("Which one of the controls would you like to change: ");

                                System.out.printf("1- Moving up: %s %n" +
                                        "2- Moving down: %s %n" +
                                        "3- Moving right: %s %n" +
                                        "4- Moving left: %s %n", control.getMoveUp(), control.getMoveDown(), control.getMoveRight(), control.getMoveLeft());

                                int choice1 = input.nextInt();
                                boolean decided = false;

                                while (!decided) {
                                    switch (choice1) {

                                        case 1:

                                            System.out.print("Enter the new command for moving up: ");
                                            String temp1 = input.nextLine();
                                            while (temp1.length() > 1) {

                                                System.out.printf("%n" +
                                                        "You can only use one character as a command%n");
                                                temp1 = input.nextLine();
                                            }

                                            control.setMoveUp(temp1);

                                            decided = true;

                                            break;

                                        case 2:

                                            System.out.print("Enter the new command for moving down: ");
                                            temp1 = input.nextLine();
                                            while (temp1.length() > 1) {

                                                System.out.printf("%n" +
                                                        "You can only use one character as a command%n");
                                                temp1 = input.nextLine();
                                            }

                                            control.setMoveDown(temp1);

                                            decided = true;

                                            break;

                                        case 3:

                                            System.out.print("Enter the new command for moving right: ");
                                            temp1 = input.nextLine();
                                            while (temp1.length() > 1) {

                                                System.out.printf("%n" +
                                                        "You can only use one character as a command%n");
                                                temp1 = input.nextLine();
                                            }

                                            control.setMoveRight(temp1);

                                            decided = true;

                                            break;


                                        case 4:

                                            System.out.print("Enter the new command for moving left: ");
                                            temp1 = input.nextLine();
                                            while (temp1.length() > 1) {

                                                System.out.printf("%n" +
                                                        "You can only use one character as a command%n");
                                                temp1 = input.nextLine();
                                            }

                                            control.setMoveLeft(temp1);

                                            decided = true;

                                            break;

                                        default:
                                            System.out.printf("%n" +
                                                    "Invalid option%n");
                                            decided = false;
                                    }
                                }

                                chosen = true;

                            } catch (InputMismatchException a) {

                                System.out.println("Invalid choice");

                                chosen = false;
                            }
                        }


                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:

                        break;
                }
            }
        }

    }

    public Hero selectHero() {
        Hero warrior = new Hero(100, 80, 30, "The Warrior...", "Warrior", 40);
        HeroView heroViewWarrior = new HeroView(warrior);
        heroViewWarrior.printStats();

        Hero mage = new Hero(100, 60, 40, "The Mage...", "Mage", 50);
        HeroView heroViewMage = new HeroView(mage);
        heroViewMage.printStats();

        Hero thief = new Hero(1, 40, 60, "The Thief...", "Thief", 60);
        HeroView heroViewThief = new HeroView(thief);
        heroViewThief.printStats();

        boolean selected = true;
        while (selected) {

            int tempCount = 0;

            try {

                System.out.println("Select the hero: ");
                System.out.println("1)Warrior");
                System.out.println("2)Mage ");
                System.out.println("3)Thief ");

                System.out.println("Please enter your choice");

                int userInput = 0;

                if (tempCount == 0) {

                    userInput = input.nextInt();
                } else {
                    input.nextLine();
                    userInput = input.nextInt();
                }

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
            } catch (InputMismatchException e) {

                System.out.printf("%n" +
                        "Invalid answer%n");
            }
        }
        return null;
    }

    public int startMenu() {

        int userInput = 0;
        int tempCount = 0;
        boolean chosen = false;

        do {

            boolean chosen1 = false;
            while (!chosen1) {
                try {
                    System.out.println("1)Start Game");
                    System.out.println("2)Load Game");
                    System.out.println("3)View High Score");
                    System.out.println("4)Quit");

                    if (tempCount == 0) {

                        userInput = input.nextInt();
                    } else {
                        input.nextLine();
                        userInput = input.nextInt();
                    }

                    chosen1 = true;

                } catch (InputMismatchException e) {

                    System.out.println("Invalid answer!");
                    tempCount++;

                    chosen1 = false;
                }
            }

            String correct;
            switch (userInput) {

                case 1:
                    System.out.println("You have selected Start Game is this correct? yes/no");
                    input.nextLine();
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
                case 5:
                    System.out.println("You have selected Submenu is this correct? yes/no");
                    correct = input.nextLine();
                    if (correct.equals("yes")) {
                        System.out.println("Opening submenu");
                        return userInput;
                    } else userInput = 0;
                    break;
                default:
                    System.out.println("Please enter a proper value. ");
                    break;
            }

            chosen = true;

            if ((userInput > 5) || (userInput < 0)) {

                System.out.println("Invalid answer");

                chosen = false;
            }

        } while (!chosen);

        return userInput;
    }


    public int subMenu() {

        int choice = 0;
        boolean chosen = false;

        do {

            boolean chosen1 = false;
            int tempCount = 0;

            while (!chosen1) {

                try {
                    System.out.println("Choose one of the following options. To exit this menu enter 0");
                    System.out.printf("1- View controls %n" +
                            "2- Change controls %n" +
                            "3- View instructions %n" +
                            "4- View map %n" +
                            "5- Save game %n" +
                            "6- Load game %n" +
                            "7- Quit game %n ");

                    choice = input.nextInt();

                    if (tempCount == 0) {

                        choice = input.nextInt();
                    } else {
                        input.nextLine();
                        choice = input.nextInt();
                    }

                    chosen1 = true;
                } catch (InputMismatchException e) {

                    System.out.println("Invalid choice");
                    chosen1 = false;
                    ++tempCount;
                }

                if (choice > 7 || choice < 0) {

                    System.out.println("Choose an available option");

                    chosen = false;
                }
            }
        }
        while (!chosen);

        return choice;
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
        Item itemModelCoffee = coffee;
        ItemView itemViewCoffee = new ItemView(itemModelCoffee);
        ItemController itemControllerCoffee = new ItemController(itemModelCoffee, itemViewCoffee);
        Treasure treasure = new Treasure("Gold Chest", 5000);
        Item itemModelTreasure = treasure;
        ItemView itemViewTreasure = new ItemView(itemModelTreasure);
        ItemController itemControllerTreasure = new ItemController(itemModelTreasure, itemViewTreasure);
        Heart heart = new Heart("Heart");
        Item itemModelHeart = heart;
        ItemView itemViewHeart = new ItemView(itemModelHeart);
        ItemController itemControllerHeart = new ItemController(itemModelHeart, itemViewHeart);
        HealthPotion healthPotion = new HealthPotion("Health portion");
        Item itemModelHealthPotion = healthPotion;
        ItemView itemViewHealthPotion = new ItemView(itemModelHealthPotion);
        ItemController itemControllerHealthPotion = new ItemController(itemModelHealthPotion, itemViewHealthPotion);
        Key goldKey = new Key("Golden key");
        KeyView goldKeyView = new KeyView(goldKey);
        KeyController goldKeyController = new KeyController(goldKey, goldKeyView);
        Key woodenKey = new Key("Wooden key");
        Key stoneKey = new Key("Stone key");
        Key silverKey = new Key("Silver key");
        Key goldenKey = new Key("Golden key");
        Monster theBoss = new Monster(50, 40, 15, "The boss", "The Boss", treasure, true, 4);
        Monster owlBear = new Monster(40, 30, 6, "The owl bear", "The Owl Bear", healthPotion, true, 3);
        Monster skeleton = new Monster(30, 20, 8, "The Skeleton", "The Skeleton", healthPotion, true, 2);
        Monster bat = new Monster(20, 10, 10, "The Bat", "The Bat", coffee, true, 1);
        Monster Slime = new Monster(35,15,2,"The Slime","The Slime",null,true ,2 );
        Monster Spiderling = new Monster(10,6,9,"The Spiderling,","Spiderling",null,true,1 );
        Door woodenDoor = new Door(true, "Wooden Key", "The door is ancient and maybe won't open ");
        Door stoneDoor = new Door(true, "Stone key", "you need need to be careful when you use the key inside this door ,might be broken easily");
        Door goldenDoor = new Door(true, "Golden key", "The golden door takes you out ! you are almost free");
        Door silverDoor = new Door(true, "Silver Key", "This door is bright silver just like the key");
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {

                if (i == 8 && j == 5) {
                    Room roomModel = new Room("The Starting Room", true);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 0 && j == 3) {
                    Room roomModel = new Room("The Exit", false, treasure, goldenDoor, true);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 3) {
                    Room roomModel = new Room("The Boss Room", goldenKey, true, false, theBoss, true);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 1) {
                    Room roomModel = new Room("The Silver Door room", false, coffee, silverDoor, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 5 && j == 8) {
                    Room roomModel = new Room("The Skeleton room", stoneKey, true, false, skeleton, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 && j == 3) {
                    Room roomModel = new Room("The Owl bear room", silverKey, true, false, owlBear, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 7 && j == 8) {
                    Room roomModel = new Room("The wooden door room", false, healthPotion, woodenDoor, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 && j == 8) {
                    Room roomModel = new Room("The Bat room", woodenKey, true, false, bat, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 3 && j == 6) {
                    Room roomModel = new Room(" The Stone Door room", false, heart, stoneDoor, true);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 0 || j == 0 || i == 9 || j == 9 || i == 1 && j == 2 || i == 2 && j == 2
                        || i == 1 && j == 4 || i == 1 && j == 8 || i == 2 && j == 6 || i == 3 && j == 3 || i == 3 && j == 4
                        || i == 3 && j == 7 || i == 4 && j == 1 || i == 4 && j == 3 || i == 4 && j == 4 || i == 4 && j == 5
                        || i == 4 && j == 6 || i == 6 && j == 2 || i == 6 && j == 4 || i == 6 && j == 5 || i == 7 && j == 7
                        || i == 6 && j == 7 || i == 6 && j == 8 || i == 7 && j == 3 || i == 7 && j == 4 || i == 8 && j == 1) {
                    Room roomModel = new Room("wall", false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 || j == 7 || (i == 2 && j == 3) || i == 3) {
                    Room roomModel = new Room("Room description", false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 || i == 7) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, bat, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room("Room description", treasure, true, false, skeleton, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room("Room description", treasure, true, false, owlBear, true);
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
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, bat, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room("Room description", treasure, true, false, skeleton, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room("Room description", treasure, true, false, owlBear, true);
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
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, bat, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room("Room description", treasure, true, false, skeleton, true);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room("Room description", treasure, true, false, owlBear, true);
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
    }

    public void mapPrinter(Room[][] room) {

        for (int i = 0; i < room.length; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                for (int j = 0; j < room[i].length; j++) {
                    if (!room[i][j].getFound()) {
                        if (i1 == 0) {
                            System.out.print("-  -");
                        } else if (i1 == 1) {
                            System.out.print(" ?? ");
                        } else {
                            System.out.print("-  -");
                        }
                    } else if (room[i][j].getDescription().equals("Room")) {
                        if (i1 == 0) {
                            System.out.print("-  -");
                        } else if (i1 == 1) {
                            System.out.print(" -- ");
                        } else {
                            System.out.print("-  -");
                        }
                    } else if (room[i][j].getDescription().equals("Wall")) {
                        if (i1 == 0) {
                            System.out.print("¤¤¤¤");
                        } else if (i1 == 1) {
                            System.out.print("¤¤¤¤");
                        } else {
                            System.out.print("¤¤¤¤");
                        }
                    } else if (room[i][j].getDescription().equals("CurrentRoom")) {
                        if (i1 == 0) {
                            System.out.print(" cD ");
                        } else if (i1 == 1) {
                            System.out.print("iHHi");
                        } else {
                            System.out.print(" || ");
                        }
                    }
                    System.out.print(" ");
                }
                //}
                System.out.println("");
            }
        }
    }

      /*  for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j].getFound()) {
                    System.out.println("Empty");
                } else if (room[i][j].isHasMonster()) {
                    System.out.println("Monster");
                }
            }

        }*/

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
/*
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] == wall) {
                    System.out.print("wall");
                } else if (room[i][j] == null) {
                    System.out.print("* Empty *");
                } else if (room[i][j] == start) {
                    System.out.print("StartPoint");
                } else if (room[i][j] == exit) {
                    System.out.printf("Exit");
                } else if (room[i][j].isHasMonster()) {
                    System.out.print("Monster" + " * ");
                }
                    else System.out.printf("Chance");
                }
            }
            System.out.println();
        }
*/
    public boolean printUsers(ArrayList<User> users) {

        if (users.size() == 0) {

            System.out.printf("%n" +
                    "There are no existing users%n" +
                    "Returning to the start menu%n");

            for (double a = 0; a < 10000000000000000000000000.0; )
                a++;

            return false;
        } else
            for (int i = 0; i < users.size(); i++) {

                System.out.printf("%nUsername: %s%n" +
                        "Highscore: %d%n", users.get(i).getUserName(), users.get(i).getHighScore());
            }
        return true;
    }

    public boolean createUser() {

        System.out.println("You have selected to Create a New User is this correct? yes/no");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("yes")) {

            System.out.printf("Enter your new username:");
            String temp = input.nextLine();
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(temp);
            boolean b = m.find();

            while (!isUpperCase(temp.charAt(0)) || temp.length() > 12 || b) {

                if (!isUpperCase(temp.charAt(0))) {
                    System.out.printf("%n" +
                            "Invalid username! The username must have the first letter as a capital letter");
                }

                if (temp.length() > 12) {
                    System.out.printf("%n" +
                            "Invalid username! Your username must contain a maximum of 12 characters");
                }

                if (b) {
                    System.out.printf("%n" +
                            "Invalid username! Your username cannot contain a special character");
                }

                System.out.printf("%n" +
                        "Please enter a valid user name, to quit enter 'no'%n");

                temp = input.nextLine();

                if (answer.equalsIgnoreCase("no")) {

                    return false;
                }
            }

            User user = new User(temp, 0);
            users.add(user);
            return true;

        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Returning to start menu");
            return false;
        } else System.out.println("Invalid answer!");
        return false;

    }


    public boolean save() {

        System.out.printf("You have selected to Save Game. Is this correct Yes/No");

        String correct = input.nextLine();
        if (correct.equalsIgnoreCase("yes")) {
            System.out.println("Saving game, please do not turn off the system");

            try {

                String saveFile = input.nextLine();
                String verify, putData;
                File file = new File(saveFile);
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                BufferedWriter bWriter = new BufferedWriter(writer);
                bWriter.write((Integer.toString(users.get(users.size()).getHighScore())) + users.get(users.size()).getUserName());
                bWriter.flush();
                bWriter.close();
                FileReader reader = new FileReader(file);
                BufferedReader bReader = new BufferedReader(reader);

                while ((verify = bReader.readLine()) != null) {
                    if (verify != null) {
                        putData = verify.replaceAll("here", "there");
                        bWriter.write(putData);
                    }
                }
                // use this to edit an existing file for the highscore

                bReader.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (correct.equalsIgnoreCase("no")) {
            System.out.println("Saving aborted");
            return false;
        }
        return true;
    }

}
