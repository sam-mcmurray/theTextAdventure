package project1E7.Model;

public class Monster extends Character {
    private Item item;

    public Monster(int health, int strength, int speed, String description, String name, Item item) {
        super(health, strength, speed, description, name);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
