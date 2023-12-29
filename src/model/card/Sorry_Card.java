package model.card;

import model.player.Pawn;

public final class Sorry_Card  extends card
{
    public Sorry_Card() {
        super("sorry");
    }
    /**
     * Sorry card
     * @param pawn
     * post-condition: pawn is in the Start position
     * post-condition: pawn can move directly to a position occupied by the pawn of an opponent
     * and opponent's pawn is back to its own Start position
     */

    void sorry(Pawn pawn) {
        // TODO
    }

}
