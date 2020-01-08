package project1E7.Model;

import java.util.ArrayList;

public class User {

    String UserName;
    int highScore;
    ArrayList<User> users;
    int highestScore;

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

    public void addUsers(ArrayList<User> users, User user) {
        users.add(user);
    }

    public void setUsers(ArrayList<User> users) {

        this.users = users;
    }

    public ArrayList getUsers() {

        return users;
    }


    public String getUserName() {
        return UserName;
    }

    public int getHighScore() {
        return highScore;
    }
}