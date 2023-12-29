package model.Square;

import model.player.Pawn;

public class Internal_Slide_Square extends Slide_Square{

    public Internal_Slide_Square(int position,String color) {
        super(position,color, "Internal_Slide");
    }

    /**
     * pre-condition: p is in the middle of the opponent's slide
     * post-condition: p go to the Start of its color
     * @param p
     */
    void go_to_Start(Pawn p , int start_slide_index){
        //TODO
    }
}
