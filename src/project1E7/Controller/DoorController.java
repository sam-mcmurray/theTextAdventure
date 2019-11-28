package src.project1E7.Controller;

import src.project1E7.Model.Door;
import src.project1E7.View.DoorView;

public class DoorController {
    Door model;
    DoorView view;

    public DoorController(Door model, DoorView view) {
        this.model = model;
        this.view = view;
    }
}
