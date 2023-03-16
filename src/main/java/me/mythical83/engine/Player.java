package me.mythical83.engine;

import java.util.ArrayList;

import me.mythical83.engine.graphics.Sprite;

public class Player {

	private static Player player;
	public Sprite sprite;

	private double dx;
	private double dy;
	private double denominator;

	private Player() {  }

	public static Player getPlayer() {
		if (player == null) {
			player = new Player();
		}

		return player;
	}

	public void move(ArrayList<Boolean> keys) {
		dy = keys.get(0) ? -1 : 1;
		dx = keys.get(2) ? 1 : -1;

		denominator = Math.sqrt((dx*dx) + (dy*dy));
		dy /= denominator;
		dx /= denominator;

		System.out.println(dy);
		System.out.println(dx);
		System.out.println("----");
	}

}
