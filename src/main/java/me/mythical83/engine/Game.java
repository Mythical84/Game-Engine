package me.mythical83.engine;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import me.mythical83.engine.graphics.Sprite;

public class Game extends JPanel {
	private Window window;
	private Engine engine;
	private ArrayList <Sprite> sprites;

	public void start() {
		setSize(new Dimension(1080, 1920));
	}

	public void setup() {
		window = Window.getWindow();
		Thread gameLogic = new Thread(new GameLogic());
		gameLogic.start();
		sprites = new ArrayList<>();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1080, 1920);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = window.getWidth()/2;
		int height = window.getHeight()/2;

		g.setColor(Color.BLACK);
		g.fillOval(width, height, 30, 30);

		engine.draw();
		
		for (Sprite sprite : sprites) {
			g.drawImage(sprite.getImage(), sprite.x, sprite.y, this);
			//sprites.remove(sprite);
		}

	}

	public void addSprite(Sprite sprite) {
		sprites.add(sprite);
	}

	public int getSpriteSize() {
		return sprites.size();
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	private class GameLogic implements Runnable {

		@Override
		public void run() {
			Window window = Window.getWindow();
			long lastTime = System.nanoTime();
			final double ns = 1000000000.0 / 60.0;
			double delta = 0;
			while (true) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while (delta >= 1) {
					engine.update();
					window.game.repaint();
					delta--;
				}
			}
		}
	}
} 

