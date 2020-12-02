package room;

import game.Game;

import java.util.HashMap;

public class Forge extends Room {

	private static String nameOfRoom = "铁匠铺";
	private boolean isOpen = false;
	private HashMap<String, Double> goods = new HashMap<>();

	public Forge() {
		goods = getGoods();
	}

	public void isOpen() {
		HashMap<String, Integer> time = new Game().getCurTime();
		int hour = time.get("hour");
		int minute = time.get("minute");
		/*
		 * 判断铁匠铺是否开放
		 * 目前设定每天 9:00 --- 17:30 开放铁匠铺，允许交易
		 * 未实现: 特殊日期和一周七天的不同情况
		 * */
		if(hour >= 7 && (hour <= 16 && minute<=30) )
			isOpen = true;
	}

	public HashMap<String, Double> getGoods() {
		HashMap<String, Double> g = new HashMap<String, Double>();
		g.put("(服务)修理/抛光", 1.0);
		g.put("训练铁剑", 3.0);
		g.put("训练铁甲", 3.0);
		g.put("火把", 2.0);
		g.put("万能钥匙", 6.0);
		g.put("红柄戟", 9.5);
		return g;
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("房间名称: " + nameOfRoom);
		System.out.print("铁匠铺开放: ");
		isOpen();
		if(isOpen) {
			System.out.println("是");
			System.out.println("----  可交易商品  ----");
			for(String k : goods.keySet()) {
				System.out.printf("%6s\t$%.1f\n",k,goods.get(k));
			}
		}
		else {
			System.out.println("否");
			System.out.println("暂时无法买卖商品");
		}

		System.out.println();
	}

	public String getNameOfRoom() {
		return nameOfRoom;
	}
}
