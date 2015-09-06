package com.stevenaleung.battlecon;

/**
 * Created by Steve on 9/5/2015.
 */
public class Modifier {

    public String name;
    public int speed;
    public int range;
    public int damage;

    public String onRevealText;
    public String beforeTurnText;
    public String onStrikeText;
    public String onDamageText;
    public String afterTurnText;

    public void onReveal(Player player1, Player player2) {}
    public void beforeTurn(Player player1, Player player2) {}
    public void onStrike(Player player1, Player player2) {}
    public void onDamage(Player player1, Player player2) {}
    public void afterTurn(Player player1, Player player2) {}

}
