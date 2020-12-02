package room;

public class Castle extends Room {
	/*
	* 主城，一般为出生（重生点）
	* */
	private static final String nameOfRoom = "主城";
	private String nameOfRuler = "乔治十三世";
	private int defenceLevel = 9;
	private int population = 1000;

	public void showInfo() {
		super.showInfo();
		System.out.println("房间名称: " + nameOfRoom);
		System.out.println("目前人口: "+population);
		System.out.println("防御能力(0-9): "+defenceLevel);
		System.out.println("当前领导者: "+nameOfRuler);
		System.out.println();
	}

	public String getNameOfRoom() {
		return nameOfRoom;
	}
	
}
