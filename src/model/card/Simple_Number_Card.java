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

        if(pawn.isStart() || pawn.getHome()){
            pawn.setMoveable(false);
            return pawn.getPosition();
        }
        if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + getValue()) || teammate_is_home(pawn,player1,player2)){
           pawn.setMoveable(true);
            if(pawn.getPosition() + getValue() > 71){
                if(Objects.equals(pawn.getColor(), "yellow")) {
                    if (pawn.getPosition() + getValue() - 72 < 3)
                        return pawn.getPosition() + getValue() - 72;
                    else
                        return pawn.getPosition() + getValue() - 72 + 6;
                }else
                    return pawn.getPosition() + getValue() - 72;
            }
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
        //body blocked by teammate
        pawn.setMoveable(false);
        return pawn.getPosition();
    }




}

