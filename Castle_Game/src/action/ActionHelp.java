package action;

import game.Game;

public class ActionHelp implements Action {

    @Override
    public void doCmd(Game game) {
        System.out.println("你可以使用命令：go  info  help  bye");
        System.out.println("如:\tgo east");
        System.out.println();
    }

    @Override
    public boolean isBye() {
        return false;
    }

}
