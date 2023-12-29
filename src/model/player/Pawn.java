package model.player;

import model.Square.Position;

public class Pawn {
    private int position;
    public Pawn(int position, String color) {
        this.position = position;
        this.color = color;
    }

    private String color;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "position=" + position +
                ", color='" + color + '\'' +
                '}';
    }
}
