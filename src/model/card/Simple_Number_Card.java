package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public class Simple_Number_Card extends Number_Card{

    public Simple_Number_Card(int value) {
        super(value, "simple");
    }

    /**
     * Move the pawn forward
     * @param pawn
     * pre-condition: pawn1 or pawn2 are not in start square , pawn1 or pawn2 can move forward 3 spaces
     * post-condition: pawn1 or pawn2 move value space forward
     */
    public int simple(Pawn pawn, Player player1, Player player2) {

        if(pawn.isStart()){
            pawn.setMoveable(false);
            return pawn.getPosition();
        }
        if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + getValue()) || teammate_is_home(pawn,player1,player2)){
            if(pawn.getPosition() + getValue() > 71)
                return pawn.getPosition() + getValue() - 72;
            if(Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() + getValue() > 2 && pawn.getPosition() + getValue() < 8)
                return pawn.getPosition() + getValue() + 6;
            if(Objects.equals(pawn.getColor(), "red") && pawn.getPosition() + getValue() > 38 && pawn.getPosition() + getValue() < 44)
                return pawn.getPosition() + getValue() + 6;
            if(pawnSkipsHome(pawn, player1, player2)) {
                pawn.setMoveable(false);
                return pawn.getPosition();
            }

            return pawn.getPosition() + getValue();
        }

        pawn.setMoveable(false);
        return pawn.getPosition();
    }

    private boolean teammate_is_home(Pawn pawn, Player player1, Player player2) {
        if(pawn.getColor().equals("red") && pawn.getId()==1)
            if(player1.getPawn2().getHome())
                return true;
        if(pawn.getColor().equals("red") && pawn.getId()==2)
            if(player1.getPawn1().getHome())
                return true;
        if(pawn.getColor().equals("yellow") && pawn.getId()==1)
            if(player2.getPawn2().getHome())
                return true;
        if(pawn.getColor().equals("yellow") && pawn.getId()==2)
            if(player2.getPawn1().getHome())
                return true;
        return false;
    }

    private boolean pawnSkipsHome(Pawn pawn, Player player1, Player player2) {
        if(Objects.equals(pawn.getColor(), "red"))
            if(pawn.getPosition()<player1.getHomePosition())
                if(pawn.getPosition() + getValue() > player1.getHomePosition())
                    return true;

        if(Objects.equals(pawn.getColor(), "yellow"))
            if(pawn.getPosition()<player2.getHomePosition())
                if(pawn.getPosition() + getValue() > player2.getHomePosition())
                    return true;
        return false;
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

