package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

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
    public void one(Pawn pawn, Player player1, Player player2){
        //CHECK if pawn with the other id is in the same square and if it is do nothing
        if(pawn.getPosition() == player1.getStartPosition() && Objects.equals(pawn.getColor(), "red")){
            if(check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, player1.getNextafterstartPosition())){
                return;
            }
            pawn.setPosition(player1.getNextafterstartPosition());
        }else if(pawn.getPosition() == player2.getStartPosition() && Objects.equals(pawn.getColor(), "yellow")) {
            if(check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, player2.getNextafterstartPosition())){
                return;
            }
            pawn.setPosition(player2.getNextafterstartPosition());
        }else{
            if(pawn.getPosition()==72) {
                if (check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, 0)) {
                    return;
                }
                pawn.setPosition(0);
            }
            else
                if (check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + 1)) {
                    return;
                }
                pawn.setPosition(pawn.getPosition() + 1);
        }
    }


}