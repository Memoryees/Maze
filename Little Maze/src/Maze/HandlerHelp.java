package Maze;

public class HandlerHelp extends Handler {

	@Override
	public boolean isBye() {
		// TODO 自动生成的方法存根
		return false;
	}

	public HandlerHelp(Game game) {
		super(game);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void doCmd(String word) {
		System.out.println("");
		System.out.println("These are aviliable instructions: " + game.cmdName());
		System.out.println("go :");
		System.out.println("You can print go + ahead/back/left/right to move");
		System.out.println("e.g. go ahead");
		System.out.println("");
		System.out.println("help :");
		System.out.println("You can print help anytime to see this again");
		System.out.println("");
		System.out.println("bye :");
		System.out.println("You use this instruction to quit this game before you reach (1, 8)");
		System.out.println("");
		System.out.print("You choose: ");
	}

}
