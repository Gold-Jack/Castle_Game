package room;

import java.util.HashMap;

public class Dock extends Room {

	private static String nameOfRoom = "港口";
	private int numberOfShips;
	private HashMap<String, Double> mission = new HashMap<String, Double>();

	public void getMission() {
		return ;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("房间名称: " + nameOfRoom);
		System.out.println("码头内现有船只: "+numberOfShips);
		for(String k : mission.keySet()) {
			System.out.printf("%6s\t$%.1f\n",k,mission.get(k));
		}
		System.out.println();
	}

	public String getNameOfRoom() {
		return nameOfRoom;
	}

}
