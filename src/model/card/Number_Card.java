
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
}