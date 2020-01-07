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
     * @param room
     */
    public void createWorld(Room[][] room) {
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
        Weapon weapon = new Weapon("+1");
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
        Monster theBoss = new Monster(50, 40, 15, "The boss", "The Boss", treasure, true, 4);
        MonsterView theBossMonsterView = new MonsterView(theBoss);
        MonsterController theBossMonsterController = new MonsterController(theBoss, theBossMonsterView);
        Monster owlBear = new Monster(40, 30, 6, "The owl bear", "The Owl Bear", healthPotion, true, 3);
        MonsterView owlBearMonsterView = new MonsterView(owlBear);
        MonsterController owlBearMonsterController = new MonsterController(owlBear, owlBearMonsterView);
        Monster skeleton = new Monster(30, 20, 8, "The Skeleton", "The Skeleton", healthPotion, true, 2);
        MonsterView skeletonMonsterView = new MonsterView(skeleton);
        MonsterController skeletonMonsterController = new MonsterController(skeleton, skeletonMonsterView);
        Monster bat = new Monster(20, 10, 10, "The Bat", "The Bat", coffee, true, 1);
        MonsterView batMonsterView = new MonsterView(bat);
        MonsterController batMonsterController = new MonsterController(bat, batMonsterView);
        Monster slime = new Monster(35, 15, 2, "The Slime", "The Slime", null, true, 2);
        MonsterView slimeMonsterView = new MonsterView(slime);
        Monster spiderling = new Monster(10, 6, 9, "The Spiderling,", "Spiderling", null, true, 1);
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

                if (i == 8 && j == 5) {
                    Room roomModel = new Room("The bottom of a large chasm you were rappelling into. Unfortunately your rope was cut and the it's \nimpossible to climb back up. Best to look for another way out", true, true,true);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 0 && j == 3) {
                    Room roomModel = new Room("The Exit", false, treasure, goldenDoor, true, false,false);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 3) {
                    Room roomModel = new Room("The Boss Room", goldKey, true, false, theBoss, true, false,false);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 1) {
                    Room roomModel = new Room("This room has a weapon", false, weapon, silverDoor, true, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 5 && j == 8) {
                    Room roomModel = new Room("The Skeleton room", stoneKey, true, false, skeleton, true, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 && j == 3) {
                    Room roomModel = new Room("The Owl bear room", silverKey, true, false, owlBear, true, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 7 && j == 8) {
                    Room roomModel = new Room("The wooden door room", false, weapon, woodenDoor, true, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 && j == 8) {
                    Room roomModel = new Room("", woodenKey, true, false, bat, true, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 3 && j == 6) {
                    Room roomModel = new Room(" The Stone Door room", false, heart, stoneDoor, true, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 0 || j == 0 || i == 9 || j == 9 || i == 1 && j == 2 || i == 2 && j == 2
                        || i == 1 && j == 4 || i == 1 && j == 8 || i == 2 && j == 6 || i == 3 && j == 3 || i == 3 && j == 4
                        || i == 3 && j == 7 || i == 4 && j == 1 || i == 4 && j == 3 || i == 4 && j == 4 || i == 4 && j == 5
                        || i == 4 && j == 6 || i == 6 && j == 2 || i == 6 && j == 4 || i == 6 && j == 5 || i == 7 && j == 7
                        || i == 6 && j == 7 || i == 6 && j == 8 || i == 7 && j == 3 || i == 7 && j == 4 || i == 8 && j == 1) {
                    Room roomModel = new Room("wall", false, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 || j == 7 || (i == 2 && j == 3) || i == 3) {
                    Room roomModel = new Room(description, false, false,false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 || i == 7) {
                    int chanceForMonster = rand.nextInt(8);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 1) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 5) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 5) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 4) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 1) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 1 || i == 2) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room(description, cashMoney, true, false, bat, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 1) {
                        Room roomModel = new Room(description, item, true, false, skeleton, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room(description, item, true, false, owlBear, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 3) {
                        Room roomModel = new Room(description, item, true, false, slime, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room(description, cashMoney, true, false, spiderling, true, false,false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room(description, false, false,false);
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

        if (possibleItem <=50) {
            if(itemType <=74){
                Treasure treasure = new Treasure("Gold Chest",1000);
                if(treasureAmount <= 49) {
                    treasure.setAmount(1000);
                    treasure.setName("a pile of copper coins");
                    return treasure;
                } else if (treasureAmount >= 50 && treasureAmount <= 69) {
                    treasure.setAmount(4000);
                    treasure.setName("a pile of silver coins");
                    return treasure;
                } else if (treasureAmount >= 70 && treasureAmount <= 84) {
                    treasure.setAmount(6000);
                    treasure.setName("a pile of gold coins");
                    return treasure;
                } else if (treasureAmount >= 85 && treasureAmount <= 94) {
                    treasure.setName("a pile of precious gemstones");
                    treasure.setAmount(8500);
                    return treasure;
                } else if (treasureAmount >= 95) {
                    treasure.setName("a beautifully crafted ornate goblet");
                    treasure.setAmount(10000);
                    return treasure;
                }

            } else if (itemType >= 75 && itemType <= 84) {
                Coffee coffee = new Coffee("a steaming cup of Coffee");
                return coffee;
            } else if (itemType >= 85 && itemType <= 94) {
                HealthPotion healthPotion = new HealthPotion("a glowing red health potion");
                return healthPotion;
            } else if (itemType >= 95) {
                Heart heart = new Heart("a heart inside a glass container. It still beats.");
                return heart;
            }
        }
        //Coffee coffee = new Coffee("disgusting coffee");
        return null;
    }
    public Treasure checkTreasureValue(Treasure treasure) {
        if (treasure.getAmount() == 0) {
            int setRand = rand.nextInt(100);
            if(setRand <= 49) {
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
