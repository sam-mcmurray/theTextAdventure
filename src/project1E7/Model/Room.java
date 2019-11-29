package project1E7.Model;

public class Room {
    private String description;
    private Item item;
    private Monster monster;
    private boolean found;

    public Room(String description, Item item, Monster monster, boolean found) {
        this.description = description;
        this.item = item;
        this.monster = monster;
        this.found = found;
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

    public void setFound(boolean found) {
        this.found = found;
    }

    public boolean getFound() {return found;}
}
