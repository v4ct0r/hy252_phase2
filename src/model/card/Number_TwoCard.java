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
     * pre-condition: pawn is in start square
     * post-condition: pawn can get out of start square and play again
     * pre-condition: pawn is not in start square
     * post-condition: pawn can move two space forward and play again
     */
    public void two(Pawn pawn, Player player1, Player player2) {
        if (pawn.getPosition() == player1.getStartPosition() && Objects.equals(pawn.getColor(), "red")) {
            if (check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, player1.getNextafterstartPosition())) {
                return;
            }
            pawn.setPosition(player1.getNextafterstartPosition());
        } else if (pawn.getPosition() == player2.getStartPosition() && Objects.equals(pawn.getColor(), "yellow")) {
            if (check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, player2.getNextafterstartPosition())) {
                return;
            }
            pawn.setPosition(player2.getNextafterstartPosition());
        } else {
            if (check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + 1)) {
                return;
            }
            pawn.setPosition(pawn.getPosition() + getValue());
        }
    }
}