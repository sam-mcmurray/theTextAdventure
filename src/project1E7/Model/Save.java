package project1E7.Model;

import com.google.gson.Gson;

import java.util.Scanner;

public class Save {
    Scanner input = new Scanner(System.in);
    Gson gson = new Gson();
    Hero jsonHero;
    Room[][] jsonMap;
    Controls jsonControls;
    User jsonUser;
    Room jsonCurrentRoom;
    int i;
    int j;


    public Save(Hero jsonHero, Room[][] jsonMap, Controls jsonControls, User jsonUser, Room jsonCurrentRoom) {
        this.jsonHero = jsonHero;
        this.jsonMap = jsonMap;
        this.jsonControls = jsonControls;
        this.jsonUser = jsonUser;
        this.jsonCurrentRoom = jsonCurrentRoom;
    }

    public Hero getJsonHero() {
        return jsonHero;
    }

    public void setJsonHero(Hero jsonHero) {
        this.jsonHero = jsonHero;
    }

    public Room[][] getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(Room[][] jsonMap) {
        this.jsonMap = jsonMap;
    }

    public Controls getJsonControls() {
        return jsonControls;
    }

    public void setJsonControls(Controls jsonControls) {
        this.jsonControls = jsonControls;
    }

    public User getJsonUser() {
        return jsonUser;
    }

    public void setJsonUser(User jsonUser) {
        this.jsonUser = jsonUser;
    }

    public Room getJsonCurrentRoom() {
        return jsonCurrentRoom;
    }

    public void setJsonCurrentRoom(Room jsonCurrentRoom) {
        this.jsonCurrentRoom = jsonCurrentRoom;
    }

    public int getJsonHeroCurrentTreasure() {return jsonUser.getHighScore();}

    public String getJsonHeroUserName() {return jsonUser.getUserName();}

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
