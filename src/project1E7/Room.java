package project1E7;

public class Room {
    private String description;
    private Item item;
    private Monster monster;

    public Room(String description, Item item, Monster monster) {
        this.description = description;
        this.item = item;
        this.monster = monster;
    }

    public String getDescription() {
        return description;
    }

    public Item getItem() {
        return item;
    }

    public Monster getMonster() {
        return monster;
    }
}
