package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.RoomView;

import java.util.Random;

public class RoomController {
    Room model;
    RoomView view;



    public RoomController(Room model, RoomView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * if room has monster boolean
     * @return
     */
    public boolean roomHasMonster() {
        if (model.isHasMonster() == true) {
            return true;
        } else
            return false;

    }

    /**
     * return the monster
     * @return
     */
    public Monster getMonster() {
        return model.getMonster();


    }

    /**
     * room has item boolean
     * @return
     */
    public boolean roomHasItem() {
        if (model.isHasItem() == true) {
            return true;
        } else
            return false;
    }

    /**
     * get the room item
     * @return
     */
    public Item findItem() {

            if (model.getItem() instanceof Coffee) {
                Coffee coffee = (Coffee) model.getItem();
                return coffee;
            } else if (model.getItem() instanceof Treasure) {
                Treasure treasure = (Treasure) model.getItem();
                return treasure;
            } else if (model.getItem() instanceof Key) {
                Key key = (Key) model.getItem();
                return key;
            } else if (model.getItem() instanceof HealthPotion) {
                HealthPotion healthPotion = (HealthPotion) model.getItem();
                return healthPotion;
            } else if (model.getItem() instanceof Heart) {
                Heart heart = (Heart) model.getItem();
                return heart;
            } else if (model.getKey() != null) {
                return model.getKey();
            } else if (model.getWeapon() != null) {
                return model.getWeapon();
            } else if (model.getCoffee() != null) {
                return model.getCoffee();
            } else if (model.getHealthPotion() != null) {
                return model.getHealthPotion();
            } else if (model.getTreasure() != null) {
                return model.getTreasure();
            } else if (model.getHeart() != null) {
                return model.getHeart();
            } else
                return model.getItem();

    }

    /**
     * if the room didnt have an item but it got a random drop this creates the items
     * @return
     */
    public Item setRandomItem() {
        Random rand = new Random();

        int possibleItem = rand.nextInt(100);
        int itemType = rand.nextInt(100);
        int treasureAmount = rand.nextInt(100);

        if (possibleItem <=20) {
            if(itemType <=74){
                Treasure treasure = new Treasure("Gold Chest",1000);
                if(treasureAmount <= 49) {
                    treasure.setAmount(1000);
                    treasure.setName("a pile of copper coins");
                    return treasure;
                } else if (treasureAmount >= 50 && treasureAmount <= 69) {
                    treasure.setAmount(4000);
                    treasure.setName("a pile of silver coins");
                    return treasure;
                } else if (treasureAmount >= 70 && treasureAmount <= 84) {
                    treasure.setAmount(6000);
                    treasure.setName("a pile of gold coins");
                    return treasure;
                } else if (treasureAmount >= 85 && treasureAmount <= 94) {
                    treasure.setName("a pile of precious gemstones");
                    treasure.setAmount(8500);
                    return treasure;
                } else if (treasureAmount >= 95) {
                    treasure.setName("a beautifully crafted ornate goblet");
                    treasure.setAmount(10000);
                    return treasure;
                }

            } else if (itemType <= 84) {
                Coffee coffee = new Coffee("a steaming cup of Coffee");
                return coffee;
            } else if (itemType <= 94) {
                HealthPotion healthPotion = new HealthPotion("a glowing red health potion");
                return healthPotion;
            } else if (itemType >= 95) {
                Heart heart = new Heart("a heart inside a glass container. It still beats.");
                return heart;
            }
        }
        Item item = new Item("missing");
        return item;

    }


    /**
     * set the current room as found
     * @param currentRoom
     */
    public void setFound(Room currentRoom) {
        currentRoom.setFound(true);
    }

}
