package com.stevenaleung.battlecon;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Steve on 9/5/2015.
 */
public class Player {

    private String characterName;
    private int currentHP;
    private int maxHP;
    private int currentEnergy;
    private int maxEnergy;
    private int position;

    private Texture characterImage;

    public int turnOrder;
    public int damageTakenThisTurn;
    public int damageBlockedThisTurn;
    public int damageOverTime;
    public int slowAmount;

    public Player(Character character, int position) {
        characterName = character.name;
        maxHP = character.baseHP;
        maxEnergy = character.baseEnergy;
        characterImage = character.image;
        this.position = position;

        currentHP = maxHP;
        currentEnergy = maxEnergy;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getPosition() {
        return position;
    }

    public Texture getCharacterImage() {
        return characterImage;
    }

    public void move(int spaces) {
        position = position + spaces;
    }

    public void advance(Player enemy, int spaces) {
        int enemyPosition = enemy.getPosition();
        if (enemyPosition>position) {
            move(spaces);
        } else {
            move(-spaces);
        }
    }
    
    public void retreat(Player enemy, int spaces) {
        int enemyPosition = enemy.getPosition();
        if (enemyPosition>position) {
            move(-spaces);
        } else {
            move(spaces);
        }
    }

    public void moveEnemy(Player enemy, int spaces) {
        enemy.move(spaces);
    }

}
