package project1E7.Model;

import java.util.ArrayList;

public class User {

    String UserName;
    int highScore;
    ArrayList<User> users;
    boolean empty;


    public User(String UserName, int highScore) {

        this.UserName = UserName;
        this.highScore = highScore;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void setEmpty(boolean empty) {

        empty = true;
    }

    public void addUsers(ArrayList<User> users, User user) {
        users.add(user);
    }

    public ArrayList getUsers() {

        return users;
    }

    public boolean isEmpty() {
        return empty;
    }

    public String getUserName() {
        return UserName;
    }

    public int getHighScore() {
        return highScore;
    }

}