package project1E7.View;

import project1E7.Model.Key;

public class KeyView {
    Key model;

    public KeyView(Key model) {
        this.model = model;
    }

    public void foundKey() {
        System.out.println("You found " + model.getName());
    }
}
