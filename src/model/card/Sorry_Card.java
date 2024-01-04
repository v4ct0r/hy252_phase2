package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public final class Sorry_Card  extends card
{
    public Sorry_Card() {
        super("sorry");
    }
    /**
     * Sorry card
     * @param pawn
     * @param player1
     * @param player2
     * post-condition: pawn is in the Start position
     * post-condition: pawn can move directly to a position occupied by the pawn of an opponent
     * and opponent's pawn is back to its own Start position
     */

     public int  sorry(Pawn pawn, Player player1, Player player2){
         pawn.setMoveable(false);
        if(pawn.isStart()){
            pawn.setMoveable(true);
        }

        if(check_enemys_pawn_are_safe(pawn, player1, player2)){
            pawn.setMoveable(false);
            return pawn.getPosition();
        }

        return pawn.getPosition();
     }

    private boolean check_enemys_pawn_are_safe(Pawn pawn, Player player1, Player player2) {
         //if both pawns are safe
        if(pawn.getColor().equals("red")){
            if(player2.getPawn1().isStart() && player2.getPawn2().isStart() && player2.getPawn1().isSafe() && player2.getPawn2().isSafe() && player2.getPawn1().getHome() && player2.getPawn2().getHome()){
                return true;
            }
        }else{
            if(player1.getPawn1().isStart() && player1.getPawn2().isStart() && player1.getPawn1().isSafe() && player1.getPawn2().isSafe() && player1.getPawn1().getHome() && player1.getPawn2().getHome()){
                return true;
            }
        }
        return false;
    }

}
