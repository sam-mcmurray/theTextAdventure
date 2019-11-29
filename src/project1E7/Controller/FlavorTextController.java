package project1E7.Controller;

import src.project1E7.Model.FlavorText;

public class FlavorTextController {

    private String introFlavorText;

    private String helpText;

    private String weaponWarrior;
    private String weaponThief;

    private String roomFlavorText1;
    private String roomFlavorText2;
    private String roomFlavorText3;
    private String roomFlavorText4;
    private String roomFlavorText5;

    private String encounterFlavorTextSpiderling1;
    private String encounterFlavorTextSpiderling2;
    private String encounterFlavorTextBat1;
    private String encounterFlavorTextBat2;
    private String encounterFlavorTextSlime1;
    private String encounterFlavorTextSlime2;
    private String encounterFlavorTextSkeleton1;
    private String encounterFlavorTextSkeleton2;
    private String encounterFlavorTextOwlbear1;
    private String encounterFlavorTextOwlbear2;
    private String encounterFlavorTextBoss;

    private String attackFlavorText1;
    private String attackFlavorText2;
    private String missFlavorText1;
    private String missFlavorText2;

    private String bossWarning;
    private String bossFlavorText;

    private String keyWoodenFlavorText;
    private String doorWoodenFlavorText;
    private String keyStoneFlavorText;
    private String doorStoneFlavorText;
    private String keySilverFlavorText;
    private String doorSilverFlavorText;
    private String keyGoldFlavorText;
    private String doorGoldFlavorText;

    public String getIntroFlavorText() {
        introFlavorText = "Your head aches as you awake from your fall.  You look up to see where you fell from and try to remember exactly what happened. rappelling down the ruins " +
                "was going well until you felt your rope go slack. Exploring decrepit ruins of ancient civilizations is dangerous work but it certainly pays well if you can find " +
                "some treasure. Looking at the scattering of your adventuring items beside you, you start start to gather your things; a backpack capable of holding an assortment of " +
                "items, a keychain for keeping any keys you find handy, and of course the most important tool in your arsenal: your " + hero.getWeapon + ". As start to gather what is " +
                "left of your rope, you look at the end of it and realize it didn't snap, rather, it was a clean cut. You are not alone! Something wants to keep you here and you won't be " +
                "able to climb back the way you came. ahead of you are three doors. One to your North, East, and West. It looks like you'll have to find another way out. It sounds as if " +
                "there is movement in the other rooms but it's impossible to tell which. It's time to make a choice. Which direction should you go?";
        return introFlavorText;
    }
    public String getHelpText() {
        helpText = "You have found yourself in a strange labyrinth. You are tasked to find the way out while also trying to gather as much treasure a possible. in order to do this you" +
                "will have to fight various creatures and navigate the dungeon. You can see where you have already traveled by accessing your map. Along your way you may find treasures, " +
                "keys, potions, locked doorways, and of course monsters. Each character class has a different ability so try and use them when you can. Try to survive and escape!";
        return helpText;
    }
    public String getRoomFlavorText1() {
        roomFlavorText1 = "Upon stepping into the room you are hit with a putrid stench. Bones scatter the ground in front of you so thickly you can't even see the floor. Whatever lives " +
                "has quite the appetite. perhaps you shouldn't stay for long.";
        return roomFlavorText1;
    }
    public String getRoomFlavorText2() {
        roomFlavorText2 = "The first thing you notice as you enter the room is how dark it is. As a seasoned adventurer this shouldn't be anything new, but this is something unnatural. " +
                "You can barely see your hands in front of you let alone whatever dark entity might lurk in here. You suddenly feel very cold, like someone is watching you.";
        return roomFlavorText2;
    }
    public String getRoomFlavorText3() {
        roomFlavorText3 = "Whatever this room was used for before it became a decrepit ruin was something sinister. The walls are carved with some indecipherable runes and the center of" +
                "the room has a table clearly made for some type of sacrifice, and judging by the size and shape, they preferred human. There is an ornate dagger in the center of the table " +
                "which looked to be the tool they used. You reach out to grab it to add to your pack but as soon as you touch it you feel as though you grabbed white hot metal. After you " +
                "yelp in pain  and pull back you take a look at what should be a permanently disfigured hand only to find it unscathed. You decide it would be best to leave the cursed dagger. " +
                "Unfortunately something may have heard your scream. It would be best to get as far away from this room as you can.";
        return roomFlavorText3;
    }
    public String getRoomFlavorText4() {
        roomFlavorText4 =
        return roomFlavorText4;
    }
    public String getRoomFlavorText5() {
        return roomFlavorText5;
    }
}
