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
    public String controls[] = {"w", "s", "d", "a"};


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

    public Room moveHero(Room[][] room, Room currentRoom) {

        Scanner input = new Scanner(System.in);
        String direction;
        boolean run = true;
        while (run == true) {
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room.length; j++) {
                    if (currentRoom == room[i][j]) {

                        System.out.println("Choose your direction ");
                        direction = input.nextLine();
                        if (direction.equalsIgnoreCase("a")) {
                            j = j - 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                j = j + 1;
                            } else {
                                room[i][(j+1)].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase("d")) {
                            j = j + 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                j = j - 1;
                            } else {
                                room[i][(j-1)].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase("s")) {
                            i = i + 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                i = i - 1;
                            } else {
                                room[(i-1)][j].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
                                run = false;
                                return currentRoom;
                            }
                        } else if (direction.equalsIgnoreCase("w")) {
                            i = i - 1;
                            if (room[i][j].getDescription().equals("wall")) {
                                System.out.println("You can not go that way there is no door.");
                                run = true;
                                i = i + 1;
                            } else {
                                room[(i+1)][j].setHasCharacter(false);
                                currentRoom = room[i][j];
                                currentRoom.setHasCharacter(true);
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


        public void addTreasure ( int treasure){
            System.out.println("That chest contained " + treasure + " gold pieces");
            model.setCurrentTreasure(view.getCurrentTreasure() + treasure);
            System.out.println("Your new total " + model.getCurrentTreasure() + " of gold pieces");
        }

        public ArrayList<Key> addKey (ArrayList < Key > keyRing, Key key){

            keyRing.add(0, key);
            return keyRing;
        }
    }
    /*
    public void subMenu() {

        Scanner input = new Scanner(System.in);

        int choice = 0;
        boolean chosen = false;

        subMenu();

        do {

            boolean chosen1 = false;
            int tempCount = 0;

            while (!chosen1) {

                try {
                    System.out.println("Choose one of the following options. To exit this menu enter 0");
                    System.out.printf("1- View controls %n" +
                            "2- Change controls %n" +
                            "3- View instructions %n" +
                            "4- View map %n" +
                            "5- Save game %n" +
                            "6- Load game %n" +
                            "7- Quit game %n ");

                    choice = input.nextInt();

                    if (tempCount == 0) {

                        choice = input.nextInt();
                    } else {
                        input.nextLine();
                        choice = input.nextInt();
                    }

                    chosen1 = true;
                } catch (InputMismatchException e) {

                    System.out.println("Invalid choice");
                    chosen1 = false;
                    ++tempCount;
                }

                if (choice > 7 || choice < 0) {

                    System.out.println("Choose an available option");

                    chosen = false;
                }
            }


        }

        while (!chosen);


        switch (choice) {

            case 0:

                System.out.println("Exited menu");

                break;

            case 1:

                System.out.println("The following are the commands in place:");

                System.out.printf("Moving up: %s %n" +
                        "Moving down: %s %n" +
                        "Moving right: %s %n" +
                        "Moving left: %s %n", control.getMoveUp(), control.getMoveDown(), control.getMoveRight(), control.getMoveLeft());

                break;

            case 2:

                chosen = false;

                while (!chosen) {

                    try {

                        System.out.printf("Which one of the controls would you like to change: ");

                        System.out.printf("1- Moving up: %s %n" +
                                "2- Moving down: %s %n" +
                                "3- Moving right: %s %n" +
                                "4- Moving left: %s %n", controls[0], controls[1], controls[2], controls[3]);

                        int choice1 = input.nextInt();
                        boolean decided = false;

                        switch (choice1) {

                            case 1:

                                changeControls(controls);

                                break;

                            case 2:

                                break;

                            case 3:

                                break;


                            case 4:

                                break;

                        }

                        chosen = true;

                    } catch (InputMismatchException a) {

                        System.out.println("Invalid choice");

                        chosen = false;
                    }
                }


                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;
        }
    }


    public String changeControls(String Controls[]) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter which control you would like to change");
        System.out.printf("1- %s%n" +
                "2- %s%n" +
                "3- %s%n" +
                "4- %s%n", controls[0], controls[1], controls[2], controls[3]);

        try {
            int temp = input.nextInt();

            switch (temp) {

                case 1:

                    break;

                case 2:

                    break;


                case 3:


                    break;

                case 4:

                    break;

                default:

            }

        } catch (InputMismatchException e) {

        }


    }*/