package project1E7.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import project1E7.GameManager;
import project1E7.Model.*;
import project1E7.View.SaveView;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
    public void saveHighScore(String username, int highscore) {

        try {

            File file = new File("HighScore.txt");
            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);

            bWriter.write(username);
            bWriter.newLine();
            bWriter.write(highscore);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
