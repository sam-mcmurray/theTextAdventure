package project1E7.View;


import project1E7.Model.Hero;
import project1E7.Model.Item;
import project1E7.Model.Monster;

import project1E7.theTextAdventure;
import project1E7.*;

import java.util.ArrayList;
import java.util.Scanner;


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
     *
     * @param hero
     * @return
     */
    public boolean selectHero(Hero hero) {
        System.out.println("Do you want to select the" + hero + " to be your hero? " + "Yes/No");
        String choice = input.next();
        boolean valid = true;

        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.println(hero + " has been selected");
            return false;
        } else
            return true;
    }

    /**
     * prints the heroes status
     *
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
     *
     * @param items
     */
    public void inventory(ArrayList<Item> items) {
        items = model.getBackPack();
        int choice;
        for (int i = 0; i <= items.size() - 1; i++) {
            System.out.println("[" + (i + 1) + "]" + items.get(i).getName());
        }
    }

    /**
     * prints the heroes story
     */
    public void heroStory() {
        String characterClass = model.getCharacterClass();
        System.out.println("Your head aches as you awake from your fall.  You look up to see where you fell from and try to remember exactly what happened. rappelling down the ruins\n" +
                "was going well until you felt your rope go slack. Exploring decrepit ruins of ancient civilizations is dangerous work but it certainly pays well if you can find\n" +
                "some treasure. Looking at the scattering of your adventuring items beside you, you start start to gather your things; a backpack capable of holding an assortment \n" +
                "items, a keychain for keeping any keys you find handy, and of course the most important tool in your arsenal: your " + getWeapon() + ". As start to gather what is\n" +
                "left of your rope, you look at the end of it and realize it didn't snap, rather, it was a clean cut. You are not alone! Something wants to keep you here and you won't be\n" +
                "able to climb back the way you came. ahead of you are three doors. One to your North, East, and West. It looks like you'll have to find another way out. It sounds as if\n" +
                "there is movement in the other rooms but it's impossible to tell which. It's time to make a choice. Which direction should you go?");
    }

    /**
     * returns the current heroes weapon
     *
     * @return
     */
    public String getWeapon() {
        String weapon = "";
        if (model.getCharacterClass().equals("Warrior")) {
            weapon = "Long Sword";
        } else if (model.getCharacterClass().equals("Mage")) {
            weapon = "Magic Scepter";
        } else if (model.getCharacterClass().equals("Thief")) {
            weapon = "Curved Dagger";
        } else {
            weapon = "ERROR: No weapon found";
        }
        return weapon;
    }

    /**
     * prints hit landed flavor text for hero
     *
     * @param monster
     */
    public void hitMonsterFlavorText(Monster monster) {
        if (model.getName().equalsIgnoreCase("warrior")) {
            System.out.println("Swinging your longsword in a long sweeping hit starting from top right of your head and ending downwards to the bottom left, your blade makes contact with " + monster.getName() + ".\n" +
                    monster.getName() + " shrieks in pain and anger.");
        } else if (model.getName().equalsIgnoreCase("mage")) {
            System.out.println("Using your staff and an intense focus, you conjure an ever growing fireball at the crystal focal of your staff until you finally launch it.\n" +
                    monster.getName() + " burns horribly dealing substantial damage");
        } else {
            System.out.println("Your dagger is a whirlwind of flashing steel as you stab at " + monster.getName() + " with lightning speed and an unnatural precision.\n" +
                    monster.getName() + " recoils in confusion and pain.");
        }
        ;
    }

    /**
     * prints missed flavor text for the hero
     *
     * @param monster
     */
    public void missMonsterFlavorText(Monster monster) {
        if (model.getName().equalsIgnoreCase("warrior")) {
            System.out.println("With extreme confidence you attempt to spin in a circle while holding your blade out creating a spinning circle of death as you've seen all your favorite heroes do.\n" +
                    monster.getName() + "appears confused but was never in any danger. Your arrogance ended in absolute failure and your attack misses!");
        } else if (model.getName().equalsIgnoreCase("mage")) {
            System.out.println("Despite years of training in the arcane arts, the fireball you attempt to conjure at the end of your staff only sparks pitifully before fizzling out. \n" +
                    monster.getName() + " appears almost embarrassed for you as you try and explain this doesn't normally happen and you just haven't been in a battle in a little while! \n"
                    + monster.getName() + " explains that he thinks they make pills for that now and to maybe check it out.  Your attack misses!");
        } else {
            System.out.println("With your enemy out of range of your dagger, you fall back and attempt to use your hidden ninja stars you recently acquired from an exotic weapons vendor. \n" +
                    "You launch three of them right at " + monster.getName() + "only to see them harmlessly bounce off of it as the ninja stars clatter on the stone ground.\n" +
                    "Damn, you the clerk who sold them to you swore they were real.  Your attack misses!");
        }

    }

    /**
     * prints the number of hero turns for the game
     */
    public void printTurnCount() {
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