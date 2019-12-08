package project1E7.View;


import project1E7.Model.Hero;
import project1E7.Model.Item;

import java.util.*;


public class HeroView {

    Hero model;
    Scanner input = new Scanner(System.in);

    public HeroView(Hero model) {
        this.model = model;
    }

    public void printStats() {
        int[] stats = new int[4];
        stats[0] = model.getHealth() / 10;
        stats[1] = model.getSpeed() / 10;
        stats[2] = model.getStrength() / 10;
        stats[3] = model.getEndurance() / 10;

        String[] tableDescrip = new String[4];
        tableDescrip[0] = "Health: ";
        tableDescrip[1] = "Speed: ";
        tableDescrip[2] = "Strength: ";
        tableDescrip[3] = "Endurance: ";

        System.out.println("Name: " + model.getName());
        System.out.println("Character Description: " + model.getDescription());

        for (int i = 0; i < stats.length; i++) {
            System.out.print(tableDescrip[i]);
            for (int j = 0; j < stats[i]; j++) {
                System.out.print("*");
            }
            System.out.printf("%n");

        }
    }

    public boolean selectHero(Hero hero) {


        System.out.println("Do you want to select the" + hero + " to be your hero? " + "Yes/No");
        String choice = input.next();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println(hero + " has been selected");
            return false;
        }
        return true;
    }

    public void printStatus(Hero hero) {
        if (model.isAlive() == true) {
            System.out.println("Health: " + model.getHealth());
            System.out.println("Endurance: " + model.getEndurance());
        } else {
            System.out.println("You have been defeated...");
        }
    }

    public void inventory(ArrayList<Item> items) {
        items = model.getBackPack();

        for (int i = 0; i < 5; i++) {
            System.out.println("[" + (i + 1) + "]" + items.get(i));
        }

    }

    public void printClassDescription() {

    }
        public void currentTreasure(){
            System.out.println("Treasure total: " + model.getCurrentTreasure());
        }
        public void heroStory() {
            System.out.println("Your head aches as you awake from your fall.  You look up to see where you fell from and try to remember exactly what happened. rappelling down the ruins\n" +
                    "was going well until you felt your rope go slack. Exploring decrepit ruins of ancient civilizations is dangerous work but it certainly pays well if you can find\n" +
                    "some treasure. Looking at the scattering of your adventuring items beside you, you start start to gather your things; a backpack capable of holding an assortment \n" +
                    "items, a keychain for keeping any keys you find handy, and of course the most important tool in your arsenal: your " +/* + hero.getWeapon*/". As start to gather what is\n" +
                    "left of your rope, you look at the end of it and realize it didn't snap, rather, it was a clean cut. You are not alone! Something wants to keep you here and you won't be\n" +
                    "able to climb back the way you came. ahead of you are three doors. One to your North, East, and West. It looks like you'll have to find another way out. It sounds as if\n" +
                    "there is movement in the other rooms but it's impossible to tell which. It's time to make a choice. Which direction should you go?");

        }
    }