package skill;

import java.util.HashMap;
import java.util.HashSet;

public class Punch implements Skill{
    private final String nameOfSkill = "Punch";
    private int useLimit = 30;      //技能使用次数上限
    private int usedTime = 0;       //技能已使用次数
    private final double damage = 3.0;              //技能造成的伤害值
    private final double defencefactor = 1.0;       //防御力提升（未实现）
    private final double sucPos = 0.6;

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

    //发动技能失败时的表情
    public String sadEmoji() {
        HashSet<String> emj = new HashSet<>();
        emj.add("摇了摇头");
        emj.add("摸了摸头");
        emj.add("叹了口气");
        emj.add("左右看了看");
        int choice = (int)(Math.random()*(emj.size()));
        return emj.toArray(new String[emj.size()])[choice];
    }

    //主动技能---伤害技
    @Override
    public double doDamage(String nameOfUser) {
        if( !isUsable() ) {
            System.out.println(nameOfUser + " " + sadEmoji());
            return 0;
        }
        else {
            usedTime++;
            System.out.print(nameOfUser + " 使用了 <" + nameOfSkill + "> 技能");
            System.out.println(" 造成了 " + damage + " 伤害");
        }
        return damage;
    }

    //功击技能无增益效果
    @Override
    public double doDefence(String nameOfUser) {
//        HashMap<String, Double> effect = new HashMap<>();
//        effect.put("defence", 1.0);
        return 1.0;
    }
}
