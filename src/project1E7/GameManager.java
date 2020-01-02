package project1E7;

import project1E7.Controller.*;
import project1E7.Model.*;
import project1E7.View.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

    /**
     * creates new game
     */
    public void newGame(){
        Controls control = new Controls("w", "s", "d", "a");
        ControlsView controlsView = new ControlsView(control);
        ControlsController controlsController = new ControlsController(control, controlsView);

        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);
        Scanner input = new Scanner(System.in);
        String userName;
        ArrayList<User> users;
        Room[][] room = new Room[10][10];
        ArrayList<Key> keyRing = new ArrayList<>();

        MapView mapView = new MapView();
        MapController mapController = new MapController(mapView);
        Random rand = new Random();
        mapController.createWorld(room);
        Hero theHero = (menuController.selectHero());
        HeroView heroView = new HeroView(theHero);
        HeroController heroController = new HeroController(theHero, heroView);
        heroView.printStats();
        heroView.heroStory();
        Room currentRoom = room[8][5];
        Room previousRoom = currentRoom;
        boolean flee = false;
        do {
            boolean run = true;
            Room roomModel = currentRoom;
            RoomView roomView = new RoomView(roomModel);
            RoomController roomController = new RoomController(roomModel, roomView);
            roomView.flavorTextRoom();

            theHero.setKeyRing(keyRing);
            if (roomModel.getFound() == false) {
                if (roomController.roomHasMonster()) {
                    Monster monsterModel = roomController.getMonster();
                    MonsterView monsterView = new MonsterView(monsterModel);
                    MonsterController monsterController = new MonsterController(monsterModel, monsterView);

                    monsterView.flavorTextMonster();

                    monsterView.encounter(monsterModel);
                    if (heroController.attackFirst(monsterController) == true) {

                        if (menuController.encounterHeroFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController)) {
                            flee = false;
                        } else {
                            flee = true;
                        }

                    } else {

                        if (menuController.encounterMonsterFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController)) {
                            flee = false;
                        } else {
                            flee = true;
                        }
                    }

                }

                while ((theHero.isAlive() == true && run == true) && flee == false) {
                    if (roomController.roomHasItem() == true) {
                        Item item = roomController.getItem();
                        ItemView itemView = new ItemView(item);
                        ItemController itemController = new ItemController(item, itemView);
                        run = itemController.encounterItem(item, heroController, keyRing);


                    } else if (roomController.roomHasItem() == false) {

                        Item item = roomController.setRandomItem();
                        if (item != null) {
                            ItemView itemView = new ItemView(item);
                            ItemController itemController = new ItemController(item, itemView);
                            run = itemController.encounterItem(item, heroController, keyRing);

                        }
                    }
                }
            }
            if (flee == true) {
                currentRoom = previousRoom;
            } else {
                previousRoom = currentRoom;
                roomController.setFound(currentRoom);
                roomView.roomDoors(room, currentRoom);
                currentRoom = heroController.moveHero(keyRing, room, currentRoom, control);
                run = false;
            }

        } while (theHero.isAlive() == true || theHero.getLives() > 0 || currentRoom != room[0][3]);


    }


}
