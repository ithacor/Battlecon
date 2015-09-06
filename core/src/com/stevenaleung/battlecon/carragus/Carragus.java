package com.stevenaleung.battlecon.carragus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.stevenaleung.battlecon.Character;

/**
 * Created by Steve on 9/6/2015.
 */
public class Carragus extends Character {

    public Carragus() {
        name = "Carragus";
        baseHP = 24;
        baseEnergy = 18;
        image = new Texture(Gdx.files.internal("bucket.png"));
    }

}
