package project1E7;

public class Character {
    private int health;
    private int strength;
    private int speed;
    private String description;
    private String name;

    public Character(int health, int strength, int speed, String description, String name) {
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.description = description;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
}
