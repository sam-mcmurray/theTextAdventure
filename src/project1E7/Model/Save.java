package project1E7.Model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Save {
    Scanner input = new Scanner(System.in);

    /**
     * save game not yet tested also dont know if i need more than this
     * working on it
     *
     * @param room
     * @param currentRoom
     * @param theHero
     * @param controls
     * @param user
     */
    public void saveGame(Room[][] room, Room currentRoom, Hero theHero, Controls controls, User user) {
        Gson gson = new Gson();
        String jsonHero = gson.toJson(theHero);
        String jsonMap = gson.toJson(room);
        String jsonControls = gson.toJson(controls);
        String jsonUser = gson.toJson(user);
        String jsonCurrentRoom = gson.toJson(currentRoom);
    }

    /**
     * save the high score untested
     *
     * @param users
     * @return
     */
    public void saveHighScore() {

        System.out.println("Saving game, please do not turn off the system");

        try {

            File file = new File("HighScore.txt");
            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);

            bWriter.write();
            bWriter.newLine();
            bWriter.flush();
            bWriter.close();
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);

            bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
