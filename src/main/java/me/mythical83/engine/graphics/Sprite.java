package me.mythical83.engine.graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.mythical83.engine.Window;

public class Sprite {

	private Image image;
	private Window window;

	public int x;
	public int y;
	public int layer;

	public Sprite(String filepath) {
		window = Window.getWindow();

		layer = 0;

		File input = new File(filepath);

		try {
			this.image = ImageIO.read(input);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

	public void draw() {
		window.game.addSprite(this);
	}
	
	public Image getImage() {
		return this.image;
	}
}
