package mainCharacter;

import skill.Skill;
import skill.Slash;

import java.util.HashMap;

public class MainCharacter {
    private String nameOfCharacter = "Jack";
    private double lifeLimit;
    private double curLife;
    private int numOfGolds;
    private boolean isDead = false;

    private HashMap<String, Skill> skills = new HashMap<String, Skill>();

    public MainCharacter() {
        this.lifeLimit = 100;
        this.curLife = lifeLimit;
        this.numOfGolds = 0;
        setSkills();
    }

    public String getNameOfCharacter() {
        return nameOfCharacter;
    }

    public void getBonus(int newGold) {
        System.out.println("获得 " + newGold + " 枚金币");
        numOfGolds += newGold;
    }

    public void setSkills() {
        skills.put("Slash", new Slash());
    }

    public double usePosSkill(String skill) {
        double damage = skills.get(skill).doDamage(nameOfCharacter);
        return damage;
    }

    public int getNumOfGolds() {
        return numOfGolds;
    }

    public void sufferDamage(double d) {
        curLife -= d;
        if(curLife <= 0) {
            curLife = 0;
            System.out.println("你已死亡");
            isDead = true;
        }
    }

    public boolean isDead() {
        return isDead;
    }
}
