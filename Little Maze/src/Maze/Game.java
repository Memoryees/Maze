package Maze;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private Room currentRoom = new Room("11", 1, 1);              //出生点
	private HashMap<String, Room> roomLists = new HashMap<String, Room>();
	private HashMap<String, Handler> cmd = new HashMap<String, Handler>();
	private String[] blocks = {"21","22","31","41","51","61","62","73","74","75","15","25","35","34","44","43","54","66","56","47","37","27","68","78","87"};
	
	public Game() {
		//初始化地图
		for(int y = 1; y <= 8; y ++ ) {                  
			for(int x = 1; x <= 8; x ++ ) {
				String name = "" + x + y; 
				Room room = new Room(name, x, y);  
				roomLists.put(name, room);
			}
		}
		
		for(String roomName : blocks) {
			roomLists.get(roomName).setBlock();
		}
		
		cmd.put("go", new HandlerGo(this));
		cmd.put("help", new HandlerHelp(this));
		cmd.put("bye", new HandlerBye(this));
	}
	
	public String cmdName() {
		StringBuffer cmd = new StringBuffer();
		cmd.append("go ");
		cmd.append("help ");
		cmd.append("bye ");
		return cmd.toString();
	}
	
	public void move(String direction) {
		Room nextRoom = roomLists.get(currentRoom.move(direction));
		if(nextRoom.isBlocked()) {
			System.out.println("");
			System.out.println("This room is blocked, change your direction plz (wink~)");
		}
		else {
			currentRoom = nextRoom;
			System.out.println("");
			System.out.println("You're in " + currentRoom + " now");
			
		}
		System.out.print("You choose: ");
//		System.out.print(currentRoom);
	}
	
	public void welcome() {
		System.out.println("This is a little 8 * 8 maze");
		System.out.println("You're supposed to go to (1, 8)");
		System.out.println("Print help if you have problem");
		System.out.println("Good Luck");
		System.out.println("");
		System.out.println("You're in (1, 1) now");
		System.out.print("You choose: ");
	}
	
	public void play() {
		Scanner sc = new Scanner(System.in);
		
		while(!currentRoom.win()) {
			String line = sc.nextLine();
			String[] words = line.split("\\s+");
			String value = "";
			Handler handler = cmd.get(words[0]);
			if(words.length > 1) {
				value = words[1];
			}
			if(handler != null) {
				handler.doCmd(value);
				if(handler.isBye()) {
					break;
				}
			}
			else {
				System.out.println("Wrong instruction");
			}
		}
		
		sc.close();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.welcome();
		game.play();
	}

}
