package me.mythical83.engine;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import me.mythical83.engine.graphics.Sprite;

public class Game extends JPanel {
	private Window window;
	private ArrayList <Sprite> sprites;
	private GameLogic game;

	public Game() {
		game = new GameLogic();
		Thread gameLogic = new Thread(game);
		gameLogic.start();
		sprites = new ArrayList<>();
	}

	public void start() {
		setSize(new Dimension(1080, 1920));
	}

	public void setWindow() {
		window = Window.getWindow();
		game.setWindow();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1080, 1920);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		System.out.println(sprites.size());

		int width = window.getWidth()/2;
		int height = window.getHeight()/2;

		g.setColor(Color.BLACK);
		g.fillOval(width, height, 30, 30);
		
		for (Sprite sprite : sprites) {
			g.drawImage(sprite.getImage(), sprite.x, sprite.y, this);
			sprites.remove(sprite);
		}

	}

	public void addSprite(Sprite sprite) {
		System.out.println("test");
		sprites.add(sprite);
	}

	public int getSpriteSize() {
		return sprites.size();
	}

	private class GameLogic implements Runnable {

		private Window window;
		private boolean printWindow = true;
		private int spritesSize = 0;

		@Override
		public void run() {
			while (true) {
				System.out.println(window);
				if (window == null) continue;
				if (this.spritesSize != window.game.getSpriteSize()) {
					window.game.repaint();
				}
			}
		}

		public void setWindow() {
			this.window = Window.getWindow();
		}
	}
} 

