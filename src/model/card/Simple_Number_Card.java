package model.card;

import model.player.Pawn;

public class Simple_Number_Card extends Number_Card{

    public Simple_Number_Card(int value) {
        super(value, "simple");
    }

    /**
     * Move the pawn forward
     * @param pawn1
     * @param pawn2
     * pre-condition: pawn1 or pawn2 are not in start square , pawn1 or pawn2 can move forward 3 spaces
     * post-condition: pawn1 or pawn2 move value space forward
     */
    void moveForward3(Pawn pawn1, Pawn pawn2) {
        if (this.getValue()!=3) {
            try {
                throw new Exception("This card is not a 3 card");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // TODO
    }

    /**
     * Move the pawns forward
     * @param pawn1
     * @param pawn2
     *pre-condition: pawn1 and pawn2 are not in start square , pawn1 and pawn2 can move forward 5 spaces
     *post-condition: pawn1 and pawn2 move value space forward
     *pre-condition:if one of the pawns can't move forward 5 spaces
     * post-condition: the other pawn move forward 5 spaces
     */
    void moveForward5(Pawn pawn1, Pawn pawn2) {
        if (this.getValue()!=5) {
            try {
                throw new Exception("This card is not a 5 card");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // TODO
    }

    /**
     * Move the pawn forward
     * @param pawn
     * post-condition: pawn move 12 space forward(if possible) or draw again
     */

    void moveForward_or_draw_again12(Pawn pawn) {
        if (this.getValue()!=12) {
            try {
                throw new Exception("This card is not a 12 card");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // TODO
    }


}

