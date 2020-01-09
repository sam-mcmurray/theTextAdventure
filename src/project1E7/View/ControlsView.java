package project1E7.View;

import project1E7.Model.Controls;

public class ControlsView {
    Controls model;

    public ControlsView(Controls model) {
        this.model = model;
    }

    /**
     * view the current controls
     */
    public void viewControls() {
        System.out.println("The following are the commands in place:");

        System.out.printf("Moving up: %s %n" +
                "Moving down: %s %n" +
                "Moving right: %s %n" +
                "Moving left: %s %n", model.getMoveUp(), model.getMoveDown(), model.getMoveRight(), model.getMoveLeft());
    }

    /**
     * change controls for the sub menu change controls section
     */
    public void changeControlsView() {
        System.out.printf("Which one of the controls would you like to change: ");

        System.out.printf("%n" +
                "1- Moving up: %s %n" +
                "2- Moving down: %s %n" +
                "3- Moving right: %s %n" +
                "4- Moving left: %s %n", model.getMoveUp(), model.getMoveDown(), model.getMoveRight(), model.getMoveLeft());

    }
}
