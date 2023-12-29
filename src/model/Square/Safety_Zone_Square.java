package model.Square;

public class Safety_Zone_Square extends Square{

    String color ;
    public Safety_Zone_Square(int position,  String color) {
        super(position, "Safety");
        this.color = color;
    }
}
