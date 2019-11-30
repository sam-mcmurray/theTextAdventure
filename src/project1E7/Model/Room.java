package project1E7.Model;

public class Room {
    private String description;
    private Item item;
    private boolean hasMonster;
    private boolean found;
    private Monster monster;

    public Room(String description, Item item, boolean hasMonster, boolean found, Monster monster) {
        this.description = description;
        this.item = item;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
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

    public boolean isFound() {
        return found;
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
}
