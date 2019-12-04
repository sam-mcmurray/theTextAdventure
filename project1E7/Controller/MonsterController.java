package src.project1E7.Controller;

import src.project1E7.Model.Monster;

import java.util.Random;

public class MonsterController {
    Monster model;

    public MonsterController(Monster model) {
        this.model = model;
    }

    public void takeDamage(int incDamage) {

        if (incDamage > model.getHealth()) {
            model.setAlive(false);
        } else
        model.setHealth(model.getHealth() - incDamage);

    }

    public boolean attack(HeroController hero) {

        int damageDone;
        Random rand = new Random();

        int chanceToHit = rand.nextInt(100);

        if (chanceToHit < 50) {
            return false;
        } else

        damageDone = model.getStrength();

        hero.takeDamage(damageDone);

        return true;

    }

}
