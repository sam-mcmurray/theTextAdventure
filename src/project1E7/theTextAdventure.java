package project1E7;


import com.google.gson.Gson;
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

    ArrayList<Key> keyRing = new ArrayList<>();


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        theTextAdventure myApp = new theTextAdventure();

        Controls control = new Controls("w", "s", "d", "a");
        ControlsView controlsView = new ControlsView(control);
        ControlsController controlsController = new ControlsController(control, controlsView);

        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);

        String choice = menuController.startMenu();

        MapView mapView = new MapView();
        MapController mapController = new MapController(mapView);


        if (choice.equals("1")) {



            Random rand = new Random();
            mapController.createWorld(myApp.room);
            Hero theHero = (menuController.selectHero());
            HeroView heroView = new HeroView(theHero);
            HeroController heroController = new HeroController(theHero, heroView);
            heroView.printStats();
            heroView.heroStory();
            Room currentRoom = myApp.room[8][5];
            boolean flee = false;
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

                        monsterView.flavorTextMonster();

                        monsterView.encounter(monsterModel);
                        if (heroController.attackFirst(monsterController) == true) {

                            if (menuController.encounterHeroFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController)) {
                                flee = false;
                            } else {
                                flee = true;
                            }

                        } else {

                            if (menuController.encounterMonsterFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController)) {
                                flee = false;
                            } else {
                                flee = true;
                            }
                        }

                    }

                    while ((theHero.isAlive() == true && run == true) && flee == false) {
                        if (roomController.roomHasItem() == true) {
                            Item item = roomController.getItem();
                            ItemView itemView = new ItemView(item);
                            ItemController itemController = new ItemController(item, itemView);
                            run = itemController.encounterItem(item, heroController, myApp.keyRing);


                        } else if (roomController.roomHasItem() == false) {

                            Item item = roomController.setRandomItem();
                            if (item != null) {
                                ItemView itemView = new ItemView(item);
                                ItemController itemController = new ItemController(item, itemView);
                                run = itemController.encounterItem(item, heroController, myApp.keyRing);

                            }
                        }
                    }
                }

                roomController.setFound(currentRoom);
                roomView.roomDoors(myApp.room, currentRoom);
                currentRoom = heroController.moveHero(myApp.keyRing,myApp.room, currentRoom);
                run = false;

            } while (theHero.isAlive() == true || theHero.getLives() > 0);


        } else if (choice.equals("2")) {
            System.out.println("Load Game");
            Hero witcher = new Hero(10, 10, 10, "10", "10", 10, "10");
            Monster monster = new Monster(10,10, 10, "test", "test", null, true, 10);
            Gson gson = new Gson();
            String json = gson.toJson(witcher);
            System.out.println(json);
        } else if (choice.equals("3")) {

            if (!myApp.printUsers(users)) {

                boolean decision = false;

                while (!decision) {
                    System.out.printf("%n" +
                            "There are no current users, would you like to create a new user? (Yes/No)");

                    String answer = input.nextLine();
                    if (answer == "Yes") {
                        if (!myApp.createUser()) {

                            choice.equals("0");
                            decision = true;
                        }
                    } else if (answer == "No") {

                        choice.equals("0");
                        decision = true;
                    } else {

                        System.out.println("Invalid answer!");
                        decision = false;
                    }

                }
            }

        } else if (choice.equals("4")) {
            System.exit(0);

        }
    }


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
        Test(1, 2);
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

    /**
     * Does nothing
     * @param param1
     * @param param2
     */
    public void Test(int param1, int param2){

    }

}
