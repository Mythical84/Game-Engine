package me.mythical83.engine;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class Window extends JFrame{
	private static Window window;
	public Game game;

	private Window() {
		game = new Game();
	
		this.setSize(new Dimension(1080, 1920));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setEnabled(true);
		this.setTitle("2D RPG");
		this.setMaximumSize(new Dimension(1080, 1920));
		this.setLayout(new BorderLayout());
		this.add(game);
		this.setLocationRelativeTo(null);

	}

	public static Window getWindow() {
		if (window == null) {
			window = new Window();
		}

		return window;
	}

	
}
