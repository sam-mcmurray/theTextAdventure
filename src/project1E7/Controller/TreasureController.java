package project1E7.Controller;

import project1E7.Model.Treasure;
import project1E7.View.TreasureView;

public class TreasureController {
    Treasure model;
    TreasureView view;

    public TreasureController(Treasure model, TreasureView view) {
        this.model = model;
        this.view = view;
    }
}
