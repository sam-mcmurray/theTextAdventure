package project1E7.View;


import project1E7.Model.Room;

import java.util.Random;

public class RoomView {
    Room model;

    public RoomView(Room model) {
        this.model = model;
    }

    /**
     * flavor text for description of room
     */
    public void flavorTextRoom(Room currentRoom) {
        System.out.println(currentRoom.getDescription());
    }

    /**
     * does doors for the rooms
     *
     * @param room
     * @param currentRoom
     */
    public void roomDoors(Room[][] room, Room currentRoom) {
        boolean run;

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                    if (currentRoom == room[i][j]) {
                        j = (j - 1);
                        if (room[i][j].getDescription().equalsIgnoreCase("wall")) {
                            System.out.println("You have a wall to the West.");
                        } else if (room[i][j].getDoor() == null) {
                            System.out.println("There is an unlocked door to the West.");
                        } else {
                            System.out.println("There is a door to the West. " + room[i][j].getDoor().getDescription());
                        }
                        j = (j + 1);
                        j = (j + 1);
                        if (room[i][j].getDescription().equalsIgnoreCase("wall")) {
                            System.out.println("You have a wall to the East.");
                        } else if (room[i][j].getDoor() == null) {
                            System.out.println("There is an unlocked door to the East.");
                        } else {
                            System.out.println("There is a door to the East. " + room[i][j].getDoor().getDescription());
                        }
                        j = (j - 1);
                        i = (i + 1);
                        if (room[i][j].getDescription().equalsIgnoreCase("wall")) {
                            System.out.println("You have a wall to the South.");
                        } else if (room[i][j].getDoor() == null) {
                            System.out.println("There is an unlocked door to the South.");
                        } else {
                            System.out.println("There is a door to the South. " + room[i][j].getDoor().getDescription());
                        }
                        i = (i - 1);
                        i = (i - 1);
                        if (room[i][j].getDescription().equalsIgnoreCase("wall")) {
                            System.out.println("You have a wall to the North.");
                        } else if (room[i][j].getDoor() == null) {
                            System.out.println("There is an unlocked door to the North.");
                        } else {
                            System.out.println("There is a door to the North. " + room[i][j].getDoor().getDescription());
                        }
                        i = (i + 1);
                    }
                }
            }
        }
    }
