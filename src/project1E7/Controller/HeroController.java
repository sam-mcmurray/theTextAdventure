package project1E7.Controller;


import project1E7.Model.Hero;
import project1E7.Model.Item;
import project1E7.Model.Monster;
import project1E7.Model.Room;
import project1E7.View.HeroView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

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
        boolean run = true;
        do {
            out.println("Choose your direction ");
            direction = input.nextLine();
            input.nextLine();
            if (direction.equalsIgnoreCase("l")) {
                out.println(room[+0][+1]);
                run = false;
                return room;
            } else if (direction.equalsIgnoreCase("r")) {
                out.println(room[+0][-1]);
                run = false;
                return room;
            } else if (direction.equalsIgnoreCase("s")) {
                out.println(room[+1][+0]);
                run = false;
                return room;
            } else if (direction.equalsIgnoreCase("w")) {
                out.println(room[-1][0]);
                run = false;
                return room;
            }
        }  while (run == true);
        return null;
    }
    public boolean attackFirst(Hero hero, Monster monster) {
        if (hero.getSpeed() < monster.getSpeed()) {
            return false;
        } else
            return true;
    }
    public boolean flee(Hero hero) {
        Random rand = new Random();

        int chanceToFlee = rand.nextInt(101);
        if (chanceToFlee <= 50) {
            return false;
        } else
            return true;
    }

}