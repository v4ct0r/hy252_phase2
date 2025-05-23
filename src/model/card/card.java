package model.card;

import model.player.Pawn;
import model.player.Player;

public abstract class card {
    private String id ;

    public card(String id) {;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * @param p
     * @param player1
     * @param player2
     * @param square
     * @return true if there is another same team pawn in the supposed square
     */
    public boolean check_if_there_is_another_same_team_pawn_in_the_supposed_square(Pawn p, Player player1, Player player2, int square){
        if(square>71){
            square=square-72;
        }
        if(p.getColor().equals("red")){
            if(p.getId()==1){
                if(square==player1.getPawn2().getPosition()){
                    return true;
                }
            }
            else if(p.getId()==2){
                if(square==player1.getPawn1().getPosition()){
                    return true;
                }
            }
        }
        else if(p.getColor().equals("yellow")){
            if(p.getId()==1){
                if(square==player2.getPawn2().getPosition()){
                    return true;
                }
            }
            else if(p.getId()==2){
                if(square==player2.getPawn1().getPosition()){
                    return true;
                }
            }
        }
        return false;
    }


}
