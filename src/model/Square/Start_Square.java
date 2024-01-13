package model.Square;

public class Start_Square  extends Square{
    String color ;
    int next ;
    public Start_Square(int position ,String color, int next) {
        super(position,"Start");
        this.color = color;
        this.next = next;
    }
}
