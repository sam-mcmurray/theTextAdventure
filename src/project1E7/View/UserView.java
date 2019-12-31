package project1E7.View;

import project1E7.Model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;

public class UserView {

    User model;

    public UserView(User model) {

        this.model = model;
    }

    public boolean printUsers(User model) {

        if ((model.getUsers()).size() == 0) {

            System.out.printf("%n" +
                    "There are no existing users%n" +
                    "Returning to the start menu%n");

            for (double a = 0; a < 10000000000000000000000000.0; )
                a++;

            return false;
        } else
            for (int i = 0; i < model.getUsers().size(); i++) {

                System.out.printf("%nUsername: %s%n" +
                        "Highscore: %d%n", ((User) (model.getUsers()).get(i)).getUserName(), ((User) (model.getUsers()).get(i)).getHighScore());
            }
        return true;
    }
}

