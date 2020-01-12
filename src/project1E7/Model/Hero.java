package project1E7.Model;

import java.util.ArrayList;

public class Hero extends Character {
    private int endurance;
    private ArrayList<Key> keyRing;
    private ArrayList<Item> backPack;
    private int lives;
    private int currentTreasure;
    private boolean alive;
    private String characterClass;
    private String weapon;
    private int turnCounter;
    private String ability;
    private int abilityCounter;
    private int superAbilityCounter;


    public Hero(int health, int strength, int speed, String description, String name, int endurance,String characterClass, String weapon) {
        super(health, strength, speed, description, name);
        this.endurance = endurance;
        this.characterClass = characterClass;
        this.weapon = weapon;
        lives = 1;
        currentTreasure = 0;
        alive = true;
        turnCounter = 0;

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

    public String getCharacterClass() { return characterClass; }

    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }

    public String getWeapon() { return weapon; }

    public void setWeapon(String weapon) { this.weapon = weapon; }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }
    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getAbilityCounter() {
        return abilityCounter;
    }

    public void setAbilityCounter(int abilityCounter) {
        this.abilityCounter = abilityCounter;
    }

    public int getSuperAbilityCounter() {
        return superAbilityCounter;
    }

    public void setSuperAbilityCounter(int superAbilityCounter) {
        this.superAbilityCounter = superAbilityCounter;
    }

    @Override
    public String toString() {
        return "Hero " + name;
    }
}
