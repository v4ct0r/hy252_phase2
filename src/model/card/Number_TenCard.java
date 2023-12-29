package model.card;

import model.player.Pawn;

public class Number_TenCard extends Number_Card{
    public Number_TenCard() {
        super(10,"ten");
    }


    /**
     * Move the pawn forward 10 spaces
     * @param pawn1
     * @param pawn2
     * pre-condition: pawn1 or pawn2 are not in start square , pawn1 or pawn2 can move forward 10 spaces
     * post-condition: pawn1 or pawn2 move 10 space forward
     * pre-condition:if none of a player's pawns can be moved 10 places forward
     * post-condition: a pawn must necessarily be moved one place backwards
     */
    void ten(Pawn pawn1 , Pawn pawn2) {
        // TODO
    }

}
