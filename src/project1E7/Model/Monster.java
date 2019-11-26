package project1E7.Model;

public class Monster extends Character {
    private Item item;
    private boolean alive;
    private int xp;

    public Monster(int health, int strength, int speed, String description, String name, Item item, boolean alive, int xp) {
        super(health, strength, speed, description, name);
        this.item = item;
        this.alive = alive;
        this.xp = xp;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getXp() {
        return xp;
    }
}
