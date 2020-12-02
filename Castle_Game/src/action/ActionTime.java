package action;

import game.Game;

import java.util.HashMap;

public class ActionTime implements Action {

    public void doCmd(Game game) {
        HashMap<String, Integer> time = game.getCurTime();
        int hour = time.get("hour");
        int minute = time.get("minute");
        int second = time.get("second");
        System.out.printf("当前时间: %02d:%02d:%02d\n", hour, minute, second);
    }

    @Override
    public boolean isBye() {
        return false;
    }

}
