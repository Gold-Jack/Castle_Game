package game;

import boss.Boss;
import mainCharacter.MainCharacter;

public class BattleField {
    private final MainCharacter mc;
    private final Boss boss;
    private int numOfRound = 0;

    public BattleField(MainCharacter mc, Boss boss) {
        this.mc = mc;
        this.boss = boss;
    }

    public void callDelay(int delay) {
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void battle() {
        while( true ) {
            numOfRound++;
            System.out.println("回合 " + numOfRound + ":");
            double mcDamage = mc.usePosSkill("Slash");
            mcDamage -= boss.getStates().get("defence");
            if(mcDamage <= 0)
                mcDamage = 0;
            else {
                System.out.println(" 造成了 " + mcDamage + " 伤害");
            }
            boss.sufferDamage(mcDamage);
            callDelay(1);
            if(boss.isDead()) {
                mc.getBonus(boss.getKillBonus());
                break;
            }

            if ( Math.random() >= 0.5) {
                boss.useNegSkills("Yell");
            }
            else {
                if( boss.getStates().get("defence") > 0)
                    boss.defenceDown();
                double bossDamage = boss.usePosSkill("Punch");
                mc.sufferDamage(bossDamage);
            }
            callDelay(1);
            if (mc.isDead()) {
                break;
            }
            System.out.println();
        }
    }

}
