package project1E7.Controller;

import project1E7.Model.HealthPotion;
import project1E7.View.HealthPotionView;

public class HealthPotionController {
    HealthPotion model;
    HealthPotionView view;

    public HealthPotionController(HealthPotion model, HealthPotionView view) {
        this.model = model;
        this.view = view;
    }
}
