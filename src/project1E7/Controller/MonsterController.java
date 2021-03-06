package project1E7.Controller;

import project1E7.Model.Hero;
import project1E7.Model.Monster;
import project1E7.View.MonsterView;

import java.util.Random;

public class MonsterController {
    Monster model;
    MonsterView view;

    public MonsterController(Monster model, MonsterView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * monster takes damage
     * @param incDamage
     */
    public void takeDamage(int incDamage) {

        if (incDamage >= model.getHealth()) {
            model.setAlive(false);
        } else {
            model.setHealth(model.getHealth() - incDamage);
        }
    }

    /**
     * monster attacking with 50% chance to hit
     * @param hero
     * @return
     */
    public boolean attack(HeroController hero, Hero theHero) {

        int damageDone;
        Random rand = new Random();

        int chanceToHit = rand.nextInt(120);

        if (chanceToHit <= theHero.getSpeed()) {
            return false;
        } else {

            damageDone = model.getStrength();

            hero.takeDamage(damageDone);

            return true;
        }
    }

    public void resetMonster() {

        if (model.getName().equals("Spiderling")) {
            model.setHealth(40);
            model.setStrength(6);
            model.setSpeed(90);
            model.setAlive(true);
        } else if (model.getName().equals("Bat")) {
            model.setHealth(70);
            model.setStrength(8);
            model.setSpeed(70);
            model.setAlive(true);
        } else if (model.getName().equals("Skeleton")) {
            model.setHealth(80);
            model.setStrength(12);
            model.setSpeed(50);
            model.setAlive(true);
        } else if (model.getName().equals("Slime")) {
            model.setHealth(90);
            model.setStrength(15);
            model.setSpeed(30);
            model.setAlive(true);
        } else if (model.getName().equals("Owlbear")) {
            model.setHealth(130);
            model.setStrength(20);
            model.setSpeed(60);
            model.setAlive(true);
        } else {
            model.setHealth(180);
            model.setStrength(30);
            model.setSpeed(70);
            model.setAlive(true);
        }
    }
}
