package project1E7.View;

import project1E7.Model.Monster;

public class MonsterVIew {
    Monster model;

    public MonsterVIew(Monster model) {
        this.model = model;
    }

    public void PrintStatus(Monster monster) {
        System.out.println("Enemy Type: " + model.getDescription());
        if (model.isAlive() == true) {
            System.out.println("Health: " + model.getHealth());
        }
        else {
            System.out.println("The " + monster + "has been defeated at your hands...");
        }
    }

}
