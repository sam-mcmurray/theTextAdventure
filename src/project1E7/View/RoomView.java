package project1E7.View;


import project1E7.Model.Room;

import java.util.Random;

public class RoomView {
    Room model;

    public RoomView(Room model) {
        this.model = model;
    }

    public boolean roomHasItem(Room room) {
        if (model.isHasItem() == true) {
            return true;
        } else
            return false;
    }

}