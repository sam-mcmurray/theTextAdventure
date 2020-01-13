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
     *
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
     *
     * @param item
     * @return
     */
    public boolean checkIfKey(Item item) {
        if (item instanceof Key) {
            return true;
        } else
            return false;
    }

    /**
     * checks if item is a weapon
     *
     * @param item
     * @return
     */
    public boolean checkIfWeapon(Item item) {
        if (item instanceof Weapon) {
            return true;
        } else
            return false;
    }

    /**
     * checks if item is usable
     *
     * @param item
     * @return
     */
    public boolean checkIfUsable(Item item) {
        if (item instanceof Coffee || item instanceof HealthPotion || item instanceof Heart) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks to make sure that treasure has a value if not it will assign a value
     * so we dont get null pointers
     *
     * @param treasure
     * @return
     */
    public Treasure checkTreasureValue(Treasure treasure) {
        if (treasure.getAmount() == 0) {
            int setRand = rand.nextInt(100);
            if (setRand <= 49) {
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
     *
     * @param roomController
     * @param heroController
     * @param keyRing
     * @return
     */

    public boolean encounterItem(RoomController roomController, HeroController heroController, ArrayList<Key> keyRing, ArrayList<Item> backPack,
                                 MenuController menuController, ControlsController controlsController, ControlsView controlsView, MapView mapView, Room[][] room,
                                 Hero theHero, HeroView heroView, Room currentRoom, User user, Controls controls, Room previousRoom) {

        boolean run = true;
        String chooseItem = "0";
        do {
            System.out.print("\u001B[0m");
            model = roomController.findItem();
            view.viewItem(model);
            if (checkIfTreasure(model)) {
                Treasure treasure = (Treasure) model;
                checkTreasureValue(treasure);

                heroController.addTreasure(treasure);
                run = false;
                return run;
            } else if (checkIfKey(model)) {
                Key key = (Key) model;
                KeyView keyView = new KeyView(key);
                KeyController keyController = new KeyController(key, keyView);
                keyView.foundKey();
                keyRing = heroController.addKey(keyRing, key);
                run = false;
                return run;
            } else if (checkIfWeapon(model)) {
                Weapon weapon = (Weapon) model;
                weapon.setName(weaponName(theHero));
                theHero.setStrength(weapon.getStrength() + theHero.getStrength());
                theHero.setWeapon(weapon.getName());
                System.out.println("You have found a(n) " + weapon.getName() + "! \nFrom now on all your attacks will do more damage!");
                run = false;
                return run;
            } else if (checkIfUsable(model)) {
                view.chooseWhatToDoWithItem(model);
                chooseItem = input.nextLine();
                switch (chooseItem) {
                    case "1":
                        heroController.useItemExternal(model);
                        heroController.turnCounter();
                        run = false;
                        return run;
                    case "2":
                        if (backPack.size() < 2) {
                            heroController.saveItem(model, backPack);
                            heroController.turnCounter();
                        } else {
                            heroController.dropItem(backPack);
                            if (backPack.size() < 2) {
                                heroController.saveItem(model, backPack);
                                heroController.printItem(backPack);
                            } else System.out.println("Oops!! You missed the Item in this room ");
                        }
                        run = false;
                        return run;
                    case "3":
                        menuController.subMenu(controlsController, controlsView, mapView, room,
                                theHero, heroView, currentRoom, user, controls, heroController, previousRoom);
                        break;
                    default:
                        System.out.println("Please enter a proper value.");
                        break;
                }
            } else {
                System.out.println("Nothing of significance was found.");
                run = false;
                return run;
            }

        } while (run == true);
        return run;
    }

    public String weaponName(Hero theHero) {
        String weapon;
        if (theHero.getCharacterClass().equals("Warrior")) {
            return weapon = "Great Sword";
        } else if (theHero.getCharacterClass().equals("Mage")) {
            return weapon = "Ancient Scepter";
        } else {
            return weapon = "Deadly Curved Dagger";
        }
    }
}
