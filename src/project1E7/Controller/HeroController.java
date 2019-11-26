package project1E7.Controller;


import project1E7.Model.Hero;
import project1E7.View.HeroView;

import java.util.Random;

public class HeroController{
    Hero model;
    HeroView view;

    public HeroController(Hero model, HeroView view) {
        this.model = model;
        this.view = view;
    }

    public boolean Attack(MonsterController monster) {
        int damageDone;

        Random rand = new Random();
        return true;

    }


}
