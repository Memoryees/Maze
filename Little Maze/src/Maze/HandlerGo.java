package Maze;

public class HandlerGo extends Handler {
	public HandlerGo(Game game) {
		super(game);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void doCmd(String word) {
		game.move(word);
	}

	@Override
	public boolean isBye() {
		// TODO 自动生成的方法存根
		return false;
	}

}
