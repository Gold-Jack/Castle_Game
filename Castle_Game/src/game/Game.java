package game;

import mainCharacter.MainCharacter;
import room.*;
import time.Time;
import action.*;

import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private final Room Castle = new Castle();
    private final Room Cave = new Cave();
    private final Room Church = new Church();
    private final Room Dock = new Dock();
    private final Room Forge = new Forge();
    private final Room Graveyard = new Graveyard();
    private final Room Hotel = new Hotel();

    private static final Time time = new Time();
    private final HashMap<String, Action> actions = new HashMap<>();
    private String action = "";
    private Room curRoom;
    private final MainCharacter jack = new MainCharacter();

    public Game() {
        createRooms();
        actions.put("bye", new ActionBye());
        actions.put("help", new ActionHelp());
        actions.put("go", new ActionGo());
        actions.put("info", new ActionInfo());
        actions.put("time", new ActionTime());
        setCurRoom(Castle);
    }

    public void createRooms() {
        Castle.setExits(Forge, Church, Dock, Hotel);
        Cave.setExits(null, null, Hotel, null);
        Church.setExits(Castle, Graveyard, null, null);
        Dock.setExits(null, null, null, Castle);
        Forge.setExits(null, Castle, null, null);
        Graveyard.setExits(Church, null, null, null);
        Hotel.setExits(null, null, Castle, Cave);
    }

    public Room getCurRoom() {
        return curRoom;
    }
    public void setCurRoom(Room room) {
        curRoom = room;
    }

    public String getCurAction() {
        return action;
    }

    public HashMap<String, Integer> getCurTime() {
        return time.getCurTime();
    }

    public String[] getExits() {
        return curRoom.getExits();
    }

    public void welcome(){
        System.out.println("****   欢迎来到城堡游戏   ****");
        showPrompt();
        System.out.println("操作详见  'help' ");
    }

    public void showPrompt(){
        System.out.println("你现在位于："+curRoom.getNameOfRoom());
        if( curRoom.canBattle() ) {
            toBattle();
        }
        System.out.print("你可以往");
        String[] dirs = getExits();
        for (String dir : dirs) {
            System.out.print("  " + dir);
        }
        System.out.println("  走...");
    }

    public void toBattle(){
        if( goIntoTheRoom() ) {
            System.out.println("你进入了 " + curRoom.getNameOfRoom());
            curRoom.toBattle(jack);
        }
        else {
            System.out.println("你退回到 " + curRoom.getNameOfRoom() + " 的门口");
        }
//        if ( jack.isDead() ) {
//
//        }
    }



    public boolean goIntoTheRoom() {
        Scanner in = new Scanner(System.in);
        String t = "";
        if(curRoom.equals(Cave)) {
            System.out.println("要进入吗? ( yes  no )");
            t = in.next();
        }
        return t.equals("yes");
    }

    public void showInfo() {
        curRoom.showInfo();
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        welcome();

        while(true) {
            String userInput = in.nextLine();
            String[] move = userInput.split(" ");
            Action handler = actions.get(move[0]);

            if(move.length > 1) {
                action = move[1];
                time.tick();
            }
            if(handler != null) {
                handler.doCmd(this);
                if(handler.isBye())
                    break;
            }
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }

}