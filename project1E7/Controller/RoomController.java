package src.project1E7.Controller;

import src.project1E7.Model.Room;
import src.project1E7.View.RoomView;

public class RoomController {
    Room model;
    RoomView view;

    public RoomController(Room model, RoomView view) {
        this.model = model;
        this.view = view;
    }
}
