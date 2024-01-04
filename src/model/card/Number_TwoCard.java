package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public class Number_TwoCard extends Number_Card {

    public Number_TwoCard() {
        super(2,"two");
    }

    /**
     * @param pawn
     * @param player1
     * @param player2

     */

    public int twobutwithoutmoving(Pawn pawn, Player player1, Player player2){
        pawn.setMoveable(true);
        if(pawn.getHome())
            pawn.setMoveable(false);
        if(pawn.getPosition() == player1.getStartPosition() && Objects.equals(pawn.getColor(), "red")){

            if(!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, player1.getNextafterstartPosition())){

                return player1.getNextafterstartPosition();
            }

        }else if(pawn.getPosition() == player2.getStartPosition() && Objects.equals(pawn.getColor(), "yellow")) {

            if(!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, player2.getNextafterstartPosition())){

                return player2.getNextafterstartPosition();
            }

        }else{

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
        }
        pawn.setMoveable(false);
        return pawn.getPosition();
    }


}