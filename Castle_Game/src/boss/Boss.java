package boss;

import java.util.HashMap;

public interface Boss {

    String getNameOfBoss();
    double usePosSkill(String skill);       //使用主动技能（与Skill接口交互）
    void useNegSkills(String skill);        //使用被动技能（未实现）
    int getKillBonus();                     //获取击杀Boss的奖励
    void sufferDamage(double d);            //Boss受到伤害
    HashMap<String, Double> getStates();    //获取Boss的各项属性
    void showStates();                      //打印Boss的各项属性
    boolean isDead();                       //判断Boss是否死亡
    void defenceDown();
}
