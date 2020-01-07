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

     static ArrayList<User> users = new ArrayList<>();


    public static void main(String[] args) {

        User userModel = new User(null, 0);
        UserView userView = new UserView(userModel);
        UserController userController = new UserController(userModel, userView);
        userModel.setUsers(users);

        Scanner input = new Scanner(System.in);
        theTextAdventure myApp = new theTextAdventure();

        MapView mapView = new MapView();
        MapController mapController = new MapController(mapView);
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);
        GameManager gameManager = new GameManager();

        boolean game = true;
        while (game == true) {
            String choice = menuController.startMenu();
            if (choice.equals("1")) {

                userModel = userController.selectUser();

                while(userModel==null){

                    userModel=userController.createUser();

                    if(userModel==null){

                        userModel=userController.selectUser();
                    }
                }



                gameManager.newGame();

            } else if (choice.equals("2")) {
                System.out.println("Load Game");

            } else if (choice.equals("3")) {


                if (!myApp.printUsers(myApp.users)) {

                    boolean decision = false;

                    while (!decision) {
                        System.out.printf("%n" +
                                "There are no current users, would you like to create a new user? (Yes/No)");

                        String answer = input.nextLine();
                        if (answer == "Yes") {

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

            }
        }
    }

    /**
     * prints users needs to go in user view
     *
     * @param users
     * @return
     */

    public boolean printUsers(ArrayList<User> users) {

        if (users.size() == 0) {

        }

        return true;
    }


    /**
     * creates new user needs to go into user controller
     *
     * @return
     */
}



