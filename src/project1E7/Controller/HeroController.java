package project1E7.Controller;


import project1E7.Model.*;
import project1E7.View.HeroView;
import project1E7.theTextAdventure;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class HeroController {
    Hero model;
    HeroView view;
    private Coffee coffee;
    private HealthPotion healthPotion;
    private Heart heart;
    private Treasure treasure;

    public HeroController(Hero model, HeroView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * hero attacks monster 50% chance of landing hit
     * @param monster
     * @return
     */
    public boolean attack(MonsterController monster) {

        if (model.getEndurance() < 10) {
            return false;
        }

        Random rand = new Random();

        int chanceToHit = rand.nextInt(2);
        if (chanceToHit == 0) {
            return false;
        }

        model.setEndurance(model.getEndurance() - 10);
        monster.takeDamage(model.getStrength());

        return true;

    }

    /**
     * hero takes damage from enemy attack
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
                            } else if (room[i][j].isIslocked() == true) {
                                for (Key key : keys)
                                if(key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())){
                                    System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                    room[i][(j+1)].setHasCharacter(false);
                                    currentRoom = room[i][j];
                                    currentRoom.setHasCharacter(true);
                                    turnCounter();
                                    run = false;
                                    return currentRoom;
                                } else {
                                    System.out.println("You haven't obtained this key yet, you need to find it");
                                    j = j + 1;
                                    run = true;
                                }
                            } else {
                                room[i][(j+1)].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
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
                            }  else if (room[i][j].isIslocked() == true) {
                                for (Key key : keys)
                                    if (key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())) {
                                        System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                        room[i][(j - 1)].setHasCharacter(false);
                                        currentRoom = room[i][j];
                                        currentRoom.setHasCharacter(true);
                                        turnCounter();
                                        run = false;
                                        return currentRoom;
                                    } else {
                                        System.out.println("You haven't obtained this key yet, you need to find it");
                                        j = j - 1;
                                        run = true;
                                    }
                            } else {
                                room[i][(j-1)].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
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
                            }  else if (room[i][j].isIslocked() == true) {
                                for (Key key : keys)
                                    if (key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())) {
                                        System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                        room[i-1][(j)].setHasCharacter(false);
                                        currentRoom = room[i][j];
                                        currentRoom.setHasCharacter(true);
                                        turnCounter();
                                        run = false;
                                        return currentRoom;
                                    } else {
                                        System.out.println("You haven't obtained this key yet, you need to find it");
                                        i = i - 1;
                                        run = true;
                                    }
                            } else {
                                room[(i-1)][j].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
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
                            }  else if (room[i][j].isIslocked() == true) {
                                for (Key key : keys)
                                    if (key.getName().equalsIgnoreCase(room[i][j].getDoor().getNameOfKey())) {
                                        System.out.println("You have the " + key.getName() + "you unlocked " + room[i][j].getDoor().getDescription());
                                        room[(i+1)][j].setHasCharacter(false);
                                        currentRoom = room[i][j];
                                        currentRoom.setHasCharacter(true);
                                        turnCounter();
                                        run = false;
                                        return currentRoom;
                                    } else {
                                        System.out.println("You haven't obtained this key yet, you need to find it");
                                        j = j - 1;
                                        run = true;
                                    }
                            } else {
                                room[(i+1)][j].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
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
     * @param hero
     * @return
     */
    public boolean flee(Hero hero) {
        Random rand = new Random();

        int chanceToFlee = rand.nextInt(100);
        if (chanceToFlee <= 50) {
            return false;
        } else
            return true;
    }

    /**
     * use an item externally
     * @param item
     */
    public void useItemExternal(Item item) {
        if (item == coffee) {
            model.setSpeed(coffee.getSpeed() + model.getSpeed());
        } else if (item == heart) {
            model.setLives(heart.getExtraLife() + model.getLives());
        } else if (item == healthPotion) {
            if (model.getHealth() <= 40) {
                model.setHealth(healthPotion.getAddHealth() + model.getHealth());
            } else model.setHealth(100);
        } else if (item == treasure) {
            model.setCurrentTreasure(treasure.getAmount() + model.getCurrentTreasure());
        }
    }

    /**
     * add treasure to current treasure
      * @param treasure
     */
    public void addTreasure ( int treasure){
        System.out.println("That chest contained " + treasure + " gold pieces");
        model.setCurrentTreasure(model.getCurrentTreasure() + treasure);
        System.out.println("Your new total " + model.getCurrentTreasure() + " of gold pieces");
    }

    /**
     * add key to keyring
     * @param keyRing
     * @param key
     * @return
     */
    public ArrayList<Key> addKey (ArrayList < Key > keyRing, Key key){

        keyRing.add(0, key);
        return keyRing;
        }

    /**
     * turn counter
     */
    public void turnCounter(){
        model.setTurnCounter(model.getTurnCounter() + 1);
        view.printTurnCount();
        }
    }
