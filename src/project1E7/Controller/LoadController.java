package project1E7.Controller;

import com.google.gson.*;
import project1E7.GameManager;
import project1E7.Model.*;
import project1E7.View.HeroView;
import project1E7.View.LoadView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class LoadController {
    Load model;
    LoadView view;
    Gson gson = new Gson();


    public LoadController(Load model, LoadView view) {
        this.model = model;
        this.view = view;
    }
    public void loadGame() {

        String fileName = "SavedGame.json";
        Path path = Paths.get(fileName);

        try {
            String json = Files.readString(path);


            Game game = gson.fromJson(json, Game.class);

            HeroView heroView = new HeroView(game.getJsonHero());
            HeroController heroController = new HeroController(game.getJsonHero(), heroView);

            GameManager gameManager = new GameManager();
            gameManager.game(game.getJsonHero(), game.getJsonMap(), heroController.currentRoom(game.getJsonCurrentRoom(), game.getJsonMap()), game.getJsonControls(), game.getJsonUser());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int loadHighestScore(){

            String line = "";
        try {

            Scanner inputS = new Scanner(model.getFile());

            inputS.nextLine();
            line=inputS.nextLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(line);
    }
}
