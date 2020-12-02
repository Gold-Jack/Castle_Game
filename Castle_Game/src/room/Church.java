package room;

import game.Game;

import java.util.HashMap;

public class Church extends Room {

	private static final String nameOfRoom = "大教堂";
	private String archbishop = "唐纳德";
	private int numberOfPrayers = 14;
	private boolean holdingCeremony = false;

	public boolean isHoldingCeremony() {
		HashMap<String, Integer> time = new Game().getCurTime();
		int hour = time.get("hour");
		int minute = time.get("minute");

		/*
		* 判断大教堂是否正在举办仪式
		* 目前设定每天 14:00 --- 17:30 举办仪式
		* 为实现: 特殊日期和一周七天的不同情况
		* */
		if(hour >= 14 && (hour <= 17 && minute<=30) )
			holdingCeremony = true;
		else
			holdingCeremony = false;
		return holdingCeremony;
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("房间名称: " + nameOfRoom);
		System.out.println("大主教: "+archbishop);
		System.out.println("当月祷告人数: "+numberOfPrayers);
		System.out.print("正在举行活动: ");
		if(isHoldingCeremony())
			System.out.println("是");
		else
			System.out.println("否");

		System.out.println();
	}

	public String getNameOfRoom() {
		return nameOfRoom;
	}
	
}
