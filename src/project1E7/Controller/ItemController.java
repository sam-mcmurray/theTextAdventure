package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.ItemView;
import project1E7.View.KeyView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ItemController {
    Item model;
    ItemView view;
    private Key key;
    private Treasure treasure;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    public ItemController(Item model, ItemView view) {
        this.model = model;
        this.view = view;
    }
    public boolean checkIfTreasure(Item item) {
     if (item instanceof Treasure) {
         return true;
     } else
     return false;
    }
    public boolean checkIfKey(Item item) {
        if (item instanceof Key){
            return true;
        } else
            return false;
    }
    public Treasure checkTreasureValue(Treasure treasure) {
        if (treasure.getAmount() == 0) {
            int setRand = rand.nextInt(100);
                if(setRand <= 49) {
                    treasure.setAmount(1000);
                    return treasure;
                } else if (setRand >= 50 && setRand <= 69) {
                    treasure.setAmount(4000);
                    return treasure;
                } else if (setRand >= 70 && setRand <= 84) {
                    treasure.setAmount(6000);
                    return treasure;
                } else if (setRand >= 85 && setRand <= 94) {
                    treasure.setAmount(8500);
                    return treasure;
                } else if (setRand >= 95) {
                    treasure.setAmount(10000);
                    return treasure;
                }
        }
        return treasure;
    }
    public boolean encounterItem(Item item, HeroController heroController, ArrayList<Key> keyRing) {
        boolean run = true;
        String chooseItem = "0";
        do {
            view.viewItem(item);
            if (checkIfTreasure(item) == true) {
                Treasure treasure = (Treasure) item;
                checkTreasureValue(treasure);

                heroController.addTreasure(treasure.getAmount());
                run = false;
                return run;
            } else if (checkIfKey(item)) {
                Key key = (Key) item;
                KeyView keyView = new KeyView(key);
                KeyController keyController = new KeyController(key, keyView);
                keyView.foundKey();
                keyRing = heroController.addKey(keyRing, key);
                run = false;
                return run;
            } else
                view.chooseWhatToDoWithItem(item);
            chooseItem = input.nextLine();
            switch (chooseItem) {
                case "1":
                    heroController.useItemExternal(item);
                    run = false;
                    return run;
                case "2":
                    run = false;
                    return run;
                default:
                    System.out.println("Please enter a proper value.");
                    break;
            }

        } while (run == true);
        return run;
    }
}
