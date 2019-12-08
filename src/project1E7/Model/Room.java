package project1E7.Model;

public class Room {
    private String description;
    private boolean found;
    private Item item;
    private boolean hasItem = false;
    private boolean hasMonster;
    private Monster monster;

    public Room(String description, boolean found) {
        this.description = description;
        this.found = found;
    }

    public Room(String description, boolean found, Item item, boolean hasItem) {
        this.description = description;
        this.found = found;
        this.item = item;
        this.hasItem = hasItem;
    }

    public Room(String description, Item item, boolean hasMonster, boolean found, Monster monster, boolean hasItem) {
        this.description = description;
        this.item = item;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
        this.hasItem = hasItem;
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
        return hasMonster;
    }

    public void setMonster(boolean monster) {
        this.hasMonster = monster;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public boolean getFound() {return found;}

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public boolean isHasMonster() {
        return hasMonster;
    }

    public void setHasMonster(boolean hasMonster) {
        this.hasMonster = hasMonster;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }


}
