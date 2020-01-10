package project1E7.View;


import project1E7.Model.Hero;
import project1E7.Model.Item;
import project1E7.Model.Monster;

import project1E7.Model.Room;
import project1E7.theTextAdventure;
import project1E7.*;

import java.util.ArrayList;
import java.util.Scanner;


public class HeroView {

    Hero model;
    Scanner input = new Scanner(System.in);

    public HeroView(Hero model) {
        this.model = model;
    }

    /**
     * prints bar chart for the hero stats
     */
    public void printStats() {
        int[] stats = new int[4];
        stats[0] = model.getHealth() / 10;
        stats[1] = model.getSpeed() / 10;
        stats[2] = model.getStrength() / 10;
        stats[3] = model.getEndurance() / 10;

        String[] tableDescrip = new String[4];
        tableDescrip[0] = "Health:    ";
        tableDescrip[1] = "Speed:     ";
        tableDescrip[2] = "Strength:  ";
        tableDescrip[3] = "Endurance: ";

        System.out.println("Name: " + model.getName());
        System.out.println("Character Description: " + model.getDescription());

        for (int i = 0; i < stats.length; i++) {
            System.out.print(tableDescrip[i]);
            for (int j = 0; j < stats[i]; j++) {
                System.out.print("*");
            }
            System.out.printf("%n");

        }
    }

    /**
     * prints the select hero confirmation statement
     *
     * @param hero
     * @return
     */
    public boolean selectHero(Hero hero) {
        System.out.println("Do you want to select the" + hero + " to be your hero? " + "Yes/No");
        String choice = input.next();
        boolean valid = true;

        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.println(hero + " has been selected");
            return false;
        } else
            return true;
    }

    /**
     * prints the heroes status
     *
     * @param hero
     */
    public void printStatus(Hero hero) {
        if (model.isAlive()) {
            System.out.println(model.getName() + " Health: " + model.getHealth());
            System.out.println(model.getName() + " Endurance: " + model.getEndurance());
            System.out.println(model.getName() + " Speed : " + model.getSpeed());
            System.out.println("Speed : "+model.getSpeed());
        } else {
            System.out.println("You have been defeated...");
        }
    }

    /**
     * suppose to show heroes inventory i dont think it works its untested
     *
     * @param items
     */
    public void inventory(ArrayList<Item> items) {
        items = model.getBackPack();
        int choice;
        for (int i = 0; i <= items.size() - 1; i++) {
            System.out.println("[" + (i + 1) + "]" + items.get(i).getName());
        }
    }

    /**
     * prints the heroes story
     */
    public void heroStory() {
        String characterClass = model.getCharacterClass();
        System.out.println("Your head aches as you awake from your fall.  You look up to see where you fell from and try to remember exactly what happened. rappelling down the ruins\n" +
                "was going well until you felt your rope go slack. Exploring decrepit ruins of ancient civilizations is dangerous work but it certainly pays well if you can find\n" +
                "some treasure. Looking at the scattering of your adventuring items beside you, you start start to gather your things; a backpack capable of holding an assortment \n" +
                "items, a keychain for keeping any keys you find handy, and of course the most important tool in your arsenal: your " + getWeapon() + ". As start to gather what is\n" +
                "left of your rope, you look at the end of it and realize it didn't snap, rather, it was a clean cut. You are not alone! Something wants to keep you here and you won't be\n" +
                "able to climb back the way you came. ahead of you are three doors. One to your North, East, and West. It looks like you'll have to find another way out. It sounds as if\n" +
                "there is movement in the other rooms but it's impossible to tell which. It's time to make a choice. Which direction should you go?");
    }

    /**
     * returns the current heroes weapon
     *
     * @return
     */
    public String getWeapon() {
        String weapon = "";
        if (model.getCharacterClass().equals("Warrior")) {
            weapon = "Long Sword";
        } else if (model.getCharacterClass().equals("Mage")) {
            weapon = "Magic Scepter";
        } else if (model.getCharacterClass().equals("Thief")) {
            weapon = "Curved Dagger";
        } else {
            weapon = "ERROR: No weapon found";
        }
        return weapon;
    }

    /**
     * prints hit landed flavor text for hero
     *
     * @param monster
     */
    public void hitMonsterFlavorText(Monster monster) {
        if (model.getName().equalsIgnoreCase("warrior")) {
            System.out.println("Swinging your longsword in a long sweeping hit starting from top right of your head and ending downwards to the bottom left, your blade makes contact with " + monster.getName() + ".\n" +
                    monster.getName() + " shrieks in pain and anger.");
        } else if (model.getName().equalsIgnoreCase("mage")) {
            System.out.println("Using your staff and an intense focus, you conjure an ever growing fireball at the crystal focal of your staff until you finally launch it.\n" +
                    monster.getName() + " burns horribly dealing substantial damage");
        } else {
            System.out.println("Your dagger is a whirlwind of flashing steel as you stab at " + monster.getName() + " with lightning speed and an unnatural precision.\n" +
                    monster.getName() + " recoils in confusion and pain.");
        }
        ;
    }
    public void viewSuperAbility(Hero hero, Room currentRoom) {
        System.out.println(hero.getName() + " Super ability has been used ");
        switch (hero.getCharacterClass()) {
            case "Warrior":
                System.out.println(currentRoom.getMonster().getName() + "Is poisoned and has no power and no speed");
                break;
            case "Thief":
                System.out.println(currentRoom.getMonster().getName() + " is frosted now by your super power ability he has no speed and has no chance to hit you ! take him down ");
                break;
            case "Mage":
                System.out.println("You burned the " + currentRoom.getMonster().getName() + " by your super power ability ");
                break;
        }
    }

    public void viewAbility(Hero hero, Room currentRoom) {
        System.out.println(hero.getName() + " ability has been used");
        switch (hero.getCharacterClass()) {
            case "Warrior":
                System.out.println("Your became too fast ! now your chance to hit the enemy is very high .. ");
                System.out.println("Your speed now : " + hero.getSpeed());
                System.out.println("Be careful Warrior you don't have the same ability outside this room ! ");
                break;
            case "Thief":
                System.out.println("You have just disappeared and escaped from the " + currentRoom.getMonster().getName() + " by your ability");
                break;
            case "Mage":
                System.out.println("The " + currentRoom.getMonster().getName() + " has been possessed now by your ability and has no power to damage you ! finish him ");
                break;
        }

    }
    public void printAbilityCounter() {
        System.out.println("you can not use your ability more than 3 times ");
        System.out.println("You have used your ability for : " + model.getAbilityCounter() + " time");
    }

    /**
     * prints missed flavor text for the hero
     *
     * @param monster
     */
    public void missMonsterFlavorText(Monster monster) {
        if (model.getName().equalsIgnoreCase("warrior")) {
            System.out.println("With extreme confidence you attempt to spin in a circle while holding your blade out creating a spinning circle of death as you've seen all your favorite heroes do.\n" +
                    monster.getName() + "appears confused but was never in any danger. Your arrogance ended in absolute failure and your attack misses!");
        } else if (model.getName().equalsIgnoreCase("mage")) {
            System.out.println("Despite years of training in the arcane arts, the fireball you attempt to conjure at the end of your staff only sparks pitifully before fizzling out. \n" +
                    monster.getName() + " appears almost embarrassed for you as you try and explain this doesn't normally happen and you just haven't been in a battle in a little while! \n"
                    + monster.getName() + " explains that he thinks they make pills for that now and to maybe check it out.  Your attack misses!");
        } else {
            System.out.println("With your enemy out of range of your dagger, you fall back and attempt to use your hidden ninja stars you recently acquired from an exotic weapons vendor. \n" +
                    "You launch three of them right at " + monster.getName() + "only to see them harmlessly bounce off of it as the ninja stars clatter on the stone ground.\n" +
                    "Damn, you the clerk who sold them to you swore they were real.  Your attack misses!");
        }

    }

    /**
     * the end
     */

    public void theEndGame(int hightscore, String bossName, int currentScore) {

        if (currentScore > hightscore) {
            System.out.println("Fighting " + bossName + " was a struggle, not because it was a particularly difficult fight, but in reality you have been weighed down \n" +
                    "from carrying all these treasures you've accrued. Before " + bossName + " was even slayed you caught glint of a golden key \n" +
                    "on their belt. After struggling towards them to loot you realize with the addition of the key you won't be able to move. \n" +
                    "Unable to bare losing even a single item, staying here to guard your treasure becomes your only option. Over time you forget \n" +
                    "there ever was a world outside the dungeon despite the outside being only a key turn away. There you sit and wait, until the \n" +
                    "next comes! " +
                    "\n" +
                    "*******************************************************************************\n" +
                    "          |                   |                  |                     |\n" +
                    " _________|________________.=\"\"_;=.______________|_____________________|_______\n" +
                    "|                   |  ,-\"_,=\"\"     `\"=.|                  |\n" +
                    "|___________________|__\"=._o`\"-._        `\"=.______________|___________________\n" +
                    "          |                `\"=._o`\"=._      _`\"=._                     |\n" +
                    " _________|_____________________:=._o \"=._.\"_.-=\"'\"=.__________________|_______\n" +
                    "|                   |    __.--\" , ; `\"=._o.\" ,-\"\"\"-._ \".   |\n" +
                    "|___________________|_._\"  ,. .` ` `` ,  `\"-._\"-._   \". '__|___________________\n" +
                    "          |           |o`\"=._` , \"` `; .\". ,  \"-._\"-._; ;              |\n" +
                    " _________|___________| ;`-.o`\"=._; .\" ` '`.\"\\` . \"-._ /_______________|_______\n" +
                    "|                   | |o;    `\"-.o`\"=._``  '` \" ,__.--o;   |\n" +
                    "|___________________|_| ;     (#) `-.o `\"=.`_.--\"_o.-; ;___|___________________\n" +
                    "____/______/______/___|o;._    \"      `\".o|o_.--\"    ;o;____/______/______/____\n" +
                    "/______/______/______/_\"=._o--._        ; | ;        ; ;/______/______/______/_\n" +
                    "____/______/______/______/__\"=._o--._   ;o|o;     _._;o;____/______/______/____\n" +
                    "/______/______/______/______/____\"=._o._; | ;_.--\"o.--\"_/______/______/______/_\n" +
                    "____/______/______/______/______/_____\"=.o|o_.--\"\"___/______/______/______/____\n" +
                    "/______/______/______/______/______/______/______/______/______/______/[TomekK]\n" +
                    "*******************************************************************************");
        } else {
            System.out.println("With " + bossName + " slain, you caste away all your wealth realize that the real treasure from this journey isn't the gems and precious \n" +
                    "metals you found, but the friends you made along the way! Well it would have been if you made any. Look the moral of the \n" +
                    "story is money corrupts... or something. Take whatever moral stance you want on it since I doubt this is even being read \n" +
                    "at this point. You unlock the golden gate and spend the rest of your days free of both the dungeon and wealth.\n" +
                    " ********************************************************************************\n" +
                    "*                    /   \\              /'\\       _       \\    |    /            *\n" +
                    "*\\_..           /'.,/     \\_         .,'   \\     / \\_      \\       /             *\n" +
                    "*    \\         /            \\      _/       \\_  /    \\     _ ,d8b,               *\n" +
                    "*     \\__,.   /              \\    /           \\/.,   _|  _/ \\88888 ---           *\n" +
                    "*          \\_/                \\  /',.,''\\      \\_ \\_/  \\/    \\98P'               *\n" +
                    "*                           _  \\/   /    ',../',.\\    _/      \\    \\             *\n" +
                    "*             /           _/m\\  \\  /    |         \\  /.,/'\\   _\\    \\            *\n" +
                    "*           _/           /MMmm\\  \\_     |          \\/      \\_/  \\                *\n" +
                    "*          /      \\     |MMMMmm|   \\__   \\          \\_       \\   \\_              *\n" +
                    "*                  \\   /MMMMMMm|      \\   \\           \\       \\    \\             *\n" +
                    "*                   \\  |MMMMMMmm\\      \\___            \\_      \\_   \\            *\n" +
                    "*                    \\|MMMMMMMMmm|____.'  /\\_            \\       \\   \\_          *\n" +
                    "*                    /'.,___________...,,'   \\            \\   \\        \\         *\n" +
                    "*                   /       \\          |      \\    |__     \\   \\_       \\        *\n" +
                    "*                 _/        |           \\      \\_     \\     \\    \\       \\_      *\n" +
                    "*                /                               \\     \\     \\_   \\        \\     *\n" +
                    "*                                                 \\     \\      \\   \\__      \\    *\n" +
                    "*                                                  \\     \\_     \\     \\      \\   *\n" +
                    "*                                                   |      \\     \\     \\      \\  *\n" +
                    "*                                                    \\ms          |            \\ *\n" +
                    " ********************************************************************************");
        }
    }

    /**
     * prints the number of hero turns for the game
     */
    public void printTurnCount() {
        System.out.println("Current number of turns: " + model.getTurnCounter());
    }

    public void printLives() {
        System.out.println("Current number of lives: " + model.getLives());
    }

    public void fleeFail() {
        System.out.println("You were unable to flee.");
    }

    public void fleeSuccess() {
        System.out.println("You were successful in your attempt to flee.");
    }

    public void gameInstructions() {
        if (model.getName().equalsIgnoreCase("Warrior")) {
            System.out.printf("\t Welcome to our labyrinth adventure game! The goal of the game is collect treasure and make it to the exit.%n" +
                    "You will have selected Warrior the Thief has a unique ability to land 100 percent of blows within a single room. This %n " +
                    "unique ability can only be activated 2 times in a single game so you will need resist the urge to use it unless you need to. %n" +
                    "the map contains many doors and some of them have a possibility to be locked but you need to find the unique key for that door each room %n" +
                    "is generated randomly but has a chance to contain monsters, items, or keys. The monsters vary in difficulty but the boss is the most difficult %n" +
                    "The menu controls are simple enter the number of your corresponding decision, these mechanics are not changeable but you can change %n" +
                    "how you move the current controls are W for North or up on the map, S is for South or down on the map, A is for West or left on the map, %n" +
                    "and D is for East or Right on the map. You start with 5 lives but it is possible to find items such as Hearts to increase those lives %n" +
                    "and Health Potions to increase your health. The other item is coffee which increases your the Warriors speed. %n ");
        } else if (model.getName().equalsIgnoreCase("Mage")) {
            System.out.printf("\t Welcome to our labyrinth adventure game! The goal of the game is collect treasure and make it to the exit.%n" +
                    "You will have selected Mage the Mage has a unique ability to randomly transport into a non locked room within the map. This %n " +
                    "unique ability can only be activated 2 times in a single game so you will need resist the urge to use it unless you need to. %n" +
                    "the map contains many doors and some of them have a possibility to be locked but you need to find the unique key for that door each room %n" +
                    "is generated randomly but has a chance to contain monsters, items, or keys. The monsters vary in difficulty but the boss is the most difficult %n" +
                    "The menu controls are simple enter the number of your corresponding decision, these mechanics are not changeable but you can change %n" +
                    "how you move the current controls are W for North or up on the map, S is for South or down on the map, A is for West or left on the map, %n" +
                    "and D is for East or Right on the map. You start with 5 lives but it is possible to find items such as Hearts to increase those lives %n" +
                    "and Health Potions to increase your health. The other item is coffee which increases your the Mages speed. %n ");
        } else {
            System.out.printf("\t Welcome to our labyrinth adventure game! The goal of the game is collect treasure and make it to the exit.%n" +
                    "You will have selected Thief the Thief has a unique ability to be invisible for the duration of a single room and deactivates once left. This %n " +
                    "unique ability can only be activated 2 times in a single game so you will need resist the urge to use it unless you need to. %n" +
                    "the map contains many doors and some of them have a possibility to be locked but you need to find the unique key for that door each room %n" +
                    "is generated randomly but has a chance to contain monsters, items, or keys. The monsters vary in difficulty but the boss is the most difficult %n" +
                    "The menu controls are simple enter the number of your corresponding decision, these mechanics are not changeable but you can change %n" +
                    "how you move the current controls are W for North or up on the map, S is for South or down on the map, A is for West or left on the map, %n" +
                    "and D is for East or Right on the map. You start with 5 lives but it is possible to find items such as Hearts to increase those lives %n" +
                    "and Health Potions to increase your health. The other item is coffee which increases your the Thiefs speed. %n ");

        }
    }
}