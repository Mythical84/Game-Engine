package me.mythical83.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sprite {

	private BufferedImage image;

	public Sprite(String filepath) {
		File input = new File(filepath);

		try {
			this.image = ImageIO.read(input);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

	public void draw(JPanel window) {

	}
}
