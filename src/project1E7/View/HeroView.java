package project1E7.View;


import project1E7.Model.Hero;
import project1E7.Model.Item;
import project1E7.Model.Monster;
import project1E7.theTextAdventure;

import java.util.*;


public class HeroView {

    Hero model;
    Scanner input = new Scanner(System.in);

    public HeroView(Hero model) {
        this.model = model;
    }

    /**
     * prints bar chart for the hero stats
     */
    public void printStats() {
        int[] stats = new int[4];
        stats[0] = model.getHealth() / 10;
        stats[1] = model.getSpeed() / 10;
        stats[2] = model.getStrength() / 10;
        stats[3] = model.getEndurance() / 10;

        String[] tableDescrip = new String[4];
        tableDescrip[0] = "Health:    ";
        tableDescrip[1] = "Speed:     ";
        tableDescrip[2] = "Strength:  ";
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

    /**
     * prints the select hero confirmation statement
     * @param hero
     * @return
     */
    public boolean selectHero(Hero hero) {
        System.out.println("Do you want to select the" + hero + " to be your hero? " + "Yes/No");
        String choice = input.next();
        boolean valid = true;

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println(hero + " has been selected");
            return false;
        } else
        return true;
    }

    /**
     * prints the heroes status
     * @param hero
     */
    public void printStatus(Hero hero) {
        if (model.isAlive()) {
            System.out.println(model.getName() + " Health: " + model.getHealth());
            System.out.println(model.getName() + " Endurance: " + model.getEndurance());
        } else {
            System.out.println("You have been defeated...");
        }
    }

    /**
     * suppose to show heroes inventory i dont think it works its untested
     * @param items
     */
    public void inventory(ArrayList<Item> items) {
        items = model.getBackPack();
        int choice;
        for (int i = 0; i<=items.size()-1; i++) {
            System.out.println("[" + (i + 1) + "]" + items.get(i));
        }

    }

    /**
     * not sure what this is suppose to do lukas
     */
    public void printClassDescription() {

    }

    /**
     * prints the heroes story
     */
    public void heroStory() {
        String characterClass = model.getCharacterClass();
        System.out.println("Your head aches as you awake from your fall.  You look up to see where you fell from and try to remember exactly what happened. rappelling down the ruins\n" +
                "was going well until you felt your rope go slack. Exploring decrepit ruins of ancient civilizations is dangerous work but it certainly pays well if you can find\n" +
                "some treasure. Looking at the scattering of your adventuring items beside you, you start start to gather your things; a backpack capable of holding an assortment \n" +
                "items, a keychain for keeping any keys you find handy, and of course the most important tool in your arsenal: your " + getWeapon(characterClass) + ". As start to gather what is\n" +
                "left of your rope, you look at the end of it and realize it didn't snap, rather, it was a clean cut. You are not alone! Something wants to keep you here and you won't be\n" +
                "able to climb back the way you came. ahead of you are three doors. One to your North, East, and West. It looks like you'll have to find another way out. It sounds as if\n" +
                "there is movement in the other rooms but it's impossible to tell which. It's time to make a choice. Which direction should you go?");
    }

    /**
     * returns the current heroes weapon
     * @param characterClass
     * @return
     */
    public String getWeapon(String characterClass) {
        String weapon = "";
        if (model.getCharacterClass().equals("Warrior")) {
            weapon = "long sword";
        } else if (model.getCharacterClass().equals("Mage")) {
            weapon = "staff";
        } else if (model.getCharacterClass().equals("Thief")) {
            weapon = "dagger";
        } else {
            weapon = "ERROR: No weapon found";
        }
            return weapon;
    }

    /**
     * prints hit landed flavor text for hero
     * @param monster
     */
    public void hitMonsterFlavorText(Monster monster) {
        if (model.getName().equalsIgnoreCase("warrior")) {
            System.out.println("flavor text hit monster warrior");
        } else if (model.getName().equalsIgnoreCase("mage")) {
            System.out.println("flavor text hit monster mage");
        } else {
            System.out.println("flavor text hit monster thief");
        };
    }

    /**
     * prints missed flavor text for the hero
     * @param monster
     */
    public void missMonsterFlavorText(Monster monster) {
        if (model.getName().equalsIgnoreCase("warrior")) {
            System.out.println("flavor text missed monster warrior");
        } else if (model.getName().equalsIgnoreCase("mage")) {
            System.out.println("flavor text missed monster mage");
        } else {
            System.out.println("flavor text missed monster thief");
        }

    }

    /**
     * prints the number of hero turns for the game
     */
    public void printTurnCount(){
        System.out.println("Current number of turns: " + model.getTurnCounter());
    }

    public void printLives() {
        System.out.println("Current number of lives: " + model.getLives());
    }
    public void fleeFail() {
        System.out.println("You were unable to flee.");
    }
    public void fleeSuccess() {
        System.out.println("You were successful in your attempt to flee.");
    }
}