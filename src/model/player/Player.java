package model.player;

import model.Square.Position;

public class Player {
    private String color;
    private Position homePosition;
    private Position SafetyZoneStartPosition;
    private Position startPosition;
    private boolean turn;

    public boolean getTurn(){
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    private Pawn Pawn1;
    private Pawn Pawn2;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getHomePosition() {
        return homePosition;
    }

    public void setHomePosition(Position homePosition) {
        this.homePosition = homePosition;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public Player(String color,  Position safetyZoneStartPosition ,Position homePosition, Position startPosition, Pawn pawn1, Pawn pawn2) {
        this.color = color;
        this.homePosition = homePosition;
        SafetyZoneStartPosition = safetyZoneStartPosition;
        this.startPosition = startPosition;
        Pawn1 = pawn1;
        Pawn2 = pawn2;
    }
}
