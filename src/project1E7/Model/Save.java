package project1E7.Model;

import com.google.gson.Gson;

public class Save {
    public void saveGame(Room[][] room, Room currentRoom,Hero theHero, Controls controls, User user) {
        Gson gson = new Gson();
        String jsonHero = gson.toJson(theHero);
        String jsonMap = gson.toJson(room);
        String jsonControls = gson.toJson(controls);
        String jsonUser = gson.toJson(user);
        String jsonCurrentRoom = gson.toJson(currentRoom);
    }
}
