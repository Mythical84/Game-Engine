package me.mythical83.engine;

import me.mythical83.engine.graphics.Sprite;

public class Player {

	private Player player;
	private Sprite sprite;

	private Player() {

	}

	public Player getPlayer() {
		if (player == null) {
			player = new Player();
		}

		return player;
	}

}
