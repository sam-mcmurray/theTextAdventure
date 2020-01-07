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

    static ArrayList<User> userz = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        theTextAdventure myApp = new theTextAdventure();

        MapView mapView = new MapView();
        MapController mapController = new MapController(mapView);
        Menu menu = new Menu();
        MenuView menuView = new MenuView(menu);
        MenuController menuController = new MenuController(menuView,menu);
        GameManager gameManager = new GameManager();

        boolean game = true;
        while (game == true) {
            String choice = menuController.startMenu();
            if (choice.equals("1")) {
                Hero theHero = (menuController.selectHero());
                Controls control = new Controls("w", "s", "d", "a");
                Room[][] room = new Room[10][10];
                mapController.createWorld(room, theHero);
                User user = new User("Sam", 100);
                HeroView heroView = new HeroView(theHero);
                HeroController heroController = new HeroController(theHero, heroView);
                heroView.printStats();
                heroView.heroStory();
                gameManager.game(theHero,room, room[8][5], control,user);

            } else if (choice.equals("2")) {
                System.out.println("Load Game");

                String fileName = "SavedGame.json";
                File file = new File("SavedGame.json");
                Load load = new Load(file, fileName);
                LoadView loadView = new LoadView(load);
                LoadController loadController = new LoadController(load, loadView);
                loadController.loadGame();

            } else if (choice.equals("3")) {


                if (!myApp.printUsers(myApp.users)) {

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
                menuView.instructionsStartMenu();
            } else if (choice.equals("5")) {
                System.exit(0);
            }
        }
    }

            /**
             * prints users needs to go in user view
             *
             * @param users
             * @return
             */
            public boolean printUsers (ArrayList < User > users) {

                if (users.size() == 0) {

                }
                return true;
            }

    public User selectUser() {

        User userModel = null;
        UserView userView = null;
        UserController userController = null;

        if (userz.isEmpty()) {

            System.out.printf("%n" +
                    "Create a new user before beginning the game.%n" +
                    "Enter the name of your new user%n");
            String response = input.nextLine();

            boolean ok = false;
            while (!ok) {

                for (User i : userz) {

                    if (response == i.getUserName()) {

                        ok = false;
                    } else {

                        ok = true;
                    }
                }

                if (!ok) {
                    System.out.printf("%n" +
                            "The name you entered has already been selected. Enter another name%n");
                    String respoonse = input.nextLine();
                }
            }

            userModel = new User(response, 0);
            userModel.addUsers(userz, userModel);
            return userModel;
        }

        System.out.printf("%n" +
                "Select one of the following users. To create a new user enter 0%n");

        for (int i = 0; i < userz.size(); ) {

            System.out.printf("%d- %s %d", ++i, userz.get(i).getUserName(), userz.get(i).getHighScore());

            try {

                int userNo = input.nextInt();

                if (userNo == 0) {

                    userModel = new User(null, 0);
                    return userModel;
                } else
                    userModel = new User(userz.get(--userNo).getUserName(), userz.get(--userNo).getHighScore());
            } catch (InputMismatchException e) {

                System.out.printf("%n" +
                        "Chose user");
            }
        }
        return userModel;
    }

            /**
             * creates new user needs to go into user controller
             * @return
             */
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

}

