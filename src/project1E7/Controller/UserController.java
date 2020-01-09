package project1E7.Controller;

import project1E7.Model.Hero;
import project1E7.Model.User;
import project1E7.View.UserView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;

public class UserController {

    UserView view;
    User model;

    public UserController(User model, UserView view) {

        this.model = model;
        this.view = view;
    }

    public void update(int a) {

        model.setHighScore(a);
    }

    public User createUser() {

        Scanner input = new Scanner(System.in);

        System.out.println("You need to create a new user before starting the game");

            System.out.printf("Enter your new username:");
            String temp = input.nextLine();

            while (temp.length() > 12) {

                if (temp.length() > 12) {
                    System.out.printf("%n" +
                            "Invalid username! Your username must contain a maximum of 12 characters");
                }

                System.out.printf("%n" +
                        "Enter a valid username:%n");
                temp = input.nextLine();

            }

            User user = new User(temp, 0);
            return user;
    }

    public User selectUser() {

        Scanner input = new Scanner(System.in);
        User userModel = new User(null, 0);

        if (model.getUsers().isEmpty()) {

            System.out.printf("%n" +
                    "Create a new user before beginning the game.%n" +
                    "Enter the name of your new user%n");
            String response = input.nextLine();

            boolean ok = false;
            while (!ok) {

                for (Object i : model.getUsers()) {

                    if (response == ((User) i).getUserName()) {

                        ok = false;
                    } else {

                        ok = true;
                    }
                }

                if (!ok) {
                    System.out.printf("%n" +
                            "The name you entered has already been selected. Enter another name%n");
                    response = input.nextLine();
                }
            }

            userModel = new User(response, 0);
            userModel.addUsers(model.getUsers(), userModel);
            return userModel;
        } else {

            System.out.printf("%n" +
                    "Select one of the following users. To create a new user enter 0%n");

            for (int i = 0; i < model.getUsers().size(); ) {

                System.out.printf("%d- %s %d", ++i, ((User) model.getUsers().get(i)).getUserName(), ((User) model.getUsers().get(i)).getHighScore());
            }

            try {

                try {

                    int userNo = input.nextInt();

                    if (userNo == 0) {

                        return null;
                    } else
                        userModel = new User(((User) userModel.getUsers().get(--userNo)).getUserName(), (((User) userModel.getUsers().get(--userNo)).getHighScore()));

                } catch (IndexOutOfBoundsException e) {

                    System.out.printf("%n" +
                            "Enter the number of an available user!%n");
                }
            } catch (InputMismatchException e) {

                System.out.printf("%n" +
                        "Invalid answer!%n" +
                        "Choose user%n");
            }
        }
        return userModel;
    }
    public void Score(Hero thehero) {
        model.setHighScore(thehero.getCurrentTreasure());
    }
}
