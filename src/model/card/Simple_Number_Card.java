package model.card;

import controller.Controller;
import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public class Simple_Number_Card extends Number_Card{

    public Simple_Number_Card(int value) {
        super(value, "simple");
    }

    /**
     * Move the pawn forward 3 or 5 spaces depending on the card
     * @param pawn
     * @param player1
     * @param player2
     * pre-condition: pawn are not in start square , pawn can move forward 3 or 5 space
     * post-condition: pawn move forward 3 or 5 space
     */
    public int simple(Pawn pawn, Player player1, Player player2) {

        if(pawn.isStart() || pawn.getHome()){
            pawn.setMoveable(false);
            return pawn.getPosition();
        }
        pawn.setMoveable(true);
        if (!check_if_there_is_another_same_team_pawn_in_the_supposed_square(pawn, player1, player2, pawn.getPosition() + getValue()) || teammate_is_home(pawn,player1,player2)){
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
        if(pawnSkipsHome(teammate(pawn , player1 , player2),player1 ,player2)) { //the only case that the behind pawn gets movable = false is when the front pawn is unmovable - skips home
            pawn.setMoveable(false);
        }
        return pawn.getPosition();
    }
    public Pawn teammate(Pawn pawn , Player player1 , Player player2){
        if(Objects.equals(pawn.getColor(), "red")){
            if(pawn.getId()==1){
                return player1.getPawn2();
            }
            else if(pawn.getId()==2){
                return player1.getPawn1();
            }
        }
        else if(Objects.equals(pawn.getColor(), "yellow")){
            if(pawn.getId()==1){
                return player2.getPawn2();
            }
            else if(pawn.getId()==2){
                return player2.getPawn1();
            }
        }
        return null;
    }




}

