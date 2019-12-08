package project1E7.Controller;

import project1E7.Model.*;
import project1E7.View.ItemView;

import java.util.Random;

public class ItemController {
    Item model;
    ItemView view;
    private Key key;
    private Treasure treasure;

    public ItemController(Item model, ItemView view) {
        this.model = model;
        this.view = view;
    }
    public boolean checkUseItem(Item item) {
     if (item == treasure || item == key) {
         return false;
     }
     return true;
    }
}
