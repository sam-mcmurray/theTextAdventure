package project1E7.View;

import project1E7.GameManager;
import project1E7.Model.Hero;
import project1E7.Model.Monster;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MonsterView {
    Scanner input = new Scanner(System.in);
    Monster model;

    public MonsterView(Monster model) {
        this.model = model;
    }

    /**
     * prints the status of the monster
     * @param monster
     */
    public void printStatus(Monster monster) {
        System.out.println("Enemy Type: " + model.getDescription());
        if (model.isAlive()) {
            System.out.println(model.getName() + " Health: " + model.getHealth());
        } else {
            System.out.println("The " + model.getName() + " has been defeated at your hands...");
        }
    }

    /**
     *  prints encountering a monster
     * @param monster
     */
    public void encounter(Monster monster){
        System.out.printf("You have encountered %s ", monster.getDescription());
    }

    /**
     * prints the flavor text for the monster
     */
    public void flavorTextMonster(Hero hero) {
        Random random = new Random();

        int randomInt = random.nextInt(1);

        if (randomInt == 0) {
            if (model.getName().equalsIgnoreCase("The Boss")) {
                System.out.println("");
            } else if (model.getName().equalsIgnoreCase("Owlbear")) {
                System.out.println("Too late! The bones and feathers strewn across the room should have been your first \n" +
                        "warning. The second being a shrieking growl barreling towards you from a large cavern in the \n" +
                        "wall. Stopping just before you as a hulking beast has the head of an owl and the body of a \n" +
                        "brown bear. The owlbears beak and claws both look razor sharp and ready to fight.");
            } else if (model.getName().equalsIgnoreCase("Skeleton")) {
                System.out.println("Too late! As you are traversing the debris on the floor of the room you step over a \n" +
                        "pile of rubble from some collapsed pillar you mistakenly trample the remains of a poor \n" +
                        "dungeuoneer not all that different from yourself minus the not being alive and all. \n" +
                        "Unfortunately, the dead don't welcome disturbance and the bones begin to rattle to life all \n" +
                        "over again not long after you stepped on them. Pulling out your " + hero.getWeapon() + " you \n" +
                        "prepare to put the skeleton back where you found them.");
            } else if (model.getName().equalsIgnoreCase("Bat")) {
                System.out.println("Too late! While peering into one of the next rooms some leather winged creature \n" +
                        "flies directly at you. you take out your " + hero.getWeapon() + " without any time to spare \n" +
                        "perry its razor sharp claws. What the oversized bat thought was an easy meal is going to put \n" +
                        "up a fight.");
            } else if (model.getName().equalsIgnoreCase("Slime")) {
                System.out.println("Too late! The room itself appears far more wet than what you first realized. In \n" +
                        "fact, the whole room is dripping a strange blue goo and the blue liquid moves in an unusual \n" +
                        "way. To your horror, the liquid began to move together and form a single large blob.  Whatever \n" +
                        "this thing is it is lurching towards you quite menacingly. You ready your " + hero.getWeapon() + " \n" +
                        "for a fight.");
            } else {
                System.out.println("Too late! The skittering of the eight hairy black legs warns you before you ever see \n" +
                        "it. You barely dodge the meter long spiderling as it pounces forward to sink its fangs deep in \n" +
                        "the soft tissue of your neck. Pulling back from the monstrosity you ready to fight.");
            }
        } else {
            if (model.getName().equalsIgnoreCase("The Boss")) {
                System.out.println("");
            } else if (model.getName().equalsIgnoreCase("Owlbear")) {
                System.out.println("Clearly there was some kind of battle in this room, recently too. Inside there are \n" +
                        "many dead creatures ranging from bats, spiderlings, and even a couple of slimes. In the center \n" +
                        "lays the gruesome remains of a bear whose head had been twisted around backwards. What could \n" +
                        "have the strength to do that? As you are inspecting the carnage you hear a rumbling 'WHOoOo \n" +
                        "WHoOoO'. You turn around just in time to realize that was no ordinary bear, and it was certainly \n" +
                        "not dead. The head of it spins around 180 degrees and faces you. It's an owlbear who was \n" +
                        "slumbering after eating it's fill. Now his goal is to defend his prizes from you. Prepare to fight");
            } else if (model.getName().equalsIgnoreCase("Skeleton")) {
                System.out.println("Several large black sarcophagi are embedded into the walls of the room around you. \n" +
                        "One in particular catches your eye as its been decorated with large precious stones on the \n" +
                        "outside of it. You realize that whoever is inside won't be missing them and decide to try and \n" +
                        "pry them off the tomb. Perhaps it wasn't your brightest idea since as soon as you go to touch \n" +
                        "one of the gems the stone slab breaks off the wall and a mummified corpse draws it's sword. \n" +
                        "It's time to fight.");
            } else if (model.getName().equalsIgnoreCase("Bat")) {
                System.out.println("As you are admiring the ancient architecture of the room you come to the slow yet \n" +
                        "horrifying realization that what you thought was decorative ceiling art are actually hundreds \n" +
                        "of sleeping bats, every one of them easily the size of yourself. Slowly backing up while \n" +
                        "keeping your eyes on the monsters above you accidentally back into a bucket sitting on the \n" +
                        "ledge of a well. As it falls it pulls the chain it was attached to and begins hitting the sides \n" +
                        "of the well all the way down. These sounds are only amplified by the echo from the well. The \n" +
                        "creatures above shuffle and move and as they wake up they begin swarming around the room. \n" +
                        "Thankfully all except one pay no attention to you and decide to evacuate the room, likely to \n" +
                        "their sensitive hearing being disrupted by the loudness coming from the well. Regardless the \n" +
                        "last one left with you looks pissed of and hungry. Prepare to fight!");
            } else if (model.getName().equalsIgnoreCase("Slime")) {
                System.out.println("Finally some respite after the long and difficult process of dungeon crawling! You \n" +
                        "have come across a large pool of what appears to be mana restoration portion.  It's very well \n" +
                        "coveted for its rejuvenation properties. Soon you have decided to take a dip in this natural \n" +
                        "pool of liquid blue gold but decide to test the waters first with the you large toe. Dipping \n" +
                        "it in, it feels quite pleasant at first until the painful sizzling of a chemical burn turns \n" +
                        "your toe bright red. The blue goop springs to life and attempts consume the rest of you as you \n" +
                        "spring back and ready your weapon. What you now realize was a slime prepares to fight for its meal!");
            } else {
                System.out.println("Too late! You just barely notice the dark shape on the ceiling hurrying towards \n" +
                        "yourself and ready your weapon. Perhaps you should have been more weary of walking into a room \n" +
                        "with a web infested ceiling. The spiderling slowly drops down while hanging off a silken \n" +
                        "strand and prepares for a fight.");
            }
        }
    }

    /**
     * prints monster hit landing flavor text
     * @param monster
     */
    public void monsterHitFlavorText(Monster monster) {

        Random rand = new Random();
        int rGen = rand.nextInt(5);
        String rBodyPart = "ERROR";

        switch (rGen) {
            case 0:
                rBodyPart = "head";
                break;
            case 1:
                rBodyPart = "back";
                break;
            case 2:
                rBodyPart = "arm";
                break;
            case 3:
                rBodyPart = "leg";
                break;
            case 4:
                rBodyPart = "chest";
                break;
        }
        if (model.getName().equalsIgnoreCase("The Boss")) {
            System.out.println("The fallen dungeoneer uses a spell and hits your " + rBodyPart + "!");
        } else if (model.getName().equalsIgnoreCase("Owlbear")) {
            System.out.println("The owlbear uses its sharp beak to bite your " + rBodyPart + "!");
        } else if (model.getName().equalsIgnoreCase("Skeleton")) {
            System.out.println("The skeletons rusty sword strikes your " + rBodyPart + "!");
        } else if (model.getName().equalsIgnoreCase("Bat")) {
            System.out.println("The bats claws draws marks across your " + rBodyPart + "!");
        } else if (model.getName().equalsIgnoreCase("Slime")) {
            System.out.println("The slime lurches forward and burns your " + rBodyPart + "!");
        } else {
            System.out.println("The spiderlings fangs stab into your " + rBodyPart + "!");
        }
    }

    /**
     * prints monster miss flavor text
     * @param monster
     */
    public void monsterMissFlavorText(Monster monster) {

        Random rand = new Random();
        int rGen = rand.nextInt(5);
        String rBodyPart = "ERROR";

        switch (rGen) {
            case 0:
                rBodyPart = "head";
                break;
            case 1:
                rBodyPart = "back";
                break;
            case 2:
                rBodyPart = "arm";
                break;
            case 3:
                rBodyPart = "leg";
                break;
            case 4:
                rBodyPart = "chest";
                break;
        }
        if (model.getName().equalsIgnoreCase("The Boss")) {
            System.out.println("The fallen dungeoneer tries to use a spell to hit your " + rBodyPart + " but misses!");
        } else if (model.getName().equalsIgnoreCase("Owlbear")) {
            System.out.println("The owlbear tries to use its sharp beak to bite your " + rBodyPart + " but misses!");
        } else if (model.getName().equalsIgnoreCase("Skeleton")) {
            System.out.println("The skeletons tries to use its rusty sword to strike your " + rBodyPart + " but misses!");
        } else if (model.getName().equalsIgnoreCase("Bat")) {
            System.out.println("The bat tries to use its claws to scratch your " + rBodyPart + " but misses!");
        } else if (model.getName().equalsIgnoreCase("Slime")) {
            System.out.println("The slime tries to lurch forward to burn your " + rBodyPart + " but misses!");
        } else {
            System.out.println("The spiderlings tries to use its fangs to stab into your !" + rBodyPart + " but misses!");
        }
    }

}
