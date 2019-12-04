package project1E7.Model;

public class User {

    String UserName;
    int highScore;

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

    public String getUserName() {
        return UserName;
    }

    public int getHighScore() {
        return highScore;
    }

}
