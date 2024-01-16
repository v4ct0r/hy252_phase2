package model.card;

import model.player.Pawn;

import java.util.Objects;

public class Number_FourCard extends Number_Card{
    public Number_FourCard() {
        super(4, "four");
    }

    /**
     * Move the pawn backward 4 spaces
     * @param pawn
     * pre-condition: pawn are not in start square , pawn can move backward 4 space
     * post-condition: pawn move backward 4 space
     */
    public int four(Pawn pawn, model.player.Player player1, model.player.Player player2) {
        if (pawn.isStart() || pawn.getHome()) {
            pawn.setMoveable(false);
            return pawn.getPosition();
        }
        if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, validSquare(pawn.getPosition(), getValue(), pawn)) || teammate_is_home(pawn, player1, player2)) {
            pawn.setMoveable(true);
            if (pawn.getPosition() - getValue() < 0)
                return pawn.getPosition() - getValue() + 72;

            if (pawn.getPosition() - getValue() > 2 && pawn.getPosition() - getValue() <= 8) {
                if (pawn.getPosition() == 7)
                    return 3;
                if (pawn.getPosition() - getValue() - 6 < 0)
                    return pawn.getPosition() - getValue() - 6 + 72;
                else
                    return pawn.getPosition() - getValue() - 6;
            }

            if (pawn.getPosition() - getValue() > 38 && pawn.getPosition() - getValue() <= 44) {
                if (pawn.getPosition() == 43)
                    return 39;
                return pawn.getPosition() - getValue() - 6;
            }

            return pawn.getPosition() - getValue();
        }

        pawn.setMoveable(false);
        return pawn.getPosition();
    }
}
