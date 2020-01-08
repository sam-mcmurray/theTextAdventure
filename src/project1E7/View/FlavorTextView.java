package project1E7.View;

import project1E7.Model.Hero;
import project1E7.View.HeroView;

import java.util.*;

public class FlavorTextView {
//this all should be where they make sense monster flavor text in monster view
    private String introFlavorText;

    private String helpText;

    private String weapon;

    private String roomFlavorText1;
    private String roomFlavorText2;
    private String roomFlavorText3;
    private String roomFlavorText4;
    private String roomFlavorText5;

    private String foundChestFlavor1;
    private String foundChestFlavor2;

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

    /**
     * need to put all this in its proper place this isnt a good place to have this stuff
     * it should be in the related classes views
     * @return
     */
    public String getIntroFlavorText() {
        introFlavorText = "Your head aches as you awake from your fall.  You look up to see where you fell from and try to remember exactly what happened. rappelling down the ruins " +
                "was going well until you felt your rope go slack. Exploring decrepit ruins of ancient civilizations is dangerous work but it certainly pays well if you can find " +
                "some treasure. Looking at the scattering of your adventuring items beside you, you start start to gather your things; a backpack capable of holding an assortment of " +
                "items, a keychain for keeping any keys you find handy, and of course the most important tool in your arsenal: your /*.getWeapon*/ . As start to gather what is " +
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

    public String getWeapon () {
        return weapon;
    }

    public String getRoomFlavorText1() {
        roomFlavorText1 = "Upon stepping into the room you are immediately hit with a putrid stench. Bones scatter the ground in front of you so thickly you can't even see the floor. Whatever lives " +
                "has quite the appetite. Perhaps you shouldn't stay for long.";
        return roomFlavorText1;
    }

    public String getRoomFlavorText2() {
        roomFlavorText2 = "The first thing you notice as you enter the room is how dark it is. As a seasoned adventurer this shouldn't be anything new, but this is something unnatural. " +
                "You can barely see your hands in front of you let alone whatever dark entity might lurk in here. You suddenly feel very cold, like someone is watching you.";
        return roomFlavorText2;
    }

    public String getRoomFlavorText3() {
        roomFlavorText3 = "Whatever this room was used for before it became a decrepit ruin was something sinister. The walls are carved with some indecipherable runes and the center of" +
                "the room has a table clearly made for some type of sacrifice, and judging by the size and shape, they preferred human. The ornate dagger resting on the center of the table " +
                "looks to be the tool they used. You reach out to grab it to add to your pack but as soon as you touch it you feel as though you grabbed white hot metal. After you " +
                "yelp in pain  and pull back you take a look at what should be a permanently disfigured hand only to find it unscathed. You decide it would be best to leave the cursed dagger. " +
                "Unfortunately something may have heard your scream. It would be best to get as far away from this room as you can.";
        return roomFlavorText3;
    }

    public String getRoomFlavorText4() {
        roomFlavorText4 = "The dilapidated library you entered is filled with books and scrolls ravaged by time. A more scholarly type with more time might find ancient tomes and knowledge long " +
                "forgotten. Unfortunately, to you they are nothing more than the cause of an ever invading stench of mold and decay. Time to look elsewhere...";
        return roomFlavorText4;
    }

    public String getRoomFlavorText5() {
        roomFlavorText5 = "As you walk into the room you almost fall into the meter and a half long opening to what appears to be a pit of considerable depth. Curious, you drop the rest of your " +
                "half used torch down the shaft and watch as the light continues to fall. You continue to watch for perhaps 40 seconds before the light from your torch is consumed entirely by the " +
                "darkness. You shiver after realizing how close you were to falling in there. Might be best to look for another way out.";
        return roomFlavorText5;
    }

    public String getFoundChestFlavor1() {
        foundChestFlavor1 = "";
        return foundChestFlavor1;
    }
    public String getFoundChestFlavor2() {
        foundChestFlavor2 = "";
        return foundChestFlavor2;
    }

    public String getEncounterFlavorTextSpiderling1() {
        encounterFlavorTextSpiderling1 = "Too late! The skittering of the eight hairy black legs warns you before you ever see it. You barely dodge the meter long spiderling as it pounces forward to " +
                "sink its fangs deep in the soft tissue of your neck. Pulling back from the monstrosity you ready to fight.";

        return encounterFlavorTextSpiderling1;
    }

    public String getEncounterFlavorTextSpiderling2() {
        encounterFlavorTextSpiderling2 = "Too late! You just barely notice the dark shape on the ceiling hurrying towards yourself and ready your weapon. Perhaps you should have been more weary of walking into " +
                "a room with a web infested ceiling. The spiderling slowly drops down while hanging off a silken strand and prepares for a fight.";

        return encounterFlavorTextSpiderling2;
    }

    public String getEncounterFlavorTextBat1() {
        // Remove '//' when adding to destination
        //String characterClass = model.getCharacterClass();
        encounterFlavorTextBat1 = "Too late! While peering into one of the next rooms some leather winged creature flies directly at you. you take out your " + /*getWeapon(characterClass) + */ " without any time to spare " +
                "perry its razor sharp claws. What the oversized bat thought was an easy meal is going to put up a fight.";
        return encounterFlavorTextBat1;
    }

    public String getEncounterFlavorTextBat2() {
        encounterFlavorTextBat2 = "Too late! ";
        return encounterFlavorTextBat2;
    }

    public String getEncounterFlavorTextSkeleton1() {
        encounterFlavorTextSkeleton1 = "Too late! ";
        return encounterFlavorTextSkeleton1;
    }

    public String getEncounterFlavorTextSlime1() {
        encounterFlavorTextSlime1 = "Too late! ";
        return encounterFlavorTextSlime1;
    }

    public String getEncounterFlavorTextSlime2() {
        encounterFlavorTextSlime2 = "Too late! ";
        return encounterFlavorTextSlime2;
    }

    public String getEncounterFlavorTextSkeleton2() {
        encounterFlavorTextSkeleton2 = "Too late! ";
        return encounterFlavorTextSkeleton2;
    }

    public String getEncounterFlavorTextOwlbear1() {
        encounterFlavorTextOwlbear1 = "Too late! ";
        return encounterFlavorTextOwlbear1;
    }

    public String getEncounterFlavorTextOwlbear2() {
        encounterFlavorTextOwlbear2 = "Too late! ";
        return encounterFlavorTextOwlbear2;
    }

    public String getEncounterFlavorTextBoss() {
        encounterFlavorTextBoss = "";
        return encounterFlavorTextBoss;
    }

    public String getAttackFlavorText1 () {
         attackFlavorText1 = "";
        return attackFlavorText1;
    }

    public String getAttackFlavorText2 () {
        attackFlavorText2 = "";
        return attackFlavorText2;
    }

    public String getMissFlavorText1 () {
        missFlavorText1= "";
        return missFlavorText1;
    }

    public String getMissFlavorText2 () {
        missFlavorText2= "";
        return missFlavorText2;
    }

    public String getBossWarning () {
        bossWarning = "";
        return bossWarning;
    }

    public String getBossFlavorText () {
        bossFlavorText = "";
        return bossFlavorText;
    }

    public String getKeyWoodenFlavorText () {
        keyWoodenFlavorText = "";
        return keyWoodenFlavorText;
    }

    public String getKeyStoneFlavorText () {
        keyStoneFlavorText = "";
        return keyStoneFlavorText;
    }

    public String getKeySilverFlavorText () {
        keySilverFlavorText = "";
        return keySilverFlavorText;
    }

    public String getKeyGoldFlavorText () {
        keyGoldFlavorText = "";
        return keyGoldFlavorText;
    }

    public String getDoorWoodenFlavorText () {
        doorWoodenFlavorText = "";
        return doorWoodenFlavorText;
    }

    public String getDoorStoneFlavorText () {
        doorStoneFlavorText = "";
        return doorStoneFlavorText;
    }

    public String getDoorSilverFlavorText () {
        doorSilverFlavorText = "";
        return doorSilverFlavorText;
    }

    public String getDoorGoldFlavorText () {
        doorGoldFlavorText = "";
        return doorGoldFlavorText;
    }
}
