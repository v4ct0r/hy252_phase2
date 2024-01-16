package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public class Number_TenCard extends Number_Card{
    public Number_TenCard() {
        super(10,"ten");
    }


    /**
     * Move the pawn forward 10 spaces
     * @param pawn
     * @param player1
     * @param player2
     *pre-condition: pawn are not in start square , pawn can move forward 10 space
     *post-condition: pawn move forward 10 space
     */
    public int ten(Pawn pawn , Player player1 , Player player2 ) {
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


    /** Move the pawn backward 1 space
     * @param pawn
     * @param player1
     * @param player2
     * pre-condition: pawn are not in start square , pawn can move backward 1 space
     * post-condition: pawn move backward 1 space
     */
    public int ten_1(Pawn pawn , Player player1 , Player player2) {
        if(pawn.isStart() || pawn.getHome()){
            pawn.setMoveable(false);
            return pawn.getPosition();
        }
        if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, validSquare_minus(pawn.getPosition(),1,pawn) )|| teammate_is_home(pawn,player1,player2)){
            pawn.setMoveable(true);
            if(pawn.getPosition() - 1 < 0)
                return pawn.getPosition() - 1 + 72;

            if(pawn.getPosition()==9)
                return 2;

            if(pawn.getPosition() ==45)
                return 38;

            return pawn.getPosition() - 1;
        }

        pawn.setMoveable(false);
        return pawn.getPosition();
    }

    int validSquare_minus(int pos ,int value , Pawn pawn){
        int result = 0;
        if(Objects.equals(pawn.getColor(), "red")){
            if(pos-value>2 && pos-value<=8){
                result = pos-value-6;
            }
            else{
                result = pos-value;
            }
        } else if (Objects.equals(pawn.getColor(), "yellow")) {
            if (pos - value > 38 && pos - value <= 44) {
                result = pos - value - 6;
            } else {
                result = pos - value;
            }
        }
        if (result < 0) {
            return result + 72;
        } else {
            return result;
        }
    }
}




