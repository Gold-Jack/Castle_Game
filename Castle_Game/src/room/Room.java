package room;

import mainCharacter.MainCharacter;

import java.util.ArrayList;

public class Room {

    private final ArrayList<String> exits = new ArrayList<>();
    private Room northExit;
    private Room southExit;
    private Room westExit;
    private Room eastExit;

    public boolean canBattle() {
        return false;
    }

    public void showInfo() {
        System.out.println("****   房间信息   ****");
    }

    public void setExits(Room north, Room south, Room west, Room east) {
        if(north != null) {
            this.northExit = north;
            exits.add("north");
        }
        if(south != null) {
            this.southExit = south;
            exits.add("south");
        }
        if(west != null) {
            this.westExit = west;
            exits.add("west");
        }
        if(east != null) {
            this.eastExit = east;
            exits.add("east");
        }
    }

    public String[] getExits() {
        return exits.toArray(new String[0]);
    }

    public Room toExit(String dir) {
        Room TOGO = new Room();
        if(exits.contains(dir)) {
            switch (dir) {
                case "north":
                    TOGO = this.northExit;
                    break;
                case "south":
                    TOGO = this.southExit;
                    break;
                case "west":
                    TOGO = this.westExit;
                    break;
                case "east":
                    TOGO = this.eastExit;
                    break;
            }
        }
        else {
            TOGO = this;
        }
        return TOGO;
    }


    public String getNameOfRoom(){
        return null;
    }

    public void toBattle(MainCharacter mc) {}

}