package project1E7.Model;

public class Room {
    private String description;
    private boolean found;
    private Item item;
    private Door door;
    private boolean islocked;
    private boolean hasItem = false;
    private boolean hasMonster;
    private Monster monster;
    private boolean hasCharacter;
    private enum DOOR{NORTH,EAST,SOUTH,WEST}


    public Room(String description, boolean found, boolean hasCharacter) {
        this.description = description;
        this.found = found;
        this.hasCharacter = hasCharacter;
    }


    public Room(String description, boolean found, Item item, boolean hasItem, boolean hasCharacter) {
        this.description = description;
        this.found = found;
        this.item = item;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
    }

    public Room(String description, Item item, boolean hasMonster, boolean found, Monster monster, boolean hasItem, boolean hasCharacter) {
        this.description = description;
        this.item = item;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
    }

    public Room(String description, boolean found, Item item, boolean hasItem, boolean hasMonster, Monster monster, Door door, boolean islocked, boolean hasCharacter) {
        this.description = description;
        this.found = found;
        this.item = item;
        this.hasItem = hasItem;
        this.hasMonster = hasMonster;
        this.monster = monster;
        this.door = door;
        this.islocked = islocked;
        this.hasCharacter = hasCharacter;
    }

    public Room(String description, boolean found, Item item, Door door, boolean islocked, boolean hasCharacter) {
        this.description = description;
        this.found = found;
        this.item = item;
        this.door = door;
        this.islocked = islocked;
        this.hasCharacter = hasCharacter;
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

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public boolean isIslocked() {
        return islocked;
    }

    public void setIslocked(boolean islocked) {
        this.islocked = islocked;
    }

    public void setHasCharacter(boolean hasCharacter) { this.hasCharacter = hasCharacter; }

    public boolean getHasCharacter() { return hasCharacter; }
}
