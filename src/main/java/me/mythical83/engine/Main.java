package me.mythical83.engine;

import me.mythical83.engine.graphics.Sprite;

public class Main extends Engine {

	public Main() {
		//System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());
	}

	@Override
	public void update() {

	}

	@Override
	public void draw() {
		Sprite sprite = new Sprite("./images/unknown.png");
		sprite.x = 50;
		sprite.y = 50;
		sprite.draw();
	}

	public static void main(String[] args) {
		new Main();
	}

}
