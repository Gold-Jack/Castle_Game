package room;

public class Graveyard extends Room {

	private static String nameOfRoom = "墓地";
	private int numberOfTombs;
	private double getTreasure;


	public void showInfo() {
		super.showInfo();
		System.out.println("房间名称: " + nameOfRoom);
		System.out.println("坟堆数量: "+numberOfTombs);
		System.out.printf("能获得金币的概率: %.1f%%\n",getTreasure);
		System.out.println();
	}

	public String getNameOfRoom() {
		return nameOfRoom;
	}
	
}
