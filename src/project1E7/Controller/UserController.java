package project1E7.Controller;

import project1E7.Model.User;
import project1E7.View.UserView;

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

    public void update(int a, String name) {

        model.setHighScore(a);
        model.setUserName(name);
    }

    public boolean isEmpty() {

        return model.isEmpty();
    }

    public boolean createUser() {

        Scanner input = new Scanner(System.in);

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
                else{

                    System.out.printf("");
                }
            }

            User user = new User(temp, 0);
            model.addUsers(model.getUsers(), user);
            return true;

        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Returning to start menu");
            return false;
        } else System.out.println("Invalid answer!");
        return false;
    }
}
