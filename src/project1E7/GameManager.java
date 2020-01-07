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
        User user = new User("Sam", 100);
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
        do {
            boolean flee = false;
            boolean run = true;
            Room roomModel = currentRoom;
            RoomView roomView = new RoomView(roomModel);
            RoomController roomController = new RoomController(roomModel, roomView);
            roomView.flavorTextRoom();
            theHero.setKeyRing(keyRing);
            if (!roomModel.getFound()) {
                if (roomController.roomHasMonster()) {
                    Monster monsterModel = roomController.getMonster();
                    MonsterView monsterView = new MonsterView(monsterModel);
                    MonsterController monsterController = new MonsterController(monsterModel, monsterView);
                    monsterController.resetMonster();

                    monsterView.flavorTextMonster();

                    monsterView.encounter(monsterModel);
                    if (heroController.attackFirst(monsterController)) {

                        if (menuController.encounterHeroFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController, mapView,
                                control, controlsController, controlsView, user, room, currentRoom)) {
                            flee = false;
                        } else {
                            flee = true;
                        }

                    } else {

                        if (menuController.encounterMonsterFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController, mapView,
                                control, controlsController, controlsView, user, room, currentRoom)) {
                            flee = false;

                        } else {
                            flee = true;
                        }
                    }

                }

                while ((theHero.isAlive() && run) && !flee) {
                    if (roomController.roomHasItem()) {
                        Item item = roomController.getItem();
                        ItemView itemView = new ItemView(item);
                        ItemController itemController = new ItemController(item, itemView);
                        run = itemController.encounterItem(item, heroController, keyRing);
                        heroController.addEndurance();

                    } else if (roomController.roomHasItem() == false) {

                        Item item = roomController.setRandomItem();
                        if (item != null) {
                            ItemView itemView = new ItemView(item);
                            ItemController itemController = new ItemController(item, itemView);
                            run = itemController.encounterItem(item, heroController, keyRing);
                            heroController.addEndurance();

                        }
                    }
                }
            }
            if (flee) {
                heroController.addEndurance();
                currentRoom = heroController.previousRoom(previousRoom, room);


            } else if (!theHero.isAlive() && theHero.getLives() > 1){
                heroController.loseLife();
                currentRoom = heroController.previousRoom(previousRoom, room);
                heroController.heroAlive();
                heroView.printLives();

            } else {
                heroController.addEndurance();
                previousRoom = heroController.currentRoom(currentRoom, room);
                roomController.setFound(currentRoom);
                roomView.roomDoors(room, currentRoom);
                currentRoom = heroController.moveHero(keyRing, room, currentRoom, control);
                run = false;
            }

        } while ((theHero.isAlive() && theHero.getLives() > 0 ) || currentRoom != room[0][3]);


    }


}
