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
            System.out.println("Health: " + model.getHealth());
        } else {
            System.out.println("The " + monster + "has been defeated at your hands...");
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
        System.out.println("flavor text monster present");
    }

    /**
     * prints monster hit landing flavor text
     * @param theHero
     */
    public void monsterHitFlavorText(Hero theHero) {
        System.out.println("monster hit flavor text");
    }

    /**
     * prints monster miss flavor text
     * @param theHero
     */
    public void monsterMissFlavorText(Hero theHero) {
        System.out.println("Monster miss flavor text");
    }

}
