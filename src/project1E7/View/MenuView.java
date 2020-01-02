package project1E7.View;

public class MenuView {

    /**
     * prints the encounter menu
     */
    public void encounterMenu() {
            System.out.println("What is your next move?");
            System.out.println("1)Fight ");
            System.out.println("2)Flee");
            System.out.println("3)Use Item");

    }

    /**
     * prints the hero choice menu
     */
    public void chooseHeroMenu() {
        System.out.println("Select the hero: ");
        System.out.println("1)Warrior");
        System.out.println("2)Mage ");
        System.out.println("3)Thief ");
        System.out.println("Please enter your choice");
    }

    /**
     * prints the start menu
     */
    public void startMenu() {
        System.out.println("1)Start New Game");
        System.out.println("2)Load Saved Game");
        System.out.println("3)View HighScore");
        System.out.println("4)Instructions");
        System.out.println("5)Quit Game");
    }

    /**
     * prints the sub menu
     */
    public void subMenu() {
        System.out.println("Choose one of the following options. To exit this menu enter 0");
        System.out.printf("1- View controls %n" +
                "2- Change controls %n" +
                "3- View instructions %n" +
                "4- View map %n" +
                "5- Save game %n" +
                "6- Load game %n" +
                "7- Quit game %n ");

    }
    public void instructionsStartMenu() {
        System.out.printf("\t Welcome to our labyrinth adventure game! The goal of the game is collect treasure and make it to the exit.%n" +
                "You will select either a Mage, Warrior or a Thief each having unique abilities. The Mage can transport to a random room in the game.%n " +
                "The Warrior can land all his hits for 5 turns. The Thief has a 50 percent chance of successfully lock picking a door you dont have a %n" +
                "a key for. These abilities are limited and you can't use them every turn. Some doors are locked and require a unique key other doors %n" +
                "are open every room has a chance to contain monsters, items, or keys. The monsters vary in difficulty but the boss is the most difficult %n" +
                "The menu controls are simple enter the number of your corresponding decision, these mechanics are not changeable but you can change %n" +
                "how you move the current controls are W for North or up on the map, S is for South or down on the map, A is for West or left on the map, %n" +
                "and D is for East or Right on the map. You start with 3 lives but it is possible to find items such as Hearts to increase those lives %n" +
                "and Health Potions to increase your health. The other item is coffee which increases your speed for 3 turns. ");
    }

}
