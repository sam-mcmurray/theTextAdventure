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

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;

public class theTextAdventure {
    Scanner input = new Scanner(System.in);
    String userName;
    static ArrayList<User> users;

    public Hero warrior = new Hero(100, 80, 30, "The Warrior...", "Warrior", 40);
    public Hero mage = new Hero(100, 60, 40, "The Mage...", "Mage", 50);
    public Hero thief = new Hero(100, 40, 60, "The Thief...", "Thief", 60);
    public Room[][] room = new Room[10][10];
    public Coffee coffee = new Coffee("Coffee");
    public Treasure treasure = new Treasure("Gold Box", 10);
    public Heart heart = new Heart("Heart");
    public HealthPotion healthPotion = new HealthPotion("Health portion");
    public Random rand = new Random();
    public Key woodenKey = new Key("Wooden key");
    public Key stoneKey = new Key("Stone key");
    public Key silverKey = new Key("Silver key");
    public Key goldenKey = new Key("Golden key");
    public Monster boss = new Monster(50, 40, 15, "The boss", "The Boss", treasure, true, 4);
    public Monster owlBear = new Monster(40, 30, 6, "The owl bear", "The Owl Bear", healthPotion, true, 3);
    public Monster skeleton = new Monster(30, 20, 8, "The owl bear", "The Owl Bear", healthPotion, true, 2);
    public Monster bat = new Monster(20, 10, 10, "The Bat", "The Bat", coffee, true, 1);
    public Door woodenDoor = new Door(true, "wooden Key", "The door is ancient and maybe won't open ");
    public Door stoneDoor = new Door(true, "stone key", "you need need to be careful when you use the key inside this door ,might be broken easily");
    public Door goldenDoor = new Door(true, "golden key", "The golden door takes you out ! you are almost free");


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        theTextAdventure myApp = new theTextAdventure();
        int choice = myApp.startMenu();

        Room[][] room = new Room[10][10];


        if (choice == 1) {

            Hero theHero = (myApp.selectHero());
            HeroView heroView = new HeroView(theHero);
            heroView.printStats();
            myApp.story();
            HeroController heroController = new HeroController(theHero, heroView);
            for (int i = 0; ; i++) { //this will become a do while when the leaving room is chosen while(currentRoom != leavingRoom)
                Room currentRoom = room[0][0];
                Room previousRoom = room[0][0];
                RoomView roomView = new RoomView(currentRoom);
                RoomController roomController = new RoomController(currentRoom, roomView);


                boolean fleeRun2 = true;
                if (roomController.roomHasMonster() == true) {
                    Monster monster = roomController.getMonster(currentRoom);
                    MonsterView monsterView = new MonsterView(monster);
                    MonsterController monsterController = new MonsterController(monster, monsterView);
                    boolean run = true;
                    int encounterChoice = 0;
                    System.out.println("Flavor text monster present");

                    if (heroController.attackFirst(monsterController) == true) {

                        do {
                            monsterView.encounterMenu();
                            encounterChoice = input.nextInt();
                            switch (encounterChoice) {

                                case 1:
                                    if (heroController.attack(monsterController) == true) {
                                        System.out.println("Flavor text hit");
                                        monsterView.printStatus(monster);

                                    } else
                                        System.out.println("flavor text miss");
                                    monsterView.printStatus(monster);

                                    if (monsterController.attack(heroController) == true) {
                                        System.out.println("flavor text hit");
                                        heroView.printStatus(theHero);

                                    } else
                                        System.out.println("flavor text miss");
                                    heroView.printStatus(theHero);
                                    break;
                                case 2:
                                    if (heroController.flee(theHero) == true) {
                                        currentRoom = previousRoom;
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
                        } while (run == true);

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
                                        monsterView.printStatus(monster);


                                    } else
                                        System.out.println("flavor text miss");
                                    monsterView.printStatus(monster);
                                    break;
                                case 2:
                                    if (heroController.flee(theHero) == true) {
                                        currentRoom = previousRoom;
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
                        } while (run == true);

                }
                int chooseItem = 0;
                while (theHero.isAlive() == true && fleeRun2 == true) {
                    if (roomView.roomHasItem(currentRoom) == true) {
                        Item item = roomController.getItem(currentRoom);
                        ItemView itemView = new ItemView(item);
                        ItemController itemController = new ItemController(item, itemView);
                        fleeRun2 = false;

                        do {
                            itemView.viewItem(item);
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
                        } while (chooseItem >= 3 || chooseItem <= 0);


                    } else if (roomView.roomHasItem(currentRoom) == false) {

                        Item item = roomController.setRandomItem();
                        fleeRun2 = false;
                        if (item != null) {
                            ItemView itemView = new ItemView(item);
                            ItemController itemController = new ItemController(item, itemView);
                            do {
                                itemView.viewItem(item);
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
                            } while (chooseItem >= 3 || chooseItem <= 0);
                        }
                    }
                }
            }

        } else if (choice == 2) {
            System.out.println("Load Game");

        } else if (choice == 3) {

            if (!myApp.printUsers(users)) {

                System.out.printf("%n" +
                        "There are no current users, would you like to create a new user? (yes/no)");
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    if (!myApp.createUser()) {

                        myApp.startMenu();
                    }
                }

            } else if (choice == 4) {
                System.exit(0);
            }

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

    public void story() {
        System.out.println("flavor text story or call from another method ");
    }


    private void createWorld() {

        Room wall = new Room("wall", null, false, false, null, false);
        Room start = new Room("Start", null, false, false, null, false);
        Room exit = new Room("The Exit", null, false, true, null, false);
        Room bossRoom = new Room("Boss room", goldenKey, true, true, boss, true);
        Room batRoom = new Room("bat room", woodenKey, true, true, bat, true);
        Room owlBrearRoom = new Room("owl bear room", silverKey, true, true, owlBear, true);
        Room skeletonRoom = new Room("Skeleton room", stoneKey, true, true, skeleton, true);
        Room room1 = new Room("Room description", healthPotion, false, true, null, true);
        Room room2 = new Room("Room description", heart, false, true, null, true);
        Room room3 = new Room("Room description", treasure, false, true, null, true);
        Room room4 = new Room("Room description", coffee, false, true, null, true);
        Room room5 = new Room("Room description", healthPotion, false, true, null, true);
        Room[] roomsNotEmpty = {room1, room2, room3, room4, room5};
        //Boss warning

        // wall
        room[8][5] = start;
        room[0][4] = exit;
        room[1][3] = bossRoom;
        room[0][0] = wall;
        room[0][1] = wall;
        room[0][2] = wall;
        room[0][4] = wall;
        room[0][5] = wall;
        room[0][6] = wall;
        room[0][7] = wall;
        room[0][8] = wall;
        room[0][9] = wall;
        room[1][0] = wall;
        room[1][2] = wall;
        room[1][4] = wall;
        room[1][8] = wall;
        room[1][9] = wall;
        room[2][0] = wall;
        room[2][2] = wall;
        room[2][6] = wall;
        room[2][9] = wall;
        room[3][0] = wall;
        room[3][3] = wall;
        room[3][4] = wall;
        room[3][7] = wall;
        room[3][9] = wall;
        room[4][0] = wall;
        room[4][1] = wall;
        room[4][3] = wall;
        room[4][4] = wall;
        room[4][5] = wall;
        room[4][6] = wall;
        room[4][9] = wall;
        room[5][0] = wall;
        room[5][8] = skeletonRoom;
        room[5][9] = wall;
        room[6][0] = wall;
        room[6][2] = wall;
        room[6][3] = owlBrearRoom;
        room[6][4] = wall;
        room[6][5] = wall;
        room[6][7] = wall;
        room[6][8] = wall;
        room[6][9] = wall;
        room[7][0] = wall;
        room[7][3] = wall;
        room[7][4] = wall;
        room[7][7] = wall;
        room[7][9] = wall;
        room[8][0] = wall;
        room[8][1] = wall;
        room[8][8] = batRoom;
        room[8][9] = wall;
        room[9][0] = wall;
        room[9][1] = wall;
        room[9][2] = wall;
        room[9][3] = wall;
        room[9][4] = wall;
        room[9][5] = wall;
        room[9][6] = wall;
        room[9][7] = wall;
        room[9][8] = wall;
        room[9][9] = wall;
        // random generate
       /* for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {

                row = rand.nextInt(10);
                col = rand.nextInt(10);
                rooms[row][col] = room1;

            }
        }*/

        // random generate

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                int x = rand.nextInt(10);
                int y = rand.nextInt(10);
                int z = rand.nextInt(9);
                if (room[x][y] != wall & room[x][y] != start & ! room[x][y].isHasMonster()) {
                    room[x][y] = roomsNotEmpty[z];
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

        for (int i = 0; i < room.length; i++) {
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

        public boolean printUsers (ArrayList < User > users) {

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

        public boolean createUser () {

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

        public boolean save () {

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

                    /*while ((verify = bReader.readLine()) != null) {
                        if (verify != null) {
                            putData = verify.replaceAll("here", "there");
                            bWriter.write(putData);
                        }
                    }
                    use this to edit an existing file for the highscore
                     */
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

