package com.stevenaleung.battlecon.bristol;

import com.stevenaleung.battlecon.Modifier;
import com.stevenaleung.battlecon.Player;

/**
 * Created by Steve on 9/6/2015.
 */
public class BristolTango extends Modifier {

    public BristolTango() {
        name = "Tango";
        speed = 5;
        range = 1;
        damage = 2;
    }

    @Override
    public void onReveal(Player player1, Player player2) {
        player1.advance(player2, 1);
        player2.advance(player1, 1);
    }
    public void beforeTurn(Player player1, Player player2) {}
    public void onStrike(Player player1, Player player2) {}
    public void onDamage(Player player1, Player player2) {}
    public void afterTurn(Player player1, Player player2) {}

}
