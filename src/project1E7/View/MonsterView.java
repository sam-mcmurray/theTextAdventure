package project1E7.View;

import project1E7.Model.Hero;
import project1E7.Model.Monster;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MonsterView {
    Scanner input = new Scanner(System.in);
    Monster model;

    public MonsterView(Monster model) {
        this.model = model;
    }

    public void printStatus(Monster monster) {
        System.out.println("Enemy Type: " + model.getDescription());
        if (model.isAlive()) {
            System.out.println("Health: " + model.getHealth());
        } else {
            System.out.println("The " + monster + "has been defeated at your hands...");
        }
    }

    public int encounterMenu() {

        boolean decision = false;
        int choice = 0;
        int count = 0;

        while (!decision) {
            System.out.printf("You have encountered a %s ! ", model.getDescription());
            System.out.println("What is your next move?");
            System.out.println("1)Fight ");
            System.out.println("2)Flee");
            System.out.println("3)Use Item");

            try {
                if (count > 1) {

                    input.nextLine();
                    choice = input.nextInt();

                } else {

                    choice = input.nextInt();

                }
                while (choice < 1 || choice > 3) {

                    System.out.println("Enter an available option!");
                    choice = input.nextInt();
                }

                decision = true;

            } catch (InputMismatchException e) {

                System.out.println("Invalid answer");
                decision = false;
                count++;
            }
        }

        return choice;
    }

    public void flavorTextMonster() {
        System.out.println("flavor text monster present");
    }

    public void monsterHitFlavorText(Hero theHero) {
        System.out.println("monster hit flavor text");
    }

    public void monsterMissFlavorText(Hero theHero) {
        System.out.println("Monster miss flavor text");
    }

}
