package project1E7.Controller;

import project1E7.Model.Item;
import project1E7.View.ItemView;

public class ItemController {
    Item model;
    ItemView view;

    public ItemController(Item model, ItemView view) {
        this.model = model;
        this.view = view;
    }
    
}
