package me.mythical83.engine;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import me.mythical83.engine.graphics.Sprite;

public class Game extends JPanel {
	private Engine engine;
	private Player player;
	private ArrayList <Sprite> sprites;

	public Game() {
		sprites = new ArrayList<>();
	}

	public void setup() {
		Thread gameLogic = new Thread(new GameLogic());
		gameLogic.start();
		setSize(new Dimension(1080, 1920));
		player = Player.getPlayer();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1080, 1920);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Sprite sprite : sprites) {
			g.drawImage(sprite.getImage(), sprite.x, sprite.y, this);
		}

		sprites = new ArrayList<>();

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
			KeyHandler key = new KeyHandler();
			addKeyListener(key);
			long lastTime = System.nanoTime();
			final double ns = 1000000000.0 / 60.0;
			double delta = 0;
			while (true) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while (delta >= 1) {
					engine.update();
					engine.draw();
					window.game.repaint();
					delta--;
				}
			}
		}
	}

	private class KeyHandler implements KeyListener {

		public boolean w = false;
		public boolean s = false;
		public boolean a = false;
		public boolean d = false;

		public KeyHandler() {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			char key = e.getKeyChar();
			if (key == 'w') {
				w = false;
			} else if (key == 's') {
				s = false;
			} else if (key == 'a') {
				a = false;
			} else if (key == 'd') {
				d = false;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {  }

		@Override
		public void keyPressed(KeyEvent e) {
			char key = e.getKeyChar();
			if (key == 'w') {
				w = true;
			} else if (key == 's') {
				s = true;
			} else if (key == 'a') {
				a = true;
			} else if (key == 'd') {
				d = true;
			}
		}

		public ArrayList<Boolean> getKeys() {

			ArrayList<Boolean> list = new ArrayList<>();

			list.add(w);
			list.add(s);
			list.add(d);
			list.add(a);
				
			return list;
		}
	}

} 

