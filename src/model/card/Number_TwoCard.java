package model.card;

import model.player.Pawn;

public class Number_TwoCard extends Number_Card {

    public Number_TwoCard() {
        super(2,"two");
    }

    /**
     * @param pawn
     * pre-condition: pawn is in start square
     * post-condition: pawn can get out of start square and play again
     * pre-condition: pawn is not in start square
     * post-condition: pawn can move two space forward and play again
     */
    boolean two(Pawn pawn) {
        // TODO
        return false;
    }

}