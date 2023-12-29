package model.Square;

import model.player.Pawn;

public class Start_Slide_Square extends Slide_Square{
    int startPosition ;



    public Start_Slide_Square(Position position, String color, int startPosition) {
        super(position, "color", "Start_Slide");

        this.startPosition = startPosition;
    }

    /**
     * pre-condition: p is in the start of its color slide
     * post-condition: p go to the end of the same slide
     * @param p
     */
    void go_to_SlideEnd(Pawn p,String color){
        //TODO
    }
}
