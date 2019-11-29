package project1E7.Controller;


import project1E7.Model.Hero;
import project1E7.Model.Monster;
import project1E7.Model.Room;
import project1E7.View.HeroView;

import java.util.Random;
import java.util.Scanner;

public class HeroController {
    Hero model;
    HeroView view;

    public HeroController(Hero model, HeroView view) {
        this.model = model;
        this.view = view;
    }

    public boolean attack(MonsterController monster) {

        if (model.getEndurance() < 10) {
            return false;
        }

        Random rand = new Random();

        int chanceToHit = rand.nextInt(101);
        if (chanceToHit <= 50) {
            return false;
        }

        model.setEndurance(model.getEndurance() - 10);

        monster.takeDamage(model.getStrength());

        return true;

    }

    public boolean fleeRoom(MonsterController monster) {
        return false;


    }

    public void takeDamage(int incDamage) {
        if (incDamage > model.getHealth()) {
            model.setAlive(false);
        }
        model.setHealth(model.getHealth() - incDamage);
    }


    public Room[][] moveHero(Room[][] room ) {
        Scanner input = new Scanner(System.in);
        String direction;
                System.out.println("Choose your direction ");
                direction = input.nextLine();
                input.nextLine();
                if (direction.equalsIgnoreCase("l")) {
                    System.out.println(room[+ 0][+1]);
                    return room;
                } else if (direction.equalsIgnoreCase("r")) {
                    System.out.println(room[ + 0][-1]);
                    return room;
                } else if (direction.equalsIgnoreCase("s")) {
                    System.out.println(room[+1][+0]);
                    return room;
                } else if (direction.equalsIgnoreCase("w")) {
                    System.out.println(room[-1][0]);
                    return room;
                }

        return null;
    }
    public boolean attackFirst(Hero hero, Monster monster) {
        if (hero.getSpeed() < monster.getSpeed()) {
            return false;
        } else
            return true;
    }
}