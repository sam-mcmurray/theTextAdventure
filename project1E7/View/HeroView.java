package src.project1E7.View;

<<<<<<< HEAD
import src.project1E7.Model.Hero;
=======
import project1E7.Controller.HeroController;
import project1E7.Model.Hero;
import project1E7.Model.Room;

import java.util.*;
>>>>>>> 43eb596d375b5da72f855b2146faf9a919e5464a

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
}