package model.player;


public class Player {
    private String color;
    private int homePosition;
    private int SafetyZoneStartPosition;
    private int startPosition;
    private int nextofstartPosition;
    private boolean turn;

    public boolean getTurn(){
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    private Pawn Pawn1;
    private Pawn Pawn2;

    public Pawn getPawn1() {
        return Pawn1;
    }

    public Pawn getPawn2() {
        return Pawn2;
    }

    public String getColor() {
        return color;
    }


    public int getHomePosition() {
        return homePosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getNextafterstartPosition() {
        return nextofstartPosition;
    }


    /**
     * @param color
     * @param safetyZoneStartPosition
     * @param homePosition
     * @param startPosition
     * @param nextafterstartPosition
     * @param pawn1
     * @param pawn2
     * This is the constructor of the player class
     */
    public Player(String color,  int safetyZoneStartPosition ,int homePosition, int startPosition ,int nextafterstartPosition, Pawn pawn1, Pawn pawn2) {
        this.color = color;
        this.homePosition = homePosition;
        this.SafetyZoneStartPosition = safetyZoneStartPosition;
        this.startPosition = startPosition;
        this.nextofstartPosition = nextafterstartPosition;
        this.Pawn1 = pawn1;
        this.Pawn2 = pawn2;
    }
}
