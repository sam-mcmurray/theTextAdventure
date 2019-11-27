package project1E7;

import project1E7.Model.Hero;
import project1E7.View.HeroView;

import java.util.Scanner;

public class TheTextAdventure {
    Scanner input = new Scanner(System.in);
    public Hero warrior = new Hero(100, 80, 30, "The Warrior...", "Warrior", 40);
    public Hero mage = new Hero(100, 60, 40, "The Mage...", "Mage", 50);
    public Hero thief = new Hero(100, 40, 60, "The Thief...", "Thief", 60);

    public static void main(String[] args) {
        TheTextAdventure myApp = new TheTextAdventure();
        HeroView hero = new HeroView(myApp.selectHero());
        hero.printStats();

    }

    public Hero selectHero() {
        HeroView heroViewWarrior = new HeroView(warrior);
        heroViewWarrior.printStats();

        HeroView heroViewMage = new HeroView(mage);
        heroViewMage.printStats();


        HeroView heroViewThief = new HeroView(thief);
        heroViewThief.printStats();


        boolean selected = true;
        while (selected == true) {

            System.out.println("Select Character :" +
                    " \n 1.Warrior : \n 2.Mage : \n 3.Thief");

            System.out.println("Please enter your choice");
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    selected = heroViewWarrior.selectHero(warrior);
                    if (selected == false) {
                        return warrior;
                    } else
                        selected = true;
                    break;
                case 2:
                    selected = heroViewWarrior.selectHero(mage);
                    if (selected == false) {
                        return mage;
                    } else
                        selected = true;
                    break;
                case 3:
                    selected = heroViewWarrior.selectHero(thief);
                    if (selected == false) {
                        return thief;
                    } else
                        selected = true;
                    break;
                default:
                    System.out.println("Please enter a valid option...");
                    break;
            }
        }
        return null;
    }

    public void startMenu() {
        System.out.println("1.Start game\n2.Load game\n3.View High Scores \n4.Quit");
        int userInput = input.nextInt();
        switch (userInput) {
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
 /*  public void moveHero(){
        String userInput;
        for (int i = 0; i < rooms.length; ) {
            for (int j = 0; j < rooms[i].length; ) {
                System.out.println("Choose your direction ");
                userInput = input.nextLine();
                input.nextLine();
                if (userInput.equalsIgnoreCase("l")) {
                    j++;
                    System.out.println(rooms[i][j]);
                } else if (userInput.equalsIgnoreCase("r")) {
                    j--;
                    System.out.println(rooms[i][j]);
                } else if (userInput.equalsIgnoreCase("s")) {
                    i++;
                    System.out.println(rooms[i][j]);
                } else if (userInput.equalsIgnoreCase("w")) {
                    i--;
                    System.out.println(rooms[i][j]);
                }
            }
        }
    }
}*/
