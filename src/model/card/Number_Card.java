
package model.card;

import model.player.Pawn;
import model.player.Player;

import java.util.Objects;

public abstract class Number_Card extends card {
    private int value;

    public Number_Card(int value,String id) {
        super(id);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    /**
     * @param pawn
     * @param player1
     * @param player2
     * @return true the other same team pawn is home
     */
    public boolean teammate_is_home(Pawn pawn, Player player1, Player player2) {//if teammate is home you can have two pawns in the same square
        if(pawn.getColor().equals("red") && pawn.getId()==1)
            if(player1.getPawn2().getHome())
                return true;
        if(pawn.getColor().equals("red") && pawn.getId()==2)
            if(player1.getPawn1().getHome())
                return true;
        if(pawn.getColor().equals("yellow") && pawn.getId()==1)
            if(player2.getPawn2().getHome())
                return true;
        if(pawn.getColor().equals("yellow") && pawn.getId()==2)
            if(player2.getPawn1().getHome())
                return true;
        return false;
    }

    /**
     * @param pawn
     * @param player1
     * @param player2
     * @return true if the pawn skips home
     */
    public boolean pawnSkipsHome(Pawn pawn, Player player1, Player player2) {
        if(Objects.equals(pawn.getColor(), "red"))
            if(pawn.getPosition()<player1.getHomePosition()) {
                if (pawn.getPosition() + getValue() > player1.getHomePosition())
                    return true;
            }else if(pawn.getPosition() -72 + getValue() > player1.getHomePosition())
                return true;

        if(Objects.equals(pawn.getColor(), "yellow"))
            if(pawn.getPosition()<player2.getHomePosition())
                if(pawn.getPosition() + getValue() > player2.getHomePosition())
                    return true;
        return false;
    }
    /**
     * @param pos
     * @param value
     * @param pawn
     * @return the valid square if the pawn has to move backwards
     */
    int validSquare(int pos ,int value , Pawn pawn){
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