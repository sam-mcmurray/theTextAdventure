package project1E7.View;

import project1E7.Model.*;

public class ItemView {
    Item model;
    private Coffee coffee;
    private HealthPotion healthPotion;
    private Heart heart;
    private Treasure treasure;

    public ItemView(Item model) {
        this.model = model;
    }

    public Item viewItem(Item item) {
       if (item == coffee) {
           System.out.println("flavor text for coffee");
           return coffee;
       } else if (item == healthPotion) {
           System.out.println("flavor text health potion");
           return healthPotion;
       } else if (item == heart) {
           System.out.println("flavor text for heart");
           return heart;
       } else if (item == treasure) {
           System.out.println("flavor text for treasure");
           return treasure;
       }
       return null;
    }
    public void chooseWhatToDoWithItem(Item item){
        System.out.println("Would you like to use " + item.getName() + " or save in your satchel?" +
                "\n 1)Use " + item.getName() + "\n 2)Save " + item.getName() + " in satchel");
    }
}
