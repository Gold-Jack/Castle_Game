package action;

import game.Game;

public class ActionInfo implements Action {

    @Override
    public void doCmd(Game game) {
        game.showInfo();
    }

    @Override
    public boolean isBye() {
        return false;
    }

}
