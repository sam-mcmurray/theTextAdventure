package project1E7.Model;

public class Room {
    private String description;
    private Item item;
    private boolean monster;
    private boolean found;

    public Room(String description, Item item, boolean monster, boolean found) {
        this.description = description;
        this.item = item;
        this.monster = true;
        this.found = found;
    }

    public String getDescription() {
        return description;
    }

    public Item getItem() {
        return item;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isMonster() {
        return monster;
    }

    public void setMonster(boolean monster) {
        this.monster = monster;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public boolean getFound() {return found;}
}
