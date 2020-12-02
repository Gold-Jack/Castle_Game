package action;

import game.Game;

public class ActionBye implements Action {

    @Override
    public void doCmd(Game game) {

    }

    @Override
    public boolean isBye() {
        System.out.println("感谢您游玩此游戏, 再见 ");
        return true;
    }

}
