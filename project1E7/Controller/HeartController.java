package src.project1E7.Controller;

import src.project1E7.Model.Heart;
import src.project1E7.View.HeartView;

public class HeartController {
    Heart model;
    HeartView view;

    public HeartController(Heart model, HeartView view) {
        this.model = model;
        this.view = view;
    }
}