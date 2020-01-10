package project1E7.Model;

public class Room {
    private String description;
    private boolean found;
    private Item item;
    private Door door;
    private boolean islocked;
    private boolean hasItem;
    private boolean hasMonster;
    private Monster monster;
    private boolean hasCharacter;
    private boolean beenSeen;
    private Coffee coffee;
    private Treasure treasure;
    private Key key;
    private HealthPotion healthPotion;
    private Heart heart;
    private Weapon weapon;

    public Room(String description, boolean found, boolean hasCharacter, boolean beenSeen, boolean hasItem, Item item){
        this.description = description;
        this.found = found;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        this.item = item;
        item = null;
    }

    public Room(String description, boolean found, boolean hasCharacter, boolean beenSeen, boolean hasItem){
        this.description = description;
        this.found = found;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
    }

    public Room(String description, boolean found, boolean hasCharacter, boolean beenSeen, boolean hasItem, Coffee coffee) {
        this.description = description;
        this.found = found;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        this.coffee = coffee;
        item = coffee;
    }

    public Room(String description, boolean found, boolean hasCharacter, boolean beenSeen, boolean hasItem, HealthPotion healthPotion) {
        this.description = description;
        this.found = found;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        this.healthPotion = healthPotion;
        item = healthPotion;
    }

    public Room(String description, boolean found, boolean hasCharacter, boolean beenSeen, boolean hasItem, Heart heart) {
        this.description = description;
        this.found = found;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        this.heart = heart;
        item = heart;
    }

    public Room(String description, boolean found, boolean hasCharacter, boolean beenSeen, boolean hasItem, Treasure treasure) {
        this.description = description;
        this.found = found;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        this.treasure = treasure;
        item = treasure;
    }

    public Room(String description, boolean found, Treasure treasure, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.found = found;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.treasure = treasure;
        this.beenSeen = beenSeen;
        item = treasure;
    }

    public Room(String description, boolean found, Coffee coffee, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.found = found;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.coffee = coffee;
        this.beenSeen = beenSeen;
        item = coffee;
    }

    public Room(String description, boolean found, Heart heart, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.found = found;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.heart = heart;
        this.beenSeen = beenSeen;
        item = heart;
    }

    public Room(String description, boolean found, HealthPotion healthPotion, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.found = found;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.healthPotion = healthPotion;
        this.beenSeen = beenSeen;
        item = healthPotion;
    }

    public Room(String description, Treasure treasure, boolean hasMonster, boolean found, Monster monster, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.treasure = treasure;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        item = treasure;

    }

    public Room(String description, Coffee coffee, boolean hasMonster, boolean found, Monster monster, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.coffee = coffee;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        item = coffee;

    }

    public Room(String description, HealthPotion healthPotion, boolean hasMonster, boolean found, Monster monster, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.healthPotion = healthPotion;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        item = healthPotion;

    }
    public Room(String description, Heart heart, boolean hasMonster, boolean found, Monster monster, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.heart = heart;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        item = heart;
    }

    public Room(String description, Key key, boolean hasMonster, boolean found, Monster monster, boolean hasItem, boolean hasCharacter, boolean beenSeen) {
        this.description = description;
        this.key = key;
        this.hasMonster = hasMonster;
        this.found = found;
        this.monster = monster;
        this.hasItem = hasItem;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        item = key;

    }

    public Room(String description, boolean found, Treasure treasure, Door door, boolean islocked, boolean hasCharacter, boolean beenSeen, boolean hasItem) {
        this.description = description;
        this.found = found;
        this.treasure = treasure;
        this.door = door;
        this.islocked = islocked;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        item = treasure;
    }

    public Room(String description, boolean found, Coffee coffee, Door door, boolean islocked, boolean hasCharacter, boolean beenSeen, boolean hasItem) {
        this.description = description;
        this.found = found;
        this.coffee = coffee;
        this.door = door;
        this.islocked = islocked;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        item = coffee;
    }

    public Room(String description, boolean found, Heart heart, Door door, boolean islocked, boolean hasCharacter, boolean beenSeen, boolean hasItem) {
        this.description = description;
        this.found = found;
        this.heart = heart;
        this.door = door;
        this.islocked = islocked;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        item = heart;
    }

    public Room(String description, boolean found, HealthPotion healthPotion, Door door, boolean islocked, boolean hasCharacter, boolean beenSeen, boolean hasItem) {
        this.description = description;
        this.found = found;
        this.healthPotion = healthPotion;
        this.door = door;
        this.islocked = islocked;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        item = healthPotion;
    }

    public Room(String description, boolean found, Weapon weapon, Door door, boolean islocked, boolean hasCharacter, boolean beenSeen, boolean hasItem) {
        this.description = description;
        this.found = found;
        this.weapon = weapon;
        this.door = door;
        this.islocked = islocked;
        this.hasCharacter = hasCharacter;
        this.beenSeen = beenSeen;
        this.hasItem = hasItem;
        item = weapon;
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

    public boolean getIslocked() {
        return islocked;
    }

    public void setIslocked(boolean islocked) {
        this.islocked = islocked;
    }

    public void setHasCharacter(boolean hasCharacter) { this.hasCharacter = hasCharacter; }

    public boolean getHasCharacter() { return hasCharacter; }

    public void setBeenSeen(boolean beenSeen) { this.beenSeen = beenSeen; }

    public boolean getBeenSeen() { return beenSeen; }

    public Coffee getCoffee() {
        return coffee;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public Key getKey() {
        return key;
    }

    public HealthPotion getHealthPotion() {
        return healthPotion;
    }

    public Heart getHeart() {
        return heart;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
