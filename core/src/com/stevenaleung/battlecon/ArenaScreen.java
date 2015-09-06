package com.stevenaleung.battlecon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.stevenaleung.battlecon.bristol.Bristol;
import com.stevenaleung.battlecon.carragus.Carragus;

/**
 * Created by Steve on 9/5/2015.
 */
public class ArenaScreen implements Screen {

    final Battlecon game;

    float numArenaSquares = 7;
    Texture squareImage;
    Array<Rectangle> squares;
    float squareSize;
    float columnSize;

    Sound dropSound;
    Music rainMusic;
    OrthographicCamera camera;
    Rectangle bucket;
    int dropsGathered;

    Player player1;
    Player player2;

    public ArenaScreen(final Battlecon game) {
        this.game = game;

        // create the camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.GAME_WIDTH, game.GAME_HEIGHT);

        // setup the arena
        squareImage = new Texture(Gdx.files.internal("square.png"));
        columnSize = game.GAME_WIDTH/(numArenaSquares+1);
        squareSize = 0.75f*columnSize;
        squares = new Array<Rectangle>();
        for (int i=0; i<7; i++) {
            Rectangle square = new Rectangle(columnSize*(i+1)-squareSize/2, (game.GAME_HEIGHT-squareSize)/2, squareSize, squareSize);
            squares.add(square);
        }

        // create mock players
        player1 = new Player(new Bristol(), 1);
        player2 = new Player(new Carragus(), 5);
    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        game.batch.begin();
        for (Rectangle square : squares) {
            game.batch.draw(squareImage, square.x, square.y, squareSize, squareSize);
        }
        game.font.draw(game.batch, "Player1", 10, 70);
        game.font.draw(game.batch, "HP: "+player1.getCurrentHP(), 10, 50);
        game.font.draw(game.batch, "Energy: " + player1.getCurrentEnergy(), 10, 30);
        game.batch.draw(player1.getCharacterImage(), columnSize*(player1.getPosition()+1)-squareSize/2, (game.GAME_HEIGHT-squareSize)/2, squareSize, squareSize);
        game.font.draw(game.batch, "Player2", 700, 70);
        game.font.draw(game.batch, "HP: "+player2.getCurrentHP(), 700, 50);
        game.font.draw(game.batch, "Energy: " + player2.getCurrentEnergy(), 700, 30);
        game.batch.draw(player2.getCharacterImage(), columnSize*(player2.getPosition()+1)-squareSize/2, (game.GAME_HEIGHT-squareSize)/2, squareSize, squareSize);
        game.batch.end();
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
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        dropSound.dispose();
        rainMusic.dispose();
    }


}
