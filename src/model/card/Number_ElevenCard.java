package model.card;

import model.player.Pawn;

public class Number_ElevenCard extends Number_Card{

    public Number_ElevenCard() {
        super(11,"eleven");
    }
    /**
     * Move the pawn forward 11 spaces
     * @param pawn1
     * @param pawn2
     * pre-condition: pawn1 or pawn2 are not in start square , pawn1 or pawn2 can move forward 11 spaces or can swap the position of one of your pawns with one of your opponent's pawns
     * post-condition: pawn1 or pawn2 move 11 space forward or not necessarily exchange one of your pawns for one of your opponent's
     * pre-condition:if none of a player's pawns can be moved 11 places forward
     * post-condition: the player chooses to press fold and the other player plays
     */
    void eleven(Pawn pawn1 , Pawn pawn2) {
        // TODO
    }
}

