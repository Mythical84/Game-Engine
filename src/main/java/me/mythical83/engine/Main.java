package me.mythical83.engine;

import me.mythical83.engine.graphics.Sprite;
import java.io.File;

public class Main extends Engine {

	private Sprite sprite;

	public Main() {
		//System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());
		sprite = new Sprite("./images/unknown.png");
	}

	@Override
	public void update() {
	}

	@Override
	public void draw() {
		sprite.draw();
	}

	public static void main(String[] args) {
		new Main();
	}

}
