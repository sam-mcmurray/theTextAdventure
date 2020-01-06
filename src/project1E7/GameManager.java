package project1E7;

import project1E7.Controller.*;
import project1E7.Model.*;
import project1E7.View.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    ArrayList<Key> keyRing = new ArrayList<>();
    String userName;
    ArrayList<User> users;
    /**
     * creates new game
     */
    public void newGame(Hero theHero, Room[][] room, Room currentRoom, Controls control, User user){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        ControlsView controlsView = new ControlsView(control);
        ControlsController controlsController = new ControlsController(control, controlsView);
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);
        MapView mapView = new MapView();
        MapController mapController = new MapController(mapView);
        Hero hero = theHero;
        HeroView heroView = new HeroView(hero);
        HeroController heroController = new HeroController(hero, heroView);
        heroView.printStats();
        heroView.heroStory();

        Room previousRoom = currentRoom;
        do {
            boolean flee = false;
            boolean run = true;
            Room roomModel = heroController.currentRoom(currentRoom, room);
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

        } while ((theHero.isAlive() && theHero.getLives() >= 1 ) || heroController.currentRoom(currentRoom, room)!= room[0][3]);


    }


}
