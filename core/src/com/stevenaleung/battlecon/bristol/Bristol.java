package com.stevenaleung.battlecon.bristol;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.stevenaleung.battlecon.Character;

/**
 * Created by Steve on 9/5/2015.
 */
public class Bristol extends Character {

    public Bristol() {
        name = "Bristol";
        baseHP = 20;
        baseEnergy = 20;
        image = new Texture(Gdx.files.internal("droplet.png"));
        modifier1 = new BristolTango();
    }

}
