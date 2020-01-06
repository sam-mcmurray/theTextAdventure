package project1E7.View;

import project1E7.Model.*;

import java.util.InputMismatchException;

public class ItemView {
    Item model;
    private Coffee coffee;
    private HealthPotion healthPotion;
    private Heart heart;
    private Treasure treasure;

    public ItemView(Item model) {
        this.model = model;
    }

    /**
     * prints flavor text for a particular item
     * @param item
     * @return
     */
    public Item viewItem(Item item) {

       if (item == coffee) {
           System.out.println("a delicious mug of coffee. How is it still warm?");
           return coffee;
       } else if (item == healthPotion) {
           System.out.println("a glowing red potion with a label on the back saying not to drink if pregnant.");
           return healthPotion;
       } else if (item == heart) {
           System.out.println("a human heart within a crystal casing. It still beats.");
           return heart;
       } else if (item == treasure) {
           System.out.println("a chest full of treasure!");
           return treasure;
       }
       return null;
    }


    /**
     * prints the item decision menu
     * @param item
     */

    public void chooseWhatToDoWithItem(Item item) {
        try {
            System.out.println("Would you like to use " + item.getName() + " or save in your satchel?" +
                    "\n 1)Use " + item.getName() + "\n 2)Save " + item.getName() + " in satchel");
        }
        catch (InputMismatchException e) {

            System.out.printf("%n" +
                    "Invalid answer%n");
            return;
        }

    }
}
