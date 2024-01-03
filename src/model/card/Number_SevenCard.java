package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public class Number_SevenCard extends Number_Card {

    public Number_SevenCard() {
        super(7, "seven");
    }


    public int seven(Pawn pawn , Player player1 , Player player2 ) {
        if (pawn.isStart() || pawn.getHome()) {
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
                if(pawnSkipsHome(pawn, player1, player2)) {
                    pawn.setMoveable(false);
                    return pawn.getPosition();
                }

                return pawn.getPosition() + getValue();
        }
        pawn.setMoveable(false);
        return pawn.getPosition();

    }
    public int[] seven_7(Pawn pawn , Player player1 , Player player2){
        int[] arr = new int[7];for(int i = 0 ; i < 7 ; i++){
            if (pawn.isStart() || pawn.getHome()) {
                pawn.setMoveable(false);
                arr[i] = pawn.getPosition();
            }
            if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + i + 1 ) || teammate_is_home(pawn,player1,player2)){

                if(pawn.getPosition() + i+1 > 71){
                    if(Objects.equals(pawn.getColor(), "yellow")) {
                        if (pawn.getPosition() + i + 1 - 72 < 3)
                            arr[i] = pawn.getPosition() + i + 1 - 72;
                        else
                            arr[i] = pawn.getPosition() + i + 1 - 72 + 6;
                    }else {
                        if(pawnSkipsHome(pawn, player1, player2)) {
                            pawn.setMoveable(false);
                            arr[i] = pawn.getPosition();
                        }
                        arr[i] = pawn.getPosition() + i + 1 - 72;
                    }
                }
                if(Objects.equals(pawn.getColor(), "yellow") && pawn.getPosition() + i + 1 > 2 && pawn.getPosition() + i + 1 <= 8)
                    arr[i] = pawn.getPosition() + i + 1 + 6;
                if(Objects.equals(pawn.getColor(), "red") && pawn.getPosition() + i + 1 > 38 && pawn.getPosition() + i + 1 <= 44)
                    arr[i] = pawn.getPosition() + i + 1 + 6;
                if(pawnSkipsHome(pawn, player1, player2)) {
                    pawn.setMoveable(false);
                    arr[i] = pawn.getPosition();
                }

                arr[i] = pawn.getPosition() + i + 1;
            }else{
                pawn.setMoveable(false);
                arr[i] = pawn.getPosition();
            }

        }
        return arr;
    }

}
