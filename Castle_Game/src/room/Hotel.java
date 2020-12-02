package room;

import java.util.HashMap;

public class Hotel extends Room {

	private final String nameOfRoom = "旅馆";
	private int totalRooms;
	private int occupiedRooms = 0;
	private boolean gotVacancy;
	private HashMap<String , Double> services = new HashMap<>();

	public Hotel() {
		this.totalRooms = 5;
		this.gotVacancy = isFull();
		setService();
	}

	public boolean isFull() {
		return totalRooms == occupiedRooms;
	}
	
	public void setService() {
		services.put("普通住宿", 10.0);
		services.put("豪华住宿", 30.0);
	}

	public void showServices() {
		for(String k : services.keySet()) {
			System.out.printf("%6s\t$%.1f\n",k,services.get(k));
		}
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("房间名称: " + nameOfRoom);
		System.out.println("空余房间数: "+(totalRooms-occupiedRooms));
		System.out.println("----  可选择服务  ----");
		showServices();
		System.out.println();
	}

	public String getNameOfRoom() {
		return nameOfRoom;
	}

}
