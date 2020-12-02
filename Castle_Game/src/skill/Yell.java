package skill;

import java.util.HashMap;
import java.util.HashSet;

public class Yell implements Skill{
    private final String nameOfSkill = "Yell";
    private int useLimit = 5;      //技能使用次数上限
    private int usedTime = 0;       //技能已使用次数
    private final double damage = 0.0;              //技能造成的伤害值
    private final String function = "defence";
    private final double defenceFactor = 1.0;       //防御力提升（未实现）
    private final double sucPos = 0.9;

    //判断技能是否可以发动
    public boolean isUsable() {
        boolean isUsable = true;
        if (usedTime == useLimit) {
            System.out.println("技能使用次数已达上限，无法再次使用");
            isUsable = false;
        }
        if ( !isSucceed() ) {
            System.out.println("<"+ nameOfSkill +">" + " 技能发动失败");
            isUsable = false;
        }
        return isUsable;
    }

    //判断技能是否发动成功
    public boolean isSucceed() {
        boolean isSucceed = false;
        if( Math.random() <= sucPos) {
            isSucceed = true;
        }
        return isSucceed;
    }


    @Override
    public String getSkillName() {
        return nameOfSkill;
    }

    @Override
    public int getRemainedUseTime() {
        return useLimit - usedTime;
    }

    //防御性技能无伤害
    @Override
    public double doDamage(String nameOfUser) {
        return 0.0;
    }

    public String sadEmoji() {
        HashSet<String> emj = new HashSet<>();
        emj.add("摇了摇头");
        emj.add("摸了摸头");
        emj.add("叹了口气");
        emj.add("左右看了看");
        int choice = (int)(Math.random()*(emj.size()));
        return emj.toArray(new String[emj.size()])[choice];
    }

    //技能 “呐喊” 可以增加防御力
    @Override
    public double doDefence(String nameOfUser) {
        double effect = 0.0;
        if( !isUsable() ) {
            System.out.println(nameOfUser + " " + sadEmoji());
        }
        else {
            usedTime++;
            System.out.println(nameOfUser + " 使用了 <" + nameOfSkill + "> 技能");
            System.out.println(nameOfUser + " 的防御力增加了");
            effect += defenceFactor;
        }
        return effect;
    }
}
