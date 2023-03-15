package me.mythical83.engine;

public abstract class Engine {
	
	private Window window;
	private Game game;

	public Engine() {
		this.window = Window.getWindow();
		this.game = window.game;
		game.setEngine(this);
	}

	public abstract void update();

	public abstract void draw();

}
