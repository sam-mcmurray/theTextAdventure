package project1E7.View;

import project1E7.Model.*;

import java.util.InputMismatchException;

public class ItemView {
    Item model;
    private Coffee coffee;
    private HealthPotion healthPotion;
    private Heart heart;
    private Treasure treasure;
    private Weapon weapon;

    public ItemView(Item model) {
        this.model = model;
    }

    /**
     * prints flavor text for a particular item
     * @param item
     * @return
     */
    public Item viewItem(Item item) {

       if (item instanceof Coffee) {
           System.out.println("Incredible! A delicious mug of coffee was just sitting on the ground. How is it still warm?");
           return coffee;
       } else if (item instanceof HealthPotion) {
           System.out.println("Salvation! A glowing red potion health potion was just waiting for you within the room! \n" +
                   "The label on the back says not to drink if you're pregnant.");
           return healthPotion;
       } else if (item instanceof Heart) {
           System.out.println("Morbid but not unwelcome, a human heart within a crystal casing is set upon a table in \n" +
                   "the room. It still beats.");
           return heart;
       } else if (item instanceof Weapon) {
           System.out.println("Sitting on a pedestal in the center of the room is an upgraded version of your signature \n" +
                   "weapon. How convenient!");
       } else if (item instanceof Treasure) {
           System.out.println("Loot! There is treasure in the room!");
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
                    "\n1)Use " + item.getName() + "\n2)Save " + item.getName() + " in satchel \n" +
                    "3)SubMenu");
        }
        catch (InputMismatchException e) {

            System.out.printf("%n" +
                    "Invalid answer%n");
        }

    }
}
