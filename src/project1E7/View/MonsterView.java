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

    /**
     * prints the status of the monster
     * @param monster
     */
    public void printStatus(Monster monster) {
        System.out.println("Enemy Type: " + model.getDescription());
        if (model.isAlive()) {
            System.out.println(model.getName() + " Health: " + model.getHealth());
        } else {
            System.out.println("The " + model.getName() + " has been defeated at your hands...");
        }
    }

    /**
     *  prints encountering a monster
     * @param monster
     */
    public void encounter(Monster monster){
        System.out.printf("You have encountered a %s ! ", monster.getDescription());
    }

    /**
     * prints the flavor text for the monster
     */
    public void flavorTextMonster() {
        if (model.getName().equalsIgnoreCase("The Boss")){
            System.out.println("flavor text the boss");
        } else if (model.getName().equalsIgnoreCase("The Owl Bear")) {
            System.out.println("flavor text the owl bear");
        } else if (model.getName().equalsIgnoreCase("The Skeleton")) {
            System.out.println("flavor text the skeleton");
        } else if (model.getName().equalsIgnoreCase("The Bat")) {
            System.out.println("flavor text the bat");
        } else if (model.getName().equalsIgnoreCase("The Slime")) {
            System.out.println("flavor text the slime");
        } else {
            System.out.println("flavor text the spiderling");
        }
    }

    /**
     * prints monster hit landing flavor text
     * @param theHero
     */
    public void monsterHitFlavorText(Hero theHero) {
        if (theHero.getName().equalsIgnoreCase("warrior")) {
            System.out.println("flavor text monster missed warrior");
        } else if (theHero.getName().equalsIgnoreCase("mage")) {
            System.out.println("flavor text monster missed mage");
        } else {
            System.out.println("flavor text monster missed thief");
        }
    }

    /**
     * prints monster miss flavor text
     * @param theHero
     */
    public void monsterMissFlavorText(Hero theHero) {
        if (theHero.getName().equalsIgnoreCase("warrior")) {
            System.out.println("flavor text monster missed warrior");
        } else if (theHero.getName().equalsIgnoreCase("mage")) {
            System.out.println("flavor text monster missed mage");
        } else {
            System.out.println("flavor text monster missed thief");
        }
    }

}
