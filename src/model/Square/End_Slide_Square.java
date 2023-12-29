package model.Square;

public class End_Slide_Square extends Slide_Square{
    int endPosition ;

    public End_Slide_Square(Position position, String color, int endPosition) {
        super(position, color, "End_Slide");
        this.endPosition = endPosition;
    }
}
