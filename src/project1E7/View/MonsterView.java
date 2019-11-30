package project1E7.View;

import project1E7.Model.Monster;

public class MonsterView {
    Monster model;

    public MonsterView(Monster model) {
        this.model = model;
    }

    public void printStatus(Monster monster) {
        System.out.println("Enemy Type: " + model.getDescription());
        if (model.isAlive() == true) {
            System.out.println("Health: " + model.getHealth());
        }
        else {
            System.out.println("The " + monster + "has been defeated at your hands...");
        }
    }

}
