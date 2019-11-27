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

        boolean selected = true;
        while (selected) {

            System.out.println("Select Character :" +
                    " \n 1.Warrior : \n 2.Mage : \n 3.Thief");

            for (int i = 0; i < characters.size(); i++) {
                if (characters.get(i) instanceof Hero) {
                    System.out.println(characters.get(i));
                }
            }

            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Do you want to select this hero ?" + "Yes/No");
                    input.nextLine();
                    String choice = input.next();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println(characters.get(0));
                        System.out.println("Warrior has been selected");
                        selected = false;
                    } else if (choice.equalsIgnoreCase("no")) {
                        System.out.println("Select another hero");
                        setCharacters();
                    } else System.out.println("Select a valid option");
                    break;
                case 2:
                    System.out.println(characters.get(1));
                    System.out.println("Do you want select this hero ?" + "Yes/No");
                    input.nextLine();
                    choice = input.next();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("Mage has been selected");
                        selected = false;
                    } else setCharacters();
                    break;
                case 3:
                    System.out.println(characters.get(2));
                    System.out.println("Do you want select this hero ?" + "Yes/No");
                    input.nextLine();
                    choice = input.next();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("Thief has been selected");
                        selected = false;
                        break;
                    } else selectHero();
                    break;
            }
        }


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
