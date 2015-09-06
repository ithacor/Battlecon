package com.stevenaleung.battlecon;

/**
 * Created by Steve on 9/5/2015.
 */
public class Player {

    private Character character;
    private int currentHP;
    private int maxHP;
    private int currentEnergy;
    private int maxEnergy;

//    public Player(Character character, int maxHP, int maxEnergy) {
//        this.character = character;
public Player(int maxHP, int maxEnergy) {
        this.maxHP = maxHP;
        this.maxEnergy = maxEnergy;
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

//    public void setCharacter(Character character) {
//        this.character = character;
//    }

}
