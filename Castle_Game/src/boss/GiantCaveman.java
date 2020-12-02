package boss;

import skill.Punch;
import skill.Skill;
import skill.Yell;

import java.util.HashMap;
import java.util.HashSet;

public class GiantCaveman implements Boss {
    private final String nameOfBoss = "岩石巨人";
    private final String inRoom = "Cave";
    private double lifeLimit;
    private double curLife;
    private int goldBonus;
    private boolean isDead = false;

//    private HashMap<String, Skill> posSkills = new HashMap<>();       //主动技能：<名称，伤害(作用)数值>
//    private HashMap<String, Skill> negSkills = new HashMap<>();       //被动技能
    private HashMap<String, Skill> skills = new HashMap<>();
    private HashMap<String, Double> states = new HashMap<>();

    public GiantCaveman() {
        super();
        this.lifeLimit = 50;
        this.curLife = lifeLimit;
        this.goldBonus = 10;
        setSkills();
        setStates();
    }

    public String getNameOfBoss() {
        return nameOfBoss;
    }

    public void setStates() {
        states.put("attack", 0.0);
        states.put("defence", 0.0);
    }

    public void setSkills() {
        addSkill(new Punch());
        addSkill(new Yell());
    }

    public void addSkill(Skill skill) {
        skills.put(skill.getSkillName(), skill);
    }

    public double usePosSkill(String skill) {
        double damage = skills.get(skill).doDamage(nameOfBoss);
        return damage * states.get("attack");
    }

    public void useNegSkills(String skill) {
        double newState = skills.get(skill).doDefence(nameOfBoss) + states.get("defence");
        states.replace("defence", newState);
    }

    public int getKillBonus() {
        return goldBonus;
    }

    public void sufferDamage(double d) {
        curLife -= d;
        if(curLife <= 0) {
            curLife = 0;
            isDead = true;
            System.out.println("已击杀 "+nameOfBoss);
        }
    }

    public boolean isDead() {
        return isDead;
    }

    public HashMap<String, Double> getStates() {
        return states;
    }

    public void defenceDown() {
        double temp = states.get("defence");
        states.replace("defence", temp - 1 );
    }

    public void showStates() {
        System.out.println("----  Boss属性  ----");
        System.out.printf("血量:\t%d / %d\n",(int)curLife, (int)lifeLimit);
        System.out.printf("攻击力:\t%.1f\n", states.get("attack"));
        System.out.printf("防御力:\t%.1f\n", states.get("defence"));
    }
}
