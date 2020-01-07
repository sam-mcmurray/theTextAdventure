package project1E7.View;

import project1E7.Model.Save;

public class SaveView {
    Save model;

    public SaveView(Save model) {
        this.model = model;
    }

    public void printSave() {
            System.out.println("Your game has been saved");
        }

}
