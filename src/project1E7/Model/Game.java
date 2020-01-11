package project1E7.Model;

import java.util.Arrays;

public class Game {
    private Hero jsonHero;
    private Room[][] jsonMap;
    private Controls jsonControls;
    private User jsonUser;
    private Room jsonCurrentRoom;
    private int jsonI;
    private int jsonJ;

    public Game(Hero jsonHero, Room[][] jsonMap, Controls jsonControls, User jsonUser, Room jsonCurrentRoom,int jsonI,int jsonJ) {
        this.jsonHero = jsonHero;
        this.jsonMap = jsonMap;
        this.jsonControls = jsonControls;
        this.jsonUser = jsonUser;
        this.jsonCurrentRoom = jsonCurrentRoom;
        this.jsonI = jsonI;
        this.jsonJ = jsonJ;
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

    public int getJsonI() {
        return jsonI;
    }

    public void setJsonI(int jsonI) {
        this.jsonI = jsonI;
    }

    public int getJsonJ() {
        return jsonJ;
    }

    public void setJsonJ(int jsonJ) {
        this.jsonJ = jsonJ;
    }
}
