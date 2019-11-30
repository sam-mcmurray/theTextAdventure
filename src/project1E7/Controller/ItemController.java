package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.ItemView;

import java.util.Random;

public class ItemController {
    Item model;
    ItemView view;
    private Treasure treasure;
    private Coffee coffee;
    private HealthPotion healthPotion;
    private Heart heart;

    public ItemController(Item model, ItemView view) {
        this.model = model;
        this.view = view;
    }
    public Item setRandomItem() {
        Random rand = new Random();

        int possibleItem = rand.nextInt(100);
        int itemType = rand.nextInt(100);
        int treasureAmount = rand.nextInt(100);

        if (possibleItem <=50) {
            if(itemType <=74){
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
                return coffee;
            } else if (itemType >= 85 && itemType <= 94) {
                return healthPotion;
            } else if (itemType >= 95) {
                return heart;
            }
        }
        return null;
    }
}
