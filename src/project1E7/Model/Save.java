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
     * @param room
     * @param currentRoom
     * @param theHero
     * @param controls
     * @param user
     */
    public void saveGame(Room[][] room, Room currentRoom,Hero theHero, Controls controls, User user) {
        Gson gson = new Gson();
        String jsonHero = gson.toJson(theHero);
        String jsonMap = gson.toJson(room);
        String jsonControls = gson.toJson(controls);
        String jsonUser = gson.toJson(user);
        String jsonCurrentRoom = gson.toJson(currentRoom);
    }

    /**
     * save the high score untested
     * @param users
     * @return
     */
    public boolean saveHHighScore(ArrayList<User> users) {


        System.out.printf("Saving your score");

        try {

            String saveFile = input.nextLine();
            String verify, putData;
            File file = new File(saveFile);
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);
            bWriter.write((Integer.toString(users.get(users.size()).getHighScore())) + users.get(users.size()).getUserName());
            bWriter.flush();
            bWriter.close();
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);

            while ((verify = bReader.readLine()) != null) {
                if (verify != null) {
                    putData = verify.replaceAll("here", "there");
                    bWriter.write(putData);
                }
            }
            // use this to edit an existing file for the highscore

            bReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



        return true;
    }
}
