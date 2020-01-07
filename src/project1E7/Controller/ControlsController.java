package project1E7.Controller;

import project1E7.Model.Controls;
import project1E7.View.ControlsView;

import java.util.Scanner;

public class ControlsController {
    Controls model;
    ControlsView view;
    Scanner input = new Scanner(System.in);

    public ControlsController(Controls model, ControlsView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * change the game controls 
     */
    public void changeControls() {

        view.changeControlsView();

        String choice1 = input.nextLine();
        boolean decided = false;

        while (!decided) {
            switch (choice1) {
                case "1":

                    System.out.print("Enter the new command for moving up: ");
                    String temp1 = input.nextLine();
                    while (temp1.length() > 1) {

                        System.out.printf("%n" +
                                "You can only use one character as a command%n");
                        temp1 = input.nextLine();
                    }

                    model.setMoveUp(temp1);

                    decided = true;

                    break;
                case "2":

                    System.out.print("Enter the new command for moving down: ");
                    temp1 = input.nextLine();
                    while (temp1.length() > 1) {

                        System.out.printf("%n" +
                                "You can only use one character as a command%n");
                        temp1 = input.nextLine();
                    }

                    model.setMoveDown(temp1);

                    decided = true;

                    break;

                case "3":

                    System.out.print("Enter the new command for moving right: ");
                    temp1 = input.nextLine();
                    while (temp1.length() > 1) {

                        System.out.printf("%n" +
                                "You can only use one character as a command%n");
                        temp1 = input.nextLine();
                    }

                    model.setMoveRight(temp1);

                    decided = true;

                    break;


                case "4":

                    System.out.print("Enter the new command for moving left: ");
                    temp1 = input.nextLine();
                    while (temp1.length() > 1) {

                        System.out.printf("%n" +
                                "You can only use one character as a command%n");
                        temp1 = input.nextLine();
                    }

                    model.setMoveLeft(temp1);

                    decided = true;

                    break;

                default:
                    System.out.printf("%n" +
                            "Invalid option%n");
                    decided = false;


            }
        }
    }
}
