package project1E7.Controller;


import project1E7.Model.Hero;
import project1E7.Model.Room;
import project1E7.View.HeroView;

import java.util.Random;

public class HeroController{
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
    public boolean fleeRoom(MonsterController monster){
        return false;


    }
    public void takeDamage(int incDamage) {
        if (incDamage > model.getHealth()) {
            model.setAlive(false);
        }
        model.setHealth(model.getHealth() - incDamage);
    }


}
