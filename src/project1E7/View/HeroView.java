package project1E7.View;


import project1E7.Model.Hero;
import project1E7.Model.Item;
import project1E7.Model.Monster;

import project1E7.Model.Room;
import project1E7.theTextAdventure;
import project1E7.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;


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
        System.out.println(model.getDescription());

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
    public void printStatus(Hero hero, Room currentRoom) {
        if (model.isAlive()) {
            System.out.println("\033[32m"+model.getName() + "Health: " + model.getHealth());
            System.out.println(model.getName() + "Endurance: " + model.getEndurance());
            System.out.println(model.getName() + "Speed : " + model.getSpeed()+"\u001B[0m");
        } else {

            String monsterName = currentRoom.getMonster().getName();

            switch (monsterName) {

                case ("Spiderling"):{

                    System.out.printf(
                            "Your body is pierced all over by the Spiderling. You drop your %s and feel the life drifting our of your body. %n" +
                            "The Spiderling begins to ingest you into its mouth as you begin to wonder just how awful your player must be to die to a thing that shoots rope out of its ass ", hero.getWeapon());
                }

                case ("Bat"):{

                    System.out.printf(
                            "The screeching winged monstrosity sinks its fangs into you violently. You are losing a lot of blood.%n" +
                            "You try feebly to use your %s. You think how could this happen? How terrible must my player be to die to a glorified rat.%n", hero.getWeapon());
                    break;
                }

                case("Skeleton"):{

                    System.out.printf(
                            "The mummified Skeleton penetrates your intestines with its blunt jagged sword. He leans in and whispers %n" +
                            "'Just let it happen'. Its rotten stench is the last thing you sense before you drop your %s", hero.getWeapon());
                    break;
                }

                case("Owlbear"):{

                    System.out.printf(
                            "The Owlbear sinks its massive claws into your body. You helplessly attempt to use your %s but " +
                            "You begin to realize that there is no way out this time. The Owlbear roars furiously as he flings you against the wall ripping your arm off.%n" +
                            "During your last moments alive, you can't help but think to yourself, this guy really needs a snickers.", hero.getWeapon());
                    break;
                }

                case("Slime"):{

                    System.out.printf(
                            "The disgusting glob of acidic matter leaps onto you, completely swallowing you. It burns!.%n" +
                            "You briefly attempt to use your %s, but you cannot feel your arm anymore. The pain is unimaginable.%n" +
                            "During your last moments, you can only think of how much you could really use a Sprite cranberry.", hero.getWeapon());
                    break;
                }

                case("The Boss"): {

                    System.out.printf(
                            "The mysterious being begins casting a spell. Lightning strikes you seemingly from nowhere.%n" +
                            "You try to raise your weapon, but you can't!. Your whole body has been paralyzed!%n" +
                            "You fall on the cold cave floor and take comfort in the fact that you made it this far. ");
                    break;
                }
            }
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
                "some treasure. Looking at the scattering of your adventuring items beside you, you start to gather your things; a backpack capable of holding an assortment \n" +
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
            System.out.println("Swinging your longsword in a long sweeping hit starting from top right of your \n" +
                    "head and ending downwards to the bottom left, your blade makes contact with " + monster.getName() + ". \n" +
                    "" +monster.getName() + " shrieks in pain and anger.");
        } else if (model.getName().equalsIgnoreCase("mage")) {
            System.out.println("Using your staff and an intense focus, you conjure an ever growing fireball at the \n" +
                    "crystal focal of your staff until you finally launch it. " + monster.getName() + " burns \n" +
                    "horribly dealing substantial damage");
        } else {
            System.out.println("Your dagger is a whirlwind of flashing steel as you stab at " + monster.getName() + " with \n" +
                    "lightning speed and an unnatural precision." + monster.getName() + " recoils in confusion and pain.");
        }
        ;
    }
    public void viewSuperAbility(Hero hero, Room currentRoom) {
        System.out.println(hero.getName() + " super ability has been used ");
        switch (hero.getCharacterClass()) {
            case "Warrior":
                System.out.println(currentRoom.getMonster().getName() + " was hit with your great cleave and took extreme damage");
                break;
            case "Thief":
                System.out.println(currentRoom.getMonster().getName() + " has been paralyzed by your poison and can't move. Their attacks are much weaker!");
                break;
            case "Mage":
                System.out.println(currentRoom.getMonster().getName() + " was completely incinerated with a powerful magic blast!");
                break;
        }
    }

    public void viewAbility(Hero hero, Room currentRoom) {
        System.out.println(hero.getName() + " ability has been used");
        switch (hero.getCharacterClass()) {
            case "Warrior":
                System.out.println("You bellow out your war call which bolsters your speed temporarily and  your health permanently health");
                System.out.println("Current Speed: " + hero.getSpeed());
                System.out.println("Current Health: " + hero.getHealth());
                break;
            case "Thief":
                System.out.println("Using your trixy poisons you added to your dagger you now do 30 damage extra damage this room!");
                break;
            case "Mage":
                System.out.println("The " + currentRoom.getMonster().getName() + " has been partially possessed and now does 10 less damage to you!");
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
     * death menu
     * @return
     * @throws InterruptedException
     */

    public void defeat() throws InterruptedException {
        String defeatTxt = "YOU DIED";
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < defeatTxt.length(); i++) {
            System.out.print(defeatTxt.charAt(i));
            Thread.sleep(500);
        }
        System.out.println();
        System.out.println("                           ,--.\n" +
                "                          {    }\n" +
                "                          K,   }\n" +
                "                         /  `Y`\n" +
                "                    _   /   /\n" +
                "                   {_'-K.__/\n" +
                "                     `/-.__L._\n" +
                "                     /  ' /`\\_}\n" +
                "                    /  ' /     \n" +
                "            ____   /  ' /\n" +
                "     ,-'~~~~    ~~/  ' /_\n" +
                "   ,'             ``~~~%%',\n" +
                "  (                     %  Y\n" +
                " {                      %% I\n" +
                "{      -                 %  `.\n" +
                "|       ',                %  )\n" +
                "|        |   ,..__      __. Y\n" +
                "|    .,_./  Y ' / ^Y   J   )|\n" +
                "\\           |' /   |   |   ||\n" +
                " \\          L_/    . _ (_,.'(\n" +
                "  \\,   ,      ^^\"\"' / |      )\n" +
                "    \\_  \\          /,L]     /\n" +
                "      '-_`-,       ` `   ./`\n" +
                "         `-(_            )\n" +
                "             ^^\\..___,.--`\n");
        System.out.println();
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
                    "/______/______/______/______/______/______/______/______/______/______/______/_\n" +
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
                    "*                                                    \\            |            \\ *\n" +
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
                    "You have selected the Warrior. The warrior is an aggressive tank. The deal medium damage and have high health. They also have a low %n" +
                    "speed stat. The Warrior's normal ability is a war cry which doubles speed temporarily and restores 20 health. Their super ability instantly %n" +
                    "does double your strength as damage to the enemy. Only the super can be used on the Boss. Most doors are unlocked and contain random items, %n" +
                    "monsters and loot. The menu controls are simple enter the number of your corresponding decision, these mechanics are not changeable but you can %n" +
                    "change how you move the current controls are W for North or up on the map, S is for South or down on the map, A is for West or left on the map, %n" +
                    "and D is for East or Right on the map. Press enter after each input!. You start with 1 life but it is possible to find items to increase %n" +
                    "your total, and Health Potions to restore your health. Other powerful items can also be found which give lasting effects!%n ");
        } else if (model.getName().equalsIgnoreCase("Mage")) {
            System.out.printf("\t Welcome to our labyrinth adventure game! The goal of the game is collect treasure and make it to the exit.%n" +
                    "You have selected the Mage. The Mage is a bit of a glass cannon. They cause high damage but have low health. They also have a medium %n" +
                    "speed stat. The Mage's normal ability is to posses an enemy causing them to deal not attack you. Their super ability is to instantly incinerate %n" +
                    "a single enemy. Both of these abilities can't be used on the Boss. Most doors are unlocked and contain random items, monsters and loot. %n" +
                    "The menu controls are simple enter the number of your corresponding decision, these mechanics are not changeable but you can change %n" +
                    "how you move the current controls are W for North or up on the map, S is for South or down on the map, A is for West or left on the map, %n" +
                    "and D is for East or Right on the map. Press enter after each input!. You start with 1 life but it is possible to find items to increase %n" +
                    "your total, and Health Potions to restore your health. Other powerful items can also be found which give lasting effects!%n ");
        } else {
            System.out.printf("\t Welcome to our labyrinth adventure game! The goal of the game is collect treasure and make it to the exit.%n" +
                    "You have selected the Thief. The thief is reliant on his speed. They deal low damage and have medium health. They also have a very high %n" +
                    "speed stat. The Thief's normal ability adds 30 damage to all their attacks to their current room. Their super ability poisons the enemy %n" +
                    "causing them to deal 20 less damage and their speed stat 0. Both of these abilities cant be used on the Boss. Most doors are unlocked and %n" +
                    "contain random items, monsters and loot. The menu controls are simple enter the number of your corresponding decision, these mechanics are " +
                    "not changeable but you can change how you move the current controls are W for North or up on the map, S is for South or down on the map, %n" +
                    "A is for West or left on the map, and D is for East or Right on the map. Press enter after each input!. You start with 1 life but it is possible %n" +
                    "to find items to increase your total, and Health Potions to restore your health. Other powerful items can also be found which give lasting effects!%n ");

        }
    }
}