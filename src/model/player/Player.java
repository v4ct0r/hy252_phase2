package model.player;


public class Player {
    private String color;
    private int homePosition;
    private int SafetyZoneStartPosition;
    private int startPosition;
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

    public int getHomePosition() {
        return homePosition;
    }

    public void setHomePosition(int homePosition) {
        this.homePosition = homePosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public Player(String color,  int safetyZoneStartPosition ,int homePosition, int startPosition, Pawn pawn1, Pawn pawn2) {
        this.color = color;
        this.homePosition = homePosition;
        this.SafetyZoneStartPosition = safetyZoneStartPosition;
        this.startPosition = startPosition;
        this.Pawn1 = pawn1;
        this.Pawn2 = pawn2;
    }
}
