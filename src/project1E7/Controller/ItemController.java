package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.*;

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

    /**
     * checks if item is a treasure
     * @param item
     * @return
     */
    public boolean checkIfTreasure(Item item) {
     if (item instanceof Treasure) {
         return true;
     } else
     return false;
    }

    /**
     * checks if item is a key
     * @param item
     * @return
     */
    public boolean checkIfKey(Item item) {
        if (item instanceof Key){
            return true;
        } else
            return false;
    }

    /**
     * checks to make sure that treasure has a value if not it will assign a value
     * so we dont get null pointers
     * @param treasure
     * @return
     */
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

    /**
     * encounter an item i kept the menu here because i didnt know how to break it up exactly
     * @param item
     * @param heroController
     * @param keyRing
     * @return
     */
    public boolean encounterItem(Item item, HeroController heroController, ArrayList<Key> keyRing,ArrayList<Item> backPack,
                                 MenuController menuController, ControlsController controlsController, ControlsView controlsView, MapView mapView, Room[][] room,
                                 Hero theHero, HeroView heroView, Room currentRoom, User user, Controls controls) {
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
                    heroController.turnCounter();
                    run = false;
                    return run;
                case "2":
                    heroController.saveItem(item,backPack);
                    heroController.turnCounter();
                    run = false;
                    return run;
                case "3":
                    menuController.subMenu(controlsController, controlsView,mapView, room,
                        theHero, heroView, currentRoom, user, controls);
                    break;
                default:
                    System.out.println("Please enter a proper value.");
                    break;
            }

        } while (run == true);
        return run;
    }
}
