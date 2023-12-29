package model.card;

import model.player.Pawn;

public class Number_SevenCard extends Number_Card {

    public Number_SevenCard() {
        super(7, "seven");
    }

    /**
     * Move the pawn forward 7 spaces
     * @param pawn1
     * @param pawn2
     * pre-condition: pawn1 or pawn2 are not in start square , pawn1 or pawn2 can move forward 7 spaces in total
     * post-condition: pawn1 moves + pawn2 moves = 7
     */
    void seven(Pawn pawn1 , Pawn pawn2) {
        // TODO
    }

}
