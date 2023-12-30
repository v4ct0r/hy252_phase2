package model.player;

import model.Square.Position;

public class Pawn {
    private int position;
    private String color;
    private int id;
    public Pawn(int position, String color,int id) {
        this.position = position;
        this.color = color;
        this.id = id;
    }


    public int getId() {
        return id;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if(position>71)
            position = position-72;
        this.position = position;
    }

    public String getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Pawn{" +
                "position=" + position +
                ", color='" + color + '\'' +
                '}';
    }
}
