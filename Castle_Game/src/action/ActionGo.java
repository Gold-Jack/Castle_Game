package action;

import game.Game;
import room.Room;

public class ActionGo implements Action {

    @Override
    public void doCmd(Game game) {
        Room change = game.getCurRoom().toExit(game.getCurAction());
        if(change.equals(game.getCurRoom())) {
            System.out.println("无效的方向，请重新输入: ");
        }
        else {
            game.setCurRoom(change);
            game.showPrompt();
        }

    }

    @Override
    public boolean isBye() {
        return false;
    }

}
