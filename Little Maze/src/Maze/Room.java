package Maze;

public class Room {
	
	private int x, y;
	private int a, b;
	private String name;
	private boolean block = false;
	
	public boolean check() {
		if(x >= 0 && x <= 8 && y >= 0 && y <= 8) return true;
		else return false;
	}
	
	public Room() {
		// TODO 自动生成的构造函数存根
	}

//	初始化
	public Room(String name, int x, int y) {
		this.name = name;
		this.x = x; 
		this.y = y;
	}
	
//	检查能否同通行
	public boolean isBlocked() {
		return block;
	}
	
//	设置障碍
	public void setBlock() {
		block = true;
	}
	
//	移动
	public String move(String direction) {
		a = x; b = y;
		if(direction.equals("ahead") && check()) {
			++ b;
		}
		if(direction.equals("back") && check()) {
			-- b;
		}
		if(direction.equals("left") && check()) {
			-- a;
		}
		if(direction.equals("right") && check()) {
			++ a;
		}
		String nextRoomName = "" + a + b;
//		System.out.println(nextRoomName);
//		System.out.println(this.block);
		if(nextRoomName.equals(this.name)) {
			System.out.println("");
			System.out.println("Illegal move (heart~) ");
			System.out.println("");
		}
		return nextRoomName; 
	}

	public boolean win() {
		if(name.equals("18")) {
			return true;
		}
		else return false;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
