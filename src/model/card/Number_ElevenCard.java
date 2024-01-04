package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public class Number_ElevenCard extends Number_Card{

    public Number_ElevenCard() {
        super(11,"eleven");
    }
    /**
     * Move the pawn forward 11 spaces
     * @param pawn
     * @param player1
     * @param player2
     * pre-condition:be able to move 11 spaces forward
     * post-condition: pawn move 11 spaces forward
     */
    public int eleven(Pawn pawn , Player player1 , Player player2 ) {

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
                }else {
                    if(pawnSkipsHome(pawn, player1, player2)) {
                        pawn.setMoveable(false);
                        return pawn.getPosition();
                    }
                    return pawn.getPosition() + getValue() - 72;
                }
            }
            if(Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() + getValue() > 2 && pawn.getPosition() + getValue() <= 8)
                return pawn.getPosition() + getValue() + 6;
            if(Objects.equals(pawn.getColor(), "red") && pawn.getPosition() + getValue() > 38 && pawn.getPosition() + getValue() <= 44)
                return pawn.getPosition() + getValue() + 6;
            if(Objects.equals(pawn.getColor(), "red") && pawn.getPosition() <39 && pawn.getPosition() + getValue() > 44)
                return pawn.getPosition() + getValue() + 6;
            if(Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() <3 && pawn.getPosition() + getValue() > 8)
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

}

