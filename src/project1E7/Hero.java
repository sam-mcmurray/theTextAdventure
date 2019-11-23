package project1E7;

import java.util.ArrayList;

public class Hero extends Character{
    private int endurance;
    private Key [] keyRing;
    private ArrayList<Item> backPack;
    private int lives;
    private int currentTreasure;

    public Hero(int health, int strength, int speed, String description, String name, int endurance) {
        super(health, strength, speed, description, name);
        this.endurance = endurance;
        lives = 5;
        currentTreasure = 0;

    }

    public Key[] getKeyRing() {
        return keyRing;
    }

    public void setKeyRing(Key[] keyRing) {
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

    public void drinkCoffee() {
        setSpeed(getSpeed());
       // + Coffee
    }
    public void useHeart() {
        setLives(getLives() + 1);
    }

    public void useHealthPotion() {
        if (getHealth() <= 7) {
            setHealth(getHealth() + 3);
        } else {
            setHealth(10);
        }
    }

}
