package model.Square;

public abstract class Slide_Square extends Square{
    String color ;


    public Slide_Square(Position position, String color , String id) {
        super(position,id);
        this.color = color;
    }
}
