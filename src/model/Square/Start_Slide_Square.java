package model.Square;

import model.player.Pawn;

public class Start_Slide_Square extends Slide_Square{
    int endPosition;

    public Start_Slide_Square(int position, String color, int endPosition) {
        super(position, color, "Start_Slide");
        this.endPosition = endPosition;
    }

    /**
     * pre-condition: p is in the start of its color slide
     * post-condition: p go to the end of the same slide
     * @param p
     */
    void go_to_SlideEnd(Pawn p,String color, int endPosition){
        //TODO
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
