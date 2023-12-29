package model.Square;

public class Home_Square extends Square{
    String color ;
    int position ;
    public Home_Square(int position, String color) {
        super(position,"Home");
        this.color = color;
    }
}
