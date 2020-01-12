package project1E7.View;

import project1E7.Model.Hero;
import project1E7.Model.Menu;
import project1E7.Model.Room;

public class MenuView {
    Menu model;

    public MenuView(Menu model) {
        this.model = model;
    }

    /**
     * prints the encounter menu
     */
    public void encounterMenu() {
        System.out.println("What is your next move?");
        System.out.println("1)Fight ");
        System.out.println("2)Flee");
        System.out.println("3)Use ability ");
        System.out.println("4)Use super ability ");
        System.out.println("5)Use Item");
        System.out.println("6)Sub Menu");
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
                "7- View HighScore%n" +
                "8- Quit game %n ");

    }

    public void instructionsStartMenu() {
        System.out.printf("\t Welcome to our labyrinth adventure game! The goal of the game is collect treasure and make it to the exit.%n" +
                "You can select either a Mage, Warrior or a Thief, each of them having unique stats, abilities, and super abilities which are extremely %n" +
                "powerful and can only be used when below 30 health and only once. Most doors are unlocked and contain random items, monsters and loot. %n" +
                "The menu controls are simple enter the number of your corresponding decision, these mechanics are not changeable but you can change %n" +
                "how you move the current controls are W for North or up on the map, S is for South or down on the map, A is for West or left on the map, %n" +
                "and D is for East or Right on the map. Press enter after each input!. You start with 1 life but it is possible to find items to increase %n" +
                "your total, and Health Potions to restore your health. Other powerful items can also be found which give lasting effects!%n");
    }

}
