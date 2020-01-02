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
    ArrayList<User> users;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        theTextAdventure myApp = new theTextAdventure();

        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);

        MapView mapView = new MapView();
        MapController mapController = new MapController(mapView);

        GameManager gameManager = new GameManager();

        boolean game = true;
        while (game == true) {
            String choice = menuController.startMenu();
            if (choice.equals("1")) {


               gameManager.newGame();

            } else if (choice.equals("2")) {
            System.out.println("Load Game");
            Hero witcher = new Hero(10, 10, 10, "10", "10", 10, "10");
            Monster monster = new Monster(10,10, 10, "test", "test", null, true, 10);
            Gson gson = new Gson();
            String json = gson.toJson(witcher);
            System.out.println(json);
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
     * @param users
     * @return
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

    /**
     * creates new user needs to go into user controller
     * @return
     */
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
