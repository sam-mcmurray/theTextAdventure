package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.ItemView;
import project1E7.View.KeyView;
import project1E7.View.MapView;
import project1E7.View.RoomView;

import java.util.Random;

public class MapController {
    MapView view;

    public MapController(MapView view) {
        this.view = view;
    }

    /**
     * creates the map
     * @param room
     */
    public void createWorld(Room[][] room) {
        Random rand = new Random();
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
        Key goldKey = new Key("Golden key");
        KeyView goldKeyView = new KeyView(goldKey);
        KeyController goldKeyController = new KeyController(goldKey, goldKeyView);
        Key woodenKey = new Key("Wooden key");
        Key stoneKey = new Key("Stone key");
        Key silverKey = new Key("Silver key");
        Key goldenKey = new Key("Golden key");
        Monster theBoss = new Monster(50, 40, 15, "The boss", "The Boss", treasure, true, 4);
        Monster owlBear = new Monster(40, 30, 6, "The owl bear", "The Owl Bear", healthPotion, true, 3);
        Monster skeleton = new Monster(30, 20, 8, "The Skeleton", "The Skeleton", healthPotion, true, 2);
        Monster bat = new Monster(20, 10, 10, "The Bat", "The Bat", coffee, true, 1);
        Monster Slime = new Monster(35, 15, 2, "The Slime", "The Slime", null, true, 2);
        Monster Spiderling = new Monster(10, 6, 9, "The Spiderling,", "Spiderling", null, true, 1);
        Door woodenDoor = new Door(true, "Wooden Key", "The door is ancient and maybe won't open ");
        Door stoneDoor = new Door(true, "Stone key", "you need need to be careful when you use the key inside this door ,might be broken easily");
        Door goldenDoor = new Door(true, "Golden key", "The golden door takes you out ! you are almost free");
        Door silverDoor = new Door(true, "Silver Key", "This door is bright silver just like the key");
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {

                if (i == 8 && j == 5) {
                    Room roomModel = new Room("The Starting Room", true, true);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 0 && j == 3) {
                    Room roomModel = new Room("The Exit", false, treasure, goldenDoor, true, false);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 3) {
                    Room roomModel = new Room("The Boss Room", goldenKey, true, false, theBoss, true, false);
                    room[i][j] = roomModel;
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);

                } else if (i == 1 && j == 1) {
                    Room roomModel = new Room("The Silver Door room", false, coffee, silverDoor, true, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 5 && j == 8) {
                    Room roomModel = new Room("The Skeleton room", stoneKey, true, false, skeleton, true, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 && j == 3) {
                    Room roomModel = new Room("The Owl bear room", silverKey, true, false, owlBear, true, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 7 && j == 8) {
                    Room roomModel = new Room("The wooden door room", false, healthPotion, woodenDoor, true, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 && j == 8) {
                    Room roomModel = new Room("The Bat room", woodenKey, true, false, bat, true, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 3 && j == 6) {
                    Room roomModel = new Room(" The Stone Door room", false, heart, stoneDoor, true, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 0 || j == 0 || i == 9 || j == 9 || i == 1 && j == 2 || i == 2 && j == 2
                        || i == 1 && j == 4 || i == 1 && j == 8 || i == 2 && j == 6 || i == 3 && j == 3 || i == 3 && j == 4
                        || i == 3 && j == 7 || i == 4 && j == 1 || i == 4 && j == 3 || i == 4 && j == 4 || i == 4 && j == 5
                        || i == 4 && j == 6 || i == 6 && j == 2 || i == 6 && j == 4 || i == 6 && j == 5 || i == 7 && j == 7
                        || i == 6 && j == 7 || i == 6 && j == 8 || i == 7 && j == 3 || i == 7 && j == 4 || i == 8 && j == 1) {
                    Room roomModel = new Room("wall", false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 6 || j == 7 || (i == 2 && j == 3) || i == 3) {
                    Room roomModel = new Room("Room description", false, false);
                    RoomView roomView = new RoomView(roomModel);
                    RoomController roomController = new RoomController(roomModel, roomView);
                    room[i][j] = roomModel;

                } else if (i == 8 || i == 7) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, bat, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room("Room description", treasure, true, false, skeleton, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room("Room description", treasure, true, false, owlBear, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room("Room Descrition", false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 5) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, bat, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room("Room description", treasure, true, false, skeleton, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room("Room description", treasure, true, false, owlBear, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room("Room Descrition", false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 4) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, bat, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room("Room description", treasure, true, false, skeleton, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room("Room description", treasure, true, false, owlBear, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room("Room Descrition", false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                } else if (i == 1 || i == 2) {
                    int chanceForMonster = rand.nextInt(6);

                    if (chanceForMonster == 0) {
                        Room roomModel = new Room("Room description", treasure, true, false, bat, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 2) {
                        Room roomModel = new Room("Room description", treasure, true, false, skeleton, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else if (chanceForMonster == 4) {
                        Room roomModel = new Room("Room description", treasure, true, false, owlBear, true, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;

                    } else {
                        Room roomModel = new Room("Room Descrition", false, false);
                        RoomView roomView = new RoomView(roomModel);
                        RoomController roomController = new RoomController(roomModel, roomView);
                        room[i][j] = roomModel;
                    }
                }
            }

        }

        view.mapPrinter(room);

    }
}
