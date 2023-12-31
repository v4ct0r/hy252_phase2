package model.Square;

public abstract class Slide_Square extends Square{
    String color ;


    public Slide_Square(int position,String color, String id) {
        super(position, id);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
