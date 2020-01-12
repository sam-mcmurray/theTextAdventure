package project1E7;


import project1E7.Controller.*;
import project1E7.Model.*;
import project1E7.View.*;

import java.io.*;
import java.util.*;

import static java.lang.Character.isUpperCase;

public class theTextAdventure {

    Scanner input = new Scanner(System.in);
    String userName;

     static ArrayList<User> users = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        User userModel = new User(null, 0);
        UserView userView = new UserView(userModel);
        UserController userController = new UserController(userModel, userView);

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
            System.out.print("\u001B[0m");
            String choice = menuController.startMenu();
            if (choice.equals("1")) {
                
                User user = userController.createUser();
                Hero theHero = (menuController.selectHero());
                Controls control = new Controls("w", "s", "d", "a");
                Room[][] room = new Room[10][10];
                mapController.createWorld(room);
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
                String fileName = "HighScore.txt";
                File file = new File("HighScore.txt");
                Load load = new Load(file, fileName);
                LoadView loadView = new LoadView(load);
                LoadController loadController = new LoadController(load, loadView);
                loadController.printHighScore();

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



