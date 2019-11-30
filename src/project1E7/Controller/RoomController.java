package project1E7.Controller;

import project1E7.Model.Monster;
import project1E7.Model.Room;
import project1E7.View.RoomView;

import java.util.Random;

public class RoomController {
    Room model;
    RoomView view;

    public RoomController(Room model, RoomView view) {
        this.model = model;
        this.view = view;
    }

    public boolean roomHasMonster() {
        Random rand = new Random();

        int chanceForMonster = rand.nextInt(100);

        if (model.isMonster() == false) {
            if (chanceForMonster > 50) {
                return false;
            } else
                model.setMonster(true);
                return true;
        }
        return true ;
    }
    public Monster getMonster(Room room) {
        Monster monster = model.getMonster();
        return monster;

    }
}
