package room;

import boss.Boss;
import boss.GiantCaveman;
import game.BattleField;
import mainCharacter.MainCharacter;

public class Cave extends Room {

	private static final String nameOfRoom = "山洞";
	private int suggestedEnterLevel = 1;
	private int gainExperience = 10;
	//为当前房间（山洞）生成Boss
	private Boss gc = new GiantCaveman();
	private boolean isEnter = false;

	//房间（山洞）中有Boss
	public boolean canBattle() {
		return true;
	}

	//进入战斗
	public void toBattle(MainCharacter mc) {
		System.out.println("在山洞中发现" + gc.getNameOfBoss());
		System.out.println();
//		gc.showStates();

		//创建战斗
		BattleField bf = new BattleField(mc, gc);
		bf.battle();
//		gc.usePosSkill("Punch");
//		gc.useNegSkills("Yell");
		System.out.println();

	}

	public void showInfo() {
		super.showInfo();
		System.out.println("房间名称: " + nameOfRoom);
		System.out.println("建议进入等级: "+suggestedEnterLevel);
		System.out.println("预计可获得经验: "+gainExperience);
		System.out.println();
	}

	public String getNameOfRoom() {
		return nameOfRoom;
	}

}
