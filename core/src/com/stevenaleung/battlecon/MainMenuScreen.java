package com.stevenaleung.battlecon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Steve on 9/5/2015.
 */
public class MainMenuScreen implements Screen {

    final Battlecon game;
    OrthographicCamera camera;

    GlyphLayout header;
    GlyphLayout instructions;

    Texture dropImage;
    Texture bucketImage;
    Rectangle raindrop;
    Rectangle bucket;

    Vector3 touchPos = new Vector3(0,0,0);

    public MainMenuScreen(final Battlecon game) {
        this.game = game;
        // setup the camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.GAME_WIDTH, game.GAME_HEIGHT);
        // create main menu text
        header = new GlyphLayout();
        String headerText = "WELCOME TO BATTLECON";
        header.setText(game.font, headerText);
        // create instructions text
        instructions = new GlyphLayout();
        String instructionsText = "Choose your character";
        instructions.setText(game.font, instructionsText);
        // load the character images
        dropImage = new Texture(Gdx.files.internal("droplet.png"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
        // setup the character panes
        bucket = new Rectangle();
        bucket.x = game.GAME_WIDTH / 2 - 64 * 2; // center the bucket horizontally
        bucket.y = 20;
        bucket.width = 100;
        bucket.height = 100;
        raindrop = new Rectangle();
        raindrop.x = game.GAME_WIDTH / 2 + 64 * 2; // center the bucket horizontally
        raindrop.y = 20;
    }

    @Override
    public void render(float delta) {
        // make a black clear screen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // update the camera matrix
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        // draw objects
        game.batch.begin();
        game.font.draw(game.batch, header, (game.GAME_WIDTH - header.width) / 2, 0.9f * game.GAME_HEIGHT);
        game.font.draw(game.batch, instructions, (game.GAME_WIDTH - instructions.width) / 2, 0.7f * game.GAME_HEIGHT);
        game.font.draw(game.batch, "x:"+touchPos.x+" y:"+touchPos.y, 100, 100);
        game.font.draw(game.batch, "x:"+bucket.x+" y:"+bucket.y, 100, 150);
        game.font.draw(game.batch, "contains: "+bucket.contains(touchPos.x, touchPos.y), 100, 80);
        game.batch.draw(bucketImage, bucket.x, bucket.y);
        game.batch.draw(dropImage, raindrop.x, raindrop.y);
        game.batch.end();
        // start game once a character is chosen
        if (Gdx.input.isTouched()) {
            touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (bucket.contains(touchPos.x, touchPos.y)) {
                game.setScreen(new ArenaScreen(game));
                dispose();
            }
        }

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void dispose() {
    }

}
