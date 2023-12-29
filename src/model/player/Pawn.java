package model.player;

import model.Square.Position;

public class Pawn {
    private Position position;
    public Pawn(Position position, String color) {
        this.position = position;
        this.color = color;
    }

    private String color;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
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
