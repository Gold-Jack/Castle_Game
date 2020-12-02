package action;

import game.Game;

public interface Action {

    void doCmd(Game game);
    boolean isBye();

}
