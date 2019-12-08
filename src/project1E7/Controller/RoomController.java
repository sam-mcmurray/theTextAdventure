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


    public boolean roomHasMonster() {
        if (model.isHasMonster() == true) {
            return true;
        } else
            return false;

    }
    public Monster getMonster() {
        return model.getMonster();


    }
    public boolean roomHasItem() {
        if (model.isHasItem() == true) {
            return true;
        } else
            return false;
    }

    public Item getItem() {
        Item item = model.getItem();
        return item;

    }
    public Item setRandomItem() {
        Random rand = new Random();

        int possibleItem = rand.nextInt(100);
        int itemType = rand.nextInt(100);
        int treasureAmount = rand.nextInt(100);

        if (possibleItem <=50) {
            if(itemType <=74){
                Treasure treasure = new Treasure("Gold Chest",1000);
                if(treasureAmount <= 49) {
                    treasure.setAmount(1000);
                    return treasure;
                } else if (treasureAmount >= 50 && treasureAmount <= 69) {
                    treasure.setAmount(4000);
                    return treasure;
                } else if (treasureAmount >= 70 && treasureAmount <= 84) {
                    treasure.setAmount(6000);
                    return treasure;
                } else if (treasureAmount >= 85 && treasureAmount <= 94) {
                    treasure.setAmount(8500);
                    return treasure;
                } else if (treasureAmount >= 95) {
                    treasure.setAmount(10000);
                    return treasure;
                }

            } else if (itemType >= 75 && itemType <= 84) {
                Coffee coffee = new Coffee("Coffee");
                return coffee;
            } else if (itemType >= 85 && itemType <= 94) {
                HealthPotion healthPotion = new HealthPotion("Health potion");
                return healthPotion;
            } else if (itemType >= 95) {
                Heart heart = new Heart("Heart");
                return heart;
            }
        }
        return null;
    }



}
