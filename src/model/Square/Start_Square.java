package model.Square;

public class Start_Square  extends Square{
    String color ;
    Position next ;

    public Start_Square(Position position, String color, Position next) {
        super(position,"Start");
        this.color = color;
        this.next = next;
    }
}
