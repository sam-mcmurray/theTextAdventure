package project1E7.View;

import project1E7.Model.Room;

public class MapView {

    /**
     * prints the map
     *
     * @param room
     */
    public void mapPrinter(Room[][] room) {

        for (int i = 0; i < room.length; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                for (int j = 0; j < room[i].length; j++) {
                    if (!room[i][j].getBeenSeen()) {
                        if (i1 == 0) {
                            System.out.print("UN     -");
                        } else if (i1 == 1) {
                            System.out.print("   KNO  ");
                        } else {
                            System.out.print("-     WN");
                        }
                    } else if (room[i][j].getBeenSeen() && room[i][j].getDescription().equals("wall")) {
                        if (i1 == 0) {
                            System.out.print("¤¤¤¤¤¤¤¤");
                        } else if (i1 == 1) {
                            System.out.print("¤¤¤¤¤¤¤¤");
                        } else {
                            System.out.print("¤¤¤¤¤¤¤¤");
                        }
                    } else if (room[i][j].getBeenSeen() && room[i][j].getHasCharacter()) {
                        if (i1 == 0) {
                            System.out.print("   O    ");
                        } else if (i1 == 1) {
                            System.out.print("  |H|   ");
                        } else {
                            System.out.print("  | |   ");
                        }
                    } else if (room[i][j].getBeenSeen() && room[i][j].getIslocked()) {
                        if (i1 == 0) {
                            System.out.print("        ");
                        } else if (i1 == 1) {
                            System.out.print(" LOCKED ");
                        } else {
                            System.out.print("        ");
                        }
                    } else if (room[i][j].getBeenSeen()) {
                        if (i1 == 0) {
                            System.out.print("-      -");
                        } else if (i1 == 1) {
                            System.out.print("-      -");
                        } else {
                            System.out.print("-      -");
                        }
                    }
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }
}
