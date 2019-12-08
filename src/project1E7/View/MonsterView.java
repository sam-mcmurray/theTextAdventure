package project1E7.View;

import project1E7.Model.Hero;
import project1E7.Model.Monster;

public class MonsterView {
    Monster model;

    public MonsterView(Monster model) {
        this.model = model;
    }

    public void printStatus(Monster monster) {
        System.out.println("Enemy Type: " + model.getDescription());
        if (model.isAlive()) {
            System.out.println("Health: " + model.getHealth());
        }
        else {
            System.out.println("The " + monster + "has been defeated at your hands...");
        }
    }
    public void encounterMenu() {
        System.out.printf("%nYou have encountered a %s !%n", model.getDescription()  +
                "What is your next move?%n" +
                "To fight enter '1'%n" +
                "To flee enter '2' %n" +
                "To use one of your item enter '3'%n");
    }
    public void flavorTextMonster(){
        System.out.println("flavor text monster present");
    }
    public void monsterHitFlavorText(Hero theHero) {
        System.out.println("monster hit flavor text");
    }
    public void monsterMissFlavorText(Hero theHero) {
        System.out.println("Monster miss flavor text");
    }

}
