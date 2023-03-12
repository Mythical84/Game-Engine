package me.mythical83.engine;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Game extends JPanel {
	private Window window;

	public Game() {
		Thread gameLogic = new Thread(new GameLogic());
		gameLogic.start();
	}

	public void start() {
		setSize(new Dimension(1080, 1920));
	}

	public void setWindow() {
		window = Window.getWindow();
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
	}

	private class GameLogic implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("Hello, World");
			}
		}
	}
} 

