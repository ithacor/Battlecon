package com.stevenaleung.battlecon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Battlecon extends Game {

	public SpriteBatch batch;
	public BitmapFont font;

	final float GAME_WIDTH = 800;
	final float GAME_HEIGHT = 480;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();			// important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
