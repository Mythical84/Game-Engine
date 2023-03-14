package me.mythical83.engine;

import me.mythical83.engine.graphics.Sprite;

public class Main {
	public static void main(String[] args) {
		Window window = Window.getWindow();
		window.setVisible(true);
		window.game.setWindow();
		Sprite sprite = new Sprite("/home/tyler/Backgrounds/unknown.PNG");
		sprite.draw();
	}
}
