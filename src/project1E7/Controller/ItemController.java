package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.ItemView;

import java.util.Random;

public class ItemController {
    Item model;
    ItemView view;
    private Treasure treasure;
    private Coffee coffee;
    private HealthPotion healthPotion;
    private Heart heart;

    public ItemController(Item model, ItemView view) {
        this.model = model;
        this.view = view;
    }
}
