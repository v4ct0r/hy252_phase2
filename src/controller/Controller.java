package controller;

import model.Board;
import model.Square.Home_Square;
import model.Square.Position;
import model.Square.Safety_Zone_Square;
import model.Square.Start_Square;
import model.player.Pawn;
import model.player.Player;
import model.turn.Deck;

public class Controller {
    private Player player1, player2;
    private Home_Square red_home= new Home_Square(new Position(6,2),"red");
    private Home_Square yellow_home= new Home_Square(new Position(9,13),"yellow");
    private Start_Square red_start = new Start_Square(new Position(1,4),"red",new Position(0,4));
    private Start_Square yellow_start = new Start_Square(new Position(14,11),"yellow",new Position(15,11));
    private Safety_Zone_Square[] red_safety_zone = new Safety_Zone_Square[5];
{
    for(int i=0;i<5;i++)
        red_safety_zone[i] = new Safety_Zone_Square(new Position(i+1, 2), "red");
}
private Safety_Zone_Square[] yellow_safety_zone = new Safety_Zone_Square[5];
{
    for(int i=0;i<5;i++)
        yellow_safety_zone[i] = new Safety_Zone_Square(new Position(14-i, 13), "yellow");
}

    private Pawn red_pawn1, red_pawn2;
    private Pawn Yellow_pawn1, Yellow_pawn2 ;
    public Controller() {
        Board board = new Board();
        Deck deck = new Deck();
        red_pawn1 = new Pawn(red_home.getPosition(), "red");
        red_pawn2 = new Pawn(red_home.getPosition(), "red");
        Yellow_pawn1 = new Pawn(yellow_home.getPosition(), "yellow");
        Yellow_pawn2 = new Pawn(yellow_home.getPosition(), "yellow");
        player1 = new Player("red",new Position(0,2) ,red_home.getPosition() ,red_start.getPosition() ,red_pawn1 ,red_pawn2);
        player2 = new Player("yellow",new Position(15,13) ,yellow_home.getPosition(), yellow_start.getPosition() ,Yellow_pawn1 ,Yellow_pawn2);
    }

    public boolean game_has_finished(Board board ,Pawn red_pawn1, Pawn red_pawn2, Pawn Yellow_pawn1, Pawn Yellow_pawn2 , Home_Square red_home, Home_Square yellow_home) {
        return false;
    }

    /**
     * @param player1
     * @param player2
     * pre-condition: playerx played (playerx.GetTurn() == true)
     * post-condition:the other player plays
     */
    public void switch_turn(Player player1, Player player2){
        //TODO
    }
    public void play(Pawn p){
        //TODO
    }
}
