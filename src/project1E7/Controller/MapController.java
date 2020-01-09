package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.*;

import java.util.Random;

public class MapController {
    MapView view;
    Random rand = new Random();

    public MapController(MapView view) {
        this.view = view;
    }

    /**
     * creates the map
     *
     * @param room
     */
    public void createWorld(Room[][] room, Hero theHero) {
        Coffee coffee = new Coffee("Coffee");
        Item itemModelCoffee = coffee;
        ItemView itemViewCoffee = new ItemView(itemModelCoffee);
        ItemController itemControllerCoffee = new ItemController(itemModelCoffee, itemViewCoffee);
        Treasure treasure = new Treasure("Gold Chest", 5000);
        Item itemModelTreasure = treasure;
        ItemView itemViewTreasure = new ItemView(itemModelTreasure);
        ItemController itemControllerTreasure = new ItemController(itemModelTreasure, itemViewTreasure);
        Heart heart = new Heart("Heart");
        Item itemModelHeart = heart;
        ItemView itemViewHeart = new ItemView(itemModelHeart);
        ItemController itemControllerHeart = new ItemController(itemModelHeart, itemViewHeart);
        HealthPotion healthPotion = new HealthPotion("Health portion");
        Item itemModelHealthPotion = healthPotion;
        ItemView itemViewHealthPotion = new ItemView(itemModelHealthPotion);
        ItemController itemControllerHealthPotion = new ItemController(itemModelHealthPotion, itemViewHealthPotion);
        Weapon weapon = new Weapon("");
        Item itemModelWeapon = weapon;
        ItemView itemViewWeapon = new ItemView(itemModelWeapon);
        ItemController itemControllerWeapon = new ItemController(itemModelWeapon, itemViewWeapon);
        Key goldKey = new Key("Golden key");
        KeyView goldKeyView = new KeyView(goldKey);
        KeyController goldKeyController = new KeyController(goldKey, goldKeyView);
        Key woodenKey = new Key("Wooden key");
        KeyView woodenKeyView = new KeyView(woodenKey);
        KeyController woodenKeyController = new KeyController(woodenKey, woodenKeyView);
        Key stoneKey = new Key("Stone key");
        KeyView stoneKeyView = new KeyView(stoneKey);
        KeyController stoneKeyController = new KeyController(stoneKey, stoneKeyView);
        Key silverKey = new Key("Silver key");
        KeyView silverKeyView = new KeyView(silverKey);
        KeyController silverKeyController = new KeyController(silverKey, silverKeyView);
        Monster theBoss = new Monster(180, 30, 70, "The Boss", "Boss", null, true, 4);
        MonsterView theBossMonsterView = new MonsterView(theBoss);
        MonsterController theBossMonsterController = new MonsterController(theBoss, theBossMonsterView);
        Monster owlBear = new Monster(130, 15, 60, "an Owlbear", "Owlbear", null, true, 3);
        MonsterView owlBearMonsterView = new MonsterView(owlBear);
        MonsterController owlBearMonsterController = new MonsterController(owlBear, owlBearMonsterView);
        Monster skeleton = new Monster(80, 10, 50, "a Skeleton", "Skeleton", null, true, 2);
        MonsterView skeletonMonsterView = new MonsterView(skeleton);
        MonsterController skeletonMonsterController = new MonsterController(skeleton, skeletonMonsterView);
        Monster bat = new Monster(70, 8, 70, "a Bat", "Bat", coffee, true, 1);
        MonsterView batMonsterView = new MonsterView(bat);
        MonsterController batMonsterController = new MonsterController(bat, batMonsterView);
        Monster slime = new Monster(90, 12, 20, "a Slime", "Slime", null, true, 2);
        MonsterView slimeMonsterView = new MonsterView(slime);
        Monster spiderling = new Monster(40, 6, 90, "The Spiderling,", "Spiderling", null, true, 1);
        Door woodenDoor = new Door(true, "Wooden Key", "The wooden door is worn and rather unimpressive.");
        Door stoneDoor = new Door(true, "Stone key", "The stone door in front of you is immense and made with a solid stone slab.  There is a large slot for a key");
        Door goldenDoor = new Door(true, "Golden key", "The golden door looks like it will take you outside!  Freedom is within your grasp!");
        Door silverDoor = new Door(true, "Silver Key", "This door is an unnaturally shiny silver, who or what could possible be polishing it?");
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {

                Item item = setRandomItem();
                Treasure cashMoney = new Treasure("", 0);
                checkTreasureValue(cashMoney);
                String description = flavorTextRoom();
                Item noItem = new Item("");
                Item endItem = new Item("endItem");

                if (i == 8 && j == 5) {
                    Room roomModel = new Room("The bottom of a large chasm you were rappelling into. Unfortunately your rope was cut and the it's " +
                            "\nimpossible to climb back up. Best to look for another way out", true, true, true, true, noItem);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 0 && j == 3) {
                    Room roomModel = new Room("This is it. You see the daylight at the end of the cave.", false, endItem, true, false, goldenDoor, true, false, false);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 3) {
                    Room roomModel = new Room("Standing before you is an ornate gateway that could be marveled as a piece of art if \n" +
                            "it weren't for the tens of broken and dead adventurers representing the danger on the other \n" +
                            "side of the door. Taking a deep breath you open the gates and enter the room.", goldKey, true, false, theBoss, true, false, false);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 1) {
                    Room roomModel = new Room("After unlocking the grand silver door it becomes clear why they key was so coveted. Insede the \n" +
                            "room are perhaps 40 hooded figures all kneeling and praying towards the one object at the end of the room. \n" +
                            "The object is a weapon, same as the one you're holding in fact but also different, more powerful. The do not \n" +
                            "protest as you walk for wards and pick up your new weapon, and as you turn around again to face the quite chanting \n" +
                            "you see they vanished in thin air. Only their robes remain.", false, weapon, true, false, silverDoor, true, false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 5 && j == 8) {
                    Room roomModel = new Room("Within the center of the room stands a massive stone pillar reaching towards the top of the \n" +
                            "cavern. On the face of the pillar is a hole that could fit your arm inside. For some strange reason \n" +
                            "you feel drawn towards it and decide it's a good idea to reach inside and pull whatever is inside, out. \n" +
                            "You carefully reach inside and feel around for some mysterious item. Suddenly something grabs back! \n" +
                            "For several moments you try and pull back your arm in vain, when suddenly whatever was holding onto \n" +
                            "you let go. When you go to look at your hand and check if all your digits are still there, you realize \n" +
                            "you're holding onto a key made of stone.", stoneKey, true, false, skeleton, true, false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 && j == 3) {
                    Room roomModel = new Room("Sitting upon an alter in the center of the room is a glass case. Inside there is but one item, \n" +
                            "a key. The surrounding room is made up of various religious paraphernalia. It appears this key held some \n" +
                            "sort of religious importance. Regardless it's yours now. You break the glass and stash the key on your belt.", silverKey, true, false, owlBear, true, false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 7 && j == 8) {
                    Room roomModel = new Room("The room would appear rather ordinary except for the large oak tree growing in the center \n" +
                            "of the room. A single skylight shines down upon tree allowing it to grow. You notice a water pail \n" +
                            "beside the tree and decide it probably hasn't been watered in a while. Moments after watering it, \n" +
                            "the ground seems to move. The roots of the tree twist and unravel revealing a health potion.",
                            false, healthPotion, true, false, woodenDoor, true, false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 && j == 8) {
                    Room roomModel = new Room("It is a simple room. Small and candle light, this room feels more ancient than the others \n" +
                            "you've come across. Someone has lived here and you notice a bed in which lays a mummified \n" +
                            "skeleton gripping an a large wooden key.  Conveniently there appears to be a large carved \n" +
                            "wooden door to the north. Maybe it fits in there?", woodenKey, true, false, bat, true, false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 3 && j == 6) {
                    Room roomModel = new Room(" Once again you find yourself face to face with another stone pillar, this time however its \n" +
                            "crumbling. This time you decide not to play its games. With all your might you push the all your might \n" +
                            "and the pillar tips and crashes down. When the dust clears you see a small creature that was crushed \n" +
                            "by the rubble. inside his open chest is a still beating heart.", false, heart, true, false, stoneDoor, true, false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 0 || j == 0 || i == 9 || j == 9 || i == 1 && j == 2 || i == 2 && j == 2
                        || i == 1 && j == 4 || i == 1 && j == 8 || i == 2 && j == 6 || i == 3 && j == 3 || i == 3 && j == 4
                        || i == 3 && j == 7 || i == 4 && j == 1 || i == 4 && j == 3 || i == 4 && j == 4 || i == 4 && j == 5
                        || i == 4 && j == 6 || i == 6 && j == 2 || i == 6 && j == 4 || i == 6 && j == 5 || i == 7 && j == 7
                        || i == 6 && j == 7 || i == 6 && j == 8 || i == 7 && j == 3 || i == 7 && j == 4 || i == 8 && j == 1) {
                    Room roomModel = new Room("wall", false, false, false,true,noItem);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 || j == 7 || (i == 2 && j == 3) || i == 3) {
                    Room roomModel = new Room(description, false, false, false,true,item);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 || i == 7) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 1) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false, false, true,item);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 5) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 5) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false, false,true,item);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 4) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 1) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false, false,true,item);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 1 || i == 2) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 1) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false, false,true,item);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                }
            }

        }
        room[(9)][5].setBeenSeen(true);
        room[(7)][5].setBeenSeen(true);
        room[8][(6)].setBeenSeen(true);
        room[8][(4)].setBeenSeen(true);
    }

    public String flavorTextRoom() {

        Random random = new Random();
        String description = "";
        int numberGen = random.nextInt(5);

        if (numberGen == 0) {
            description = "Upon stepping into the room you are immediately hit with a putrid stench. Bones scatter the \n" +
                    "ground in front of you so thickly you can't even see the floor. Whatever lives here has quite the \n" +
                    "appetite. Perhaps you shouldn't stay for long.";
            return description;
        } else if (numberGen == 1) {
            description = "The first thing you notice as you enter the room is how dark it is. As a seasoned adventurer \n" +
                    "this shouldn't be anything new, but this is something unnatural. You can barely see your hands in \n" +
                    "front of you let alone whatever dark entity might lurk in here. You suddenly feel very cold, like \n" +
                    "someone is watching you.";
            return description;
        } else if (numberGen == 2) {
            description = "Whatever this room was used for before it became a decrepit ruin was something sinister. The \n" +
                    "walls are carved with some indecipherable runes and the center of the room has a table clearly made \n" +
                    "for some type of sacrifice, and judging by the size and shape, they preferred human. The ornate \n" +
                    "dagger resting on the center of the table looks to be the tool they used. You reach out to grab it \n" +
                    "to add to your pack but as soon as you touch it you feel as though you grabbed white hot metal. \n" +
                    "After you yelp in pain  and pull back you take a look at what should be a permanently disfigured \n" +
                    "hand only to find it unscathed. You decide it would be best to leave the cursed dagger. \n" +
                    "Unfortunately something may have heard your scream. It would be best to get as far away from this \n" +
                    "room as you can.";
            return description;
        } else if (numberGen == 3) {
            description = "The dilapidated library you entered is filled with books and scrolls ravaged by time. A \n" +
                    "more scholarly type with more time might find ancient tomes and knowledge long forgotten. \n" +
                    "Unfortunately, to you they are nothing more than the cause of an ever invading stench of mold and \n" +
                    "decay. Time to look elsewhere...";
            return description;
        } else {
            description = "As you walk into the room you almost fall into the meter and a half long opening to what \n" +
                    "appears to be a pit of considerable depth. Curious, you drop the rest of your half used torch \n" +
                    "down the shaft and watch as the light continues to fall. You continue to watch for perhaps 40 \n" +
                    "seconds before the light from your torch is consumed entirely by the darkness. You shiver after \n" +
                    "realizing how close you were to falling in there. Might be best to look for another way out.";
            return description;
        }
    }

    public Item setRandomItem() {
        Random rand = new Random();

        int possibleItem = rand.nextInt(100);
        int itemType = rand.nextInt(100);
        int treasureAmount = rand.nextInt(100);

        if (possibleItem <= 70) {
            if (itemType <= 60) {
                Treasure treasure = new Treasure("Gold Chest", 1000);
                if (treasureAmount <= 49) {
                    treasure.setAmount(1000);
                    return treasure;
                } else if (treasureAmount <= 69) {
                    treasure.setAmount(4000);
                    return treasure;
                } else if (treasureAmount <= 84) {
                    treasure.setAmount(6000);
                    return treasure;
                } else if (treasureAmount <= 94) {
                    treasure.setAmount(8500);
                    return treasure;
                } else if (treasureAmount >= 95) {
                    treasure.setAmount(10000);
                    return treasure;
                }

            } else if (itemType <= 80) {
                Coffee coffee = new Coffee("a steaming cup of Coffee");
                return coffee;
            } else if (itemType <= 93) {
                HealthPotion healthPotion = new HealthPotion("a glowing red health potion");
                return healthPotion;
            } else if (itemType >= 94) {
                Heart heart = new Heart("a heart inside a crystalline container. It still beats.");
                return heart;
            }
        }
        Item item = new Item("missing");
        return item;
    }

    public Treasure checkTreasureValue(Treasure treasure) {
        if (treasure.getAmount() == 0) {
            int setRand = rand.nextInt(100);
            if (setRand <= 49) {
                treasure.setAmount(1000);
                treasure.setName("a pile of copper coins");
                return treasure;
            } else if (setRand >= 50 && setRand <= 69) {
                treasure.setName("a pile of silver coins");
                treasure.setAmount(4000);
                return treasure;
            } else if (setRand >= 70 && setRand <= 84) {
                treasure.setName("a pile of gold coins");
                treasure.setAmount(6000);
                return treasure;
            } else if (setRand >= 85 && setRand <= 94) {
                treasure.setName("a pile of precious gemstones");
                treasure.setAmount(8500);
                return treasure;
            } else if (setRand >= 95) {
                treasure.setAmount(10000);
                treasure.setName("a beautifully crafted ornate goblet");
                return treasure;
            }
        }
        return treasure;
    }
}
