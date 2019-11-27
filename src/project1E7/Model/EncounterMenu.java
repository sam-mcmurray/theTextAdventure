package project1E7.Model;

import java.security.*;
import java.util.*;

/*public class EncounterMenu {


    private void encounterMenu() {

        Scanner keyBoard = new Scanner(System.in);
        SecureRandom randomiser = new SecureRandom();
        Character a = new Hero(10, 6, 7, "Hero", "Boi", 6);

        System.out.printf("%nYou have encountered a monster!%n" +
                "What is your next move?%n" +
                "To run away enter 'flee'%n" +
                "To fight enter 'fight' %n" +
                "To use one of your item enter 'item'%n");


        //char temp=keyBoard.next().charAt(0);
        String temp = keyBoard.nextLine();

        switch (temp) {

            case "flee":

                int tmp = randomiser.nextInt(10);
                if (tmp <= a.getSpeed()) {

                    System.out.printf("%nYou have escaped the attack!");
                }
                break;

            case "fight":

                tmp = randomiser.nextInt(10);
                if (tmp <= 5) {

                    System.out.printf("You have damaged the monster by %d", a.getStrength());
                }
                break;

            case "item":

                System.out.printf("%nWhich item do you want to use?");
                for (int b = 1; b <= ((Hero) a).getBackPack().size(); b++) {

                    System.out.printf("%n%d%s", b, ((Hero) a).getBackPack().get(b).getName());
                }

                int choice = keyBoard.nextInt();

                if (((Hero) a).getBackPack().get(choice) instanceof Coffee) {

                    ((Hero) a).drinkCoffee();
                } else if (((Hero) a).getBackPack().get(choice) instanceof Heart) {

                    ((Hero) a).useHeart();
                } else if (((Hero) a).getBackPack().get(choice) instanceof HealthPotion) {

                    ((Hero) a).useHealthPotion();
                }

                break;

        }


    }
}
*/
