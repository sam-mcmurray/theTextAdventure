package project1E7.Controller;

import com.google.gson.Gson;
import project1E7.Model.*;
import project1E7.View.SaveView;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

public class SaveController {

    Scanner input = new Scanner(System.in);
    Save model;
    SaveView view;
    Gson gson = new Gson();


    public SaveController(Save model, SaveView view) {
        this.model = model;
        this.view = view;
    }
    public void saveGame(Game game) {
        Gson gson = new Gson();
        String theGame = gson.toJson(game);

        try {
            FileWriter fileWriter = new FileWriter("SavedGame.json");
            fileWriter.write(theGame);
            fileWriter.close();
            view.printSave();
        }
        catch(Exception e) {
            System.out.println("please delete existing file");
        }
    }


    public void saveHighScore(User user) {

        Formatter save;

        try {
            String name = user.getUserName();
            String highScore = "";
            highScore = Integer.toString(user.getHighScore());
            save = new Formatter("HighScore.txt");
            save.format("Username: %s, HighScore: %s", name,highScore);
            save.close();

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
