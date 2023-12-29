package model.card;

import model.player.Pawn;

public class Number_OneCard extends Number_Card{
    public Number_OneCard() {
        super(1, "one");
    }

    /**
     * Move the pawn one space forward
     * @param pawn
     * pre-condition:if(pawn1.getPosition() == pawn1.homeSquare || pawn2.getPosition() == pawn1.homeSquare)
     * post-condition:pawn1 or pawn2 can get out of start square
     * else
     * post-condition:pawn1 or pawn2 can move one space forward
     */
    private void one(Pawn pawn) {
        // TODO
    }


}