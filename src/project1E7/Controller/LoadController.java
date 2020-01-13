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
    private Scanner inputS;


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
            gameManager.game(game.getJsonHero(), game.getJsonMap(), game.getJsonMap()[game.getJsonI()][game.getJsonJ()],
                    game.getJsonControls(), game.getJsonUser(),game.getJsonMap()[game.getI()][game.getJ()]);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int loadHighestScore(){

            String userName;
            String highScorePrint;

        try {

            inputS = new Scanner(new File("HighScore.txt"));
            String a = inputS.next();
            userName = inputS.next();
            String b = inputS.next();
            highScorePrint = inputS.next();
            inputS.close();
            int highScore = Integer.parseInt(highScorePrint);
            model.setHighScore(highScore);
        } catch (FileNotFoundException e) {

            e.getMessage();

        }
        return model.getHighScore();
    }
    public void printHighScore() {
        String userNamePrint;
        String highScorePrint;

        try {
            inputS = new Scanner(new File("HighScore.txt"));
                String a = inputS.next();
                userNamePrint = inputS.next();
                model.setUserName(userNamePrint);
                String b = inputS.next();
                highScorePrint = inputS.next();
                int highScore = Integer.parseInt(highScorePrint);
                model.setHighScore(highScore);
                System.out.println("UserName: " + model.getUserName() + " \nHighScore: " + model.getHighScore());
                inputS.close();

    } catch (FileNotFoundException e) {
        e.getMessage();
    }
    }

    public String loadHighestScorer(){

        String userNamePrint;
        String highScorePrint;

        try {
            inputS = new Scanner(new File("HighScore.txt"));
            String a = inputS.next();
            userNamePrint = inputS.next();
            model.setUserName(userNamePrint);
            String b = inputS.next();
            highScorePrint = inputS.next();
            int highScore = Integer.parseInt(highScorePrint);
            model.setHighScore(highScore);
            inputS.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
        }


        return model.getUserName();
    }
}
