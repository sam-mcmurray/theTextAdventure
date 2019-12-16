package project1E7.Controller;


import project1E7.Model.*;
import project1E7.View.HeroView;

import java.util.ArrayList;
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

    public void takeDamage(int incDamage) {
        if (incDamage >= model.getHealth()) {
            model.setAlive(false);
        }
        model.setHealth(model.getHealth() - incDamage);
    }

    public Room moveHero(Room[][] room, Room currentRoom ) {
        Scanner input = new Scanner(System.in);
        String direction;
        boolean run = true;
        while (run == true) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j <room.length ; j++) {
                if (currentRoom == room[i][j]) {
                    System.out.println("Choose your direction ");
                        direction = input.nextLine();
                        if (direction.equalsIgnoreCase("a")) {
                            j = j - 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                room[i][j] = currentRoom;
                            } else {
                                currentRoom = room[i][j];
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase("d")) {
                            j = j + 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                room[i][j] = currentRoom;
                            } else {
                                currentRoom = room[i][j];
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase("s")) {
                            i = i + 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                room[i][j] = currentRoom;
                            } else {
                                currentRoom = room[i][j];
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase("w")) {
                            i = i - 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                room[i][j] = currentRoom;
                            } else {
                                currentRoom = room[i][j];
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
    public boolean attackFirst(MonsterController monster) {
        if (model.getSpeed() < monster.model.getSpeed()) {
            return false;
        } else
            return true;
    }

    public boolean flee(Hero hero) {
        Random rand = new Random();

        int chanceToFlee = rand.nextInt(100);
        if (chanceToFlee <= 50) {
            return false;
        } else
            return true;
    }
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
    public void addTreasure(int treasure) {
        System.out.println("That chest contained " + treasure + " gold pieces");
        model.setCurrentTreasure(view.getCurrentTreasure() + treasure);
        System.out.println("Your new total " + model.getCurrentTreasure() + " of gold pieces");
    }
    public void addKey(Key key) {

    }

}