package Maze;

public abstract class Handler {

	protected Game game;
	
	public Handler(Game game) {
		// TODO 自动生成的构造函数存根
		this.game = game;
	}
	public abstract void doCmd(String word);
	public abstract boolean isBye();
}
