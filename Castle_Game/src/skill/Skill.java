package skill;

import java.util.HashMap;

public interface Skill {

    String getSkillName();              //获得技能名称
    int getRemainedUseTime();           //获得技能剩余使用次数
    double doDamage(String nameOfUser); //技能造成伤害
    double doDefence(String nameOfUser);       //技能增益
//    double getSucceedPos();

}
