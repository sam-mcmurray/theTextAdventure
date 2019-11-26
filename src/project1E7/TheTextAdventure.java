package project1E7;

import project1E7.Controller.HeroController;
import project1E7.Model.Character;
import project1E7.Model.Coffee;
import project1E7.Model.Hero;
import project1E7.Model.Item;
import project1E7.View.HeroView;

import java.util.Scanner;

public class TheTextAdventure {
    Scanner input = new Scanner(System.in);

    Hero warrior = new Hero(100, 80, 30, "The Warrior...", "Warrior", 40);
    Hero mage = new Hero(100, 60, 40, "The Mage...", "Mage", 50);
    Hero thief = new Hero(100, 40, 60, "The Thief...", "Thief", 60);

    public static void main(String[] args) {
        TheTextAdventure myApp = new TheTextAdventure();
        myApp.printStats();

    }

    public void printStats() {
        HeroView heroViewWarrior = new HeroView(warrior);
        heroViewWarrior.printStats();

        HeroView heroViewMage = new HeroView(mage);
        heroViewMage.printStats();


        HeroView heroViewThief = new HeroView(thief);
        heroViewThief.printStats();
    }

    public void selectHero() {
        System.out.println();
    }

    public void encounterMenu() {
        System.out.printf("%nYou have encountered a monster!%n" +
                "What is your next move?%n" +
                "To run away enter 'flee'%n" +
                "To fight enter 'fight' %n" +
                "To use one of your item enter 'item'%n");

        String temp = input.nextLine();

    }
}
