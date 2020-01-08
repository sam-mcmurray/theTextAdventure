package project1E7.Controller;


import project1E7.Model.*;
import project1E7.View.*;
import project1E7.theTextAdventure;
import project1E7.View.HeroView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class HeroController {
    Hero model;
    HeroView view;
    private Coffee coffee = new Coffee("a steaming cup of Coffee");
    private HealthPotion healthPotion = new HealthPotion("a glowing red health potion");
    private Heart heart = new Heart("a heart inside a crystalline container. It still beats.");
    private Treasure treasure;
    public String controls[] = {"w", "s", "d", "a"};
    private ArrayList<Item> backPack = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void printItem(ArrayList<Item> backPack) {
        try {
            for (int i = 0; i <= backPack.size() - 1; i++) {
                System.out.println("[" + (i + 1) + "]" + backPack.get(i).getName());
            }
        } catch (NullPointerException e) {
            System.out.println("You do not have any item to use");
        }
    }


    public HeroController(Hero model, HeroView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * hero attacks monster 50% chance of landing hit
     *
     * @param monster
     * @return
     */
    public boolean attack(MonsterController monster) {

        if (model.getEndurance() < 10) {
            return false;
        }

        Random rand = new Random();

        int chanceToHit = rand.nextInt(3);
        if (chanceToHit == 0) {
            return false;
        } else {

            model.setEndurance(model.getEndurance() - 10);
            monster.takeDamage(model.getStrength());

            return true;
        }
    }

    /**
     * hero takes damage from enemy attack
     *
     * @param incDamage
     */
    public void takeDamage(int incDamage) {
        if (incDamage >= model.getHealth()) {
            model.setAlive(false);
        }
        model.setHealth(model.getHealth() - incDamage);
    }

    /**
     * move hero through the map
     *
     * @param keys
     * @param room
     * @param currentRoom
     * @param controls
     * @return
     */
    public Room moveHero(ArrayList<Key> keys, Room[][] room, Room currentRoom, Controls controls) {

        Scanner input = new Scanner(System.in);
        String direction;
        boolean run = true;
        while (run == true) {
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room.length; j++) {
                    if (currentRoom == room[i][j]) {

                        System.out.println("Choose your direction ");
                        direction = input.nextLine();
                        if (direction.equalsIgnoreCase(controls.moveLeft)) {
                            j = j - 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                j = j + 1;
                            } else if (room[i][j].getIslocked() == true) {
                                for (Key key : keys)
                                    if (key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())) {
                                        System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                        room[i][(j + 1)].setHasCharacter(false);
                                        room[(i + 1)][j].setBeenSeen(true);
                                        room[(i - 1)][j].setBeenSeen(true);
                                        room[i][(j + 1)].setBeenSeen(true);
                                        room[i][(j - 1)].setBeenSeen(true);
                                        currentRoom = room[i][j];
                                        currentRoom.setHasCharacter(true);
                                        currentRoom.setBeenSeen(true);
                                        currentRoom.setIslocked(false);
                                        turnCounter();
                                        run = false;
                                        return currentRoom;
                                    } else {
                                        System.out.println("You haven't obtained this key yet, you need to find it");
                                        j = j + 1;
                                        run = true;
                                    }
                            } else {
                                room[i][(j + 1)].setHasCharacter(false);
                                room[(i + 1)][j].setBeenSeen(true);
                                room[(i - 1)][j].setBeenSeen(true);
                                room[i][(j + 1)].setBeenSeen(true);
                                room[i][(j - 1)].setBeenSeen(true);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
                                currentRoom.setBeenSeen(true);
                                turnCounter();
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase(controls.moveRight)) {
                            j = j + 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                j = j - 1;
                            } else if (room[i][j].getIslocked() == true) {
                                for (Key key : keys)
                                    if (key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())) {
                                        System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                        room[i][(j - 1)].setHasCharacter(false);
                                        currentRoom = room[i][j];
                                        room[(i + 1)][j].setBeenSeen(true);
                                        room[(i - 1)][j].setBeenSeen(true);
                                        room[i][(j + 1)].setBeenSeen(true);
                                        room[i][(j - 1)].setBeenSeen(true);
                                        currentRoom.setHasCharacter(true);
                                        currentRoom.setBeenSeen(true);
                                        currentRoom.setIslocked(false);
                                        turnCounter();
                                        run = false;
                                        return currentRoom;
                                    } else {
                                        System.out.println("You haven't obtained this key yet, you need to find it");
                                        j = j - 1;
                                        run = true;
                                    }
                            } else {
                                room[i][(j - 1)].setHasCharacter(false);
                                room[(i + 1)][j].setBeenSeen(true);
                                room[(i - 1)][j].setBeenSeen(true);
                                room[i][(j + 1)].setBeenSeen(true);
                                room[i][(j - 1)].setBeenSeen(true);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
                                currentRoom.setBeenSeen(true);
                                turnCounter();
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase(controls.moveDown)) {
                            i = i + 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                i = i - 1;
                            } else if (room[i][j].getIslocked() == true) {
                                for (Key key : keys)
                                    if (key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())) {
                                        System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                        room[i - 1][(j)].setHasCharacter(false);
                                        room[(i + 1)][j].setBeenSeen(true);
                                        room[(i - 1)][j].setBeenSeen(true);
                                        room[i][(j + 1)].setBeenSeen(true);
                                        room[i][(j - 1)].setBeenSeen(true);
                                        currentRoom = room[i][j];
                                        currentRoom.setHasCharacter(true);
                                        currentRoom.setBeenSeen(true);
                                        currentRoom.setIslocked(false);
                                        turnCounter();
                                        run = false;
                                        return currentRoom;
                                    } else {
                                        System.out.println("You haven't obtained this key yet, you need to find it");
                                        i = i - 1;
                                        run = true;
                                    }
                            } else {
                                room[(i - 1)][j].setHasCharacter(false);
                                room[(i + 1)][j].setBeenSeen(true);
                                room[(i - 1)][j].setBeenSeen(true);
                                room[i][(j + 1)].setBeenSeen(true);
                                room[i][(j - 1)].setBeenSeen(true);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
                                currentRoom.setBeenSeen(true);
                                turnCounter();
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase(controls.moveUp)) {
                            i = i - 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                i = i + 1;
                            } else if (room[i][j].getIslocked() == true) {
                                for (Key key : keys)
                                    if (key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())) {
                                        System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                        room[(i + 1)][j].setHasCharacter(false);
                                        room[(i + 1)][j].setBeenSeen(true);
                                        room[(i - 1)][j].setBeenSeen(true);
                                        room[i][(j + 1)].setBeenSeen(true);
                                        room[i][(j - 1)].setBeenSeen(true);
                                        currentRoom = room[i][j];
                                        currentRoom.setHasCharacter(true);
                                        currentRoom.setBeenSeen(true);
                                        currentRoom.setIslocked(false);
                                        turnCounter();
                                        run = false;
                                        return currentRoom;
                                    } else {
                                        System.out.println("You haven't obtained this key yet, you need to find it");
                                        j = j - 1;
                                        run = true;
                                    }
                            } else {
                                room[(i + 1)][j].setHasCharacter(false);
                                room[(i + 1)][j].setBeenSeen(true);
                                room[(i - 1)][j].setBeenSeen(true);
                                room[i][(j + 1)].setBeenSeen(true);
                                room[i][(j - 1)].setBeenSeen(true);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
                                currentRoom.setBeenSeen(true);
                                turnCounter();
                                run = false;
                                return currentRoom;
                            }
                        }
                    } else
                        run = true;
                }
            }
        }
        return currentRoom;
    }

    /**
     * check to see who goes first
     *
     * @param monster
     * @return
     */
    public boolean attackFirst(MonsterController monster) {
        if (model.getSpeed() < monster.model.getSpeed()) {
            return false;
        } else
            return true;
    }

    /**
     * check to see if fleeing is successful
     *
     * @param hero
     * @return
     */
    public boolean flee(Hero hero) {
        Random rand = new Random();

        int chanceToFlee = rand.nextInt(100);
        if (chanceToFlee >= hero.getSpeed()) {
            return false;
        } else
            return true;
    }

    /**
     * use an item externally
     *
     * @param item
     */
    public void useItemExternal(Item item) {
        if (item instanceof Coffee) {
            model.setSpeed(coffee.getSpeed() + model.getSpeed());
            System.out.println("Current Speed: " + model.getSpeed());
        } else if (item instanceof Heart) {
            //heart.setExtraLife(1);
            model.setLives(heart.getExtraLife() + model.getLives());
            System.out.println("Current Lives: " + model.getLives());
        } else if (item instanceof HealthPotion) {
            //healthPotion.setAddHealth(60);
            if (model.getCharacterClass().equals("Warrior")) {
                if (model.getHealth() >= 60) {
                    model.setHealth(120);
                } else {
                    model.setHealth(healthPotion.getAddHealth() + model.getHealth());
                }
            } else if (model.getCharacterClass().equals("Mage")) {
                if (model.getHealth() >= 40) {
                    model.setHealth(100);
                } else {
                    model.setHealth(healthPotion.getAddHealth() + model.getHealth());
                }
            } else {
                if (model.getHealth() >= 20) {
                    model.setHealth(80);
                } else {
                    model.setHealth(healthPotion.getAddHealth() + model.getHealth());
                }
            }
            System.out.println("Current Health: " + model.getHealth());
        } else if (item == treasure) {
            model.setCurrentTreasure(treasure.getAmount() + model.getCurrentTreasure());
        }
    }

    public void useItem(ArrayList<Item> backPack) {
        int choice1;
        if (backPack.isEmpty()) {
            System.out.println("You do not have any item to use");
        } else {
            try {
                System.out.println("Choose an item to use ..");
                choice1 = input.nextInt();
                input.nextLine();
                useItemExternal(backPack.get(choice1 - 1));
                System.out.println(backPack.get(choice1 - 1).getName() + " has been used");
                backPack.remove(choice1 - 1);
            } catch (InputMismatchException e) {
                System.out.println("Enter a proper value");
            }catch (IndexOutOfBoundsException e) {
                System.out.println("You do not have this item to use");
            }
        }
    }

    public void saveItem(Item item, ArrayList<Item> backPack) {
        String choice;
        int choice1;
        backPack.add(item);
        System.out.println(item.getName() + " Has been added to your satchel");
    }

    public void dropItem(ArrayList<Item> backPack) {
        String choice;
        int choice1;
        try {
            System.out.println("Your backPack is full ... Do you want to drop an item from your back ! 'to be able to save the new one' ? Y/N ");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("choose an item to drop");
                printItem(backPack);
                choice1 = input.nextInt();
                input.nextLine();
                System.out.println(backPack.get(choice1 - 1).getName() + " Has been removed");
                backPack.remove(choice1 - 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no item to remove");
        }
    }

    /**
     * add treasure to current treasure
     *
     * @param treasure
     */

    public void addTreasure(Treasure treasure) {

        System.out.println("You found a chest that contained " + treasure.getName() + "\n" + treasure.getAmount() + " was added to your treasure score!");
        model.setCurrentTreasure(treasure.getAmount() + model.getCurrentTreasure());
        System.out.println("Your new score is: " + model.getCurrentTreasure() + "!");
    }

    /**
     * add treasure to current treasure
     *
     * @param weapon
     */


    /**
     * add key to keyring
     *
     * @param keyRing
     * @param key
     * @return
     */
    public ArrayList<Key> addKey(ArrayList<Key> keyRing, Key key) {

        keyRing.add(0, key);
        return keyRing;
    }

    /**
     * turn counter
     */
    public void turnCounter() {
        model.setTurnCounter(model.getTurnCounter() + 1);
        view.printTurnCount();
    }

    public void loseLife() {
        model.setLives(model.getLives() - 1);
    }

    public void heroAlive() {
        model.setAlive(true);
        model.setHealth(100);
    }

    public Room previousRoom(Room previousRoom, Room[][] room, Room currentRoom) {
        currentRoom.setHasCharacter(false);
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                if (room[i][j] == previousRoom) {
                    previousRoom = room[i][j];
                    previousRoom.setHasCharacter(true);
                    return previousRoom;
                }
            }

        }
        return previousRoom;
    }

    public Room currentRoom(Room currentRoom, Room[][] room) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                if (room[i][j] == currentRoom) {
                    currentRoom = room[i][j];
                    return currentRoom;
                }
            }

        }
        return currentRoom;
    }

    public void addEndurance() {
        if (model.getEndurance() < 95)
            model.setEndurance(model.getEndurance() + 5);
    }
}
