package model.Square;

import model.player.Pawn;

public class Start_Slide_Square extends Slide_Square{
    int endPosition;

    public Start_Slide_Square(int position, String color, int endPosition) {
        super(position, color, "Start_Slide");
        this.endPosition = endPosition;
    }


    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
