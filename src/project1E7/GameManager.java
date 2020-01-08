package project1E7;

import project1E7.Controller.*;
import project1E7.Model.*;
import project1E7.View.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public void game(Hero theHero, Room[][] room, Room currentRoom, Controls control, User user) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        Controls controls = control;
        ControlsView controlsView = new ControlsView(control);
        ControlsController controlsController = new ControlsController(control, controlsView);
        ArrayList<Item> backPack = new ArrayList<>();
        Menu menu = new Menu();
        MenuView menuView = new MenuView(menu);
        MenuController menuController = new MenuController(menuView, menu);
        MapView mapView = new MapView();
        MapController mapController = new MapController(mapView);
        Hero hero = theHero;
        HeroView heroView = new HeroView(hero);
        HeroController heroController = new HeroController(hero, heroView);


        Room previousRoom = currentRoom;
        do {
            boolean flee = false;
            boolean run = true;
            mapView.mapPrinter(room);
            Room roomModel = heroController.currentRoom(currentRoom, room);
            RoomView roomView = new RoomView(roomModel);
            RoomController roomController = new RoomController(roomModel, roomView);
            roomView.flavorTextRoom(currentRoom);
            theHero.setKeyRing(keyRing);
            if (!roomModel.getFound()) {
                if (roomController.roomHasMonster()) {
                    Monster monsterModel = roomController.getMonster();
                    MonsterView monsterView = new MonsterView(monsterModel);
                    MonsterController monsterController = new MonsterController(monsterModel, monsterView);
                    monsterController.resetMonster();

                    monsterView.flavorTextMonster(theHero);

                    //monsterView.encounter(monsterModel);
                    if (heroController.attackFirst(monsterController)) {

                        if (menuController.encounterHeroFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController, mapView,
                                control, controlsController, controlsView, user, room, currentRoom,backPack)) {
                            flee = false;
                        } else {
                            flee = true;
                        }

                    } else {

                        if (menuController.encounterMonsterFirst(theHero, heroView, heroController, monsterModel, monsterView, monsterController, mapView,
                                control, controlsController, controlsView, user, room, currentRoom,backPack)) {
                            flee = false;

                        } else {
                            flee = true;
                        }
                    }
                }

                while ((theHero.isAlive() && run) && !flee) {
                    if (roomController.roomHasItem()) {
                        Item item = roomController.findItem();
                        ItemView itemView = new ItemView(item);
                        ItemController itemController = new ItemController(item, itemView);
                        run = itemController.encounterItem(item, heroController, keyRing, backPack, menuController, controlsController
                                , controlsView, mapView, room, theHero, heroView, currentRoom, user, controls);
                        heroController.addEndurance();

                    } else if (roomController.roomHasItem() == false) {

                        Item item = new Item("missing");
                        ItemView itemView = new ItemView(item);
                        ItemController itemController = new ItemController(item, itemView);
                        run = false;
                        itemController.encounterItem(item, heroController, keyRing, backPack, menuController, controlsController,
                                controlsView, mapView, room, theHero, heroView, currentRoom, user, controls);
                        heroController.addEndurance();

                    }
                }
            }
            if (flee) {
                heroController.addEndurance();
                currentRoom = heroController.previousRoom(previousRoom, room, currentRoom);


            } else if (!theHero.isAlive() && theHero.getLives() > 1) {
                heroController.loseLife();
                currentRoom = heroController.previousRoom(previousRoom, room, currentRoom);
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
            if (heroController.endCheck(room, currentRoom)) {break;}

        } while ((theHero.isAlive() && theHero.getLives() >= 1 ) || heroController.currentRoom(currentRoom, room)!= room[0][3]);

        File file = new File("HighScore.txt");
        Load load = new Load(file, "HighScore.txt");
        LoadView loadView = new LoadView(load);
        LoadController loadController = new LoadController(load, loadView);

        heroView.theEndGame(100,"Trogdar" ,theHero.getCurrentTreasure());
        //heroView.theEndGame(loadController.loadHighestScore(),loadController.loadHighestScorer() ,theHero.getCurrentTreasure());
       // if(theHero.getCurrentTreasure()>loadController.loadHighestScore())
        {

            Save save = new Save(theHero,room, controls, user, currentRoom);
            SaveView saveView = new SaveView(save);
            SaveController saveController = new SaveController(save, saveView);

            saveController.saveHighScore(user.getUserName(),theHero.getCurrentTreasure(), room);
        }
    }
}
