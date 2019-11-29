package project1E7.Controller;

import project1E7.Model.Coffee;
import project1E7.View.CoffeeView;

public class CoffeeController {
    Coffee model;
    CoffeeView view;

    public CoffeeController(Coffee model, CoffeeView view) {
        this.model = model;
        this.view = view;
    }
}
