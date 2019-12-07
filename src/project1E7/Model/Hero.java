package project1E7.Model;

import java.util.ArrayList;

public class Hero extends Character {
    private int endurance;
    private ArrayList<Key> keyRing;
    private ArrayList<Item> backPack;
    private int lives;
    private int currentTreasure;
    private boolean alive;
    public Hero(int health, int strength, int speed, String description, String name, int endurance) {
        super(health, strength, speed, description, name);
        this.endurance = endurance;
        lives = 5;
        currentTreasure = 0;
        alive = true;

    }

    public ArrayList<Key> getKeyRing() {
        return keyRing;
    }

    public void setKeyRing(ArrayList<Key> keyRing) {
        this.keyRing = keyRing;
    }

    public ArrayList<Item> getBackPack() {
        return backPack;
    }

    public void setBackPack(ArrayList<Item> backPack) {
        this.backPack = backPack;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getCurrentTreasure() {
        return currentTreasure;
    }

    public void setCurrentTreasure(int currentTreasure) {
        this.currentTreasure = currentTreasure;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Hero " + name;
    }
}
