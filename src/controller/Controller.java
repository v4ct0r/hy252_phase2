package controller;

import model.Board;
import model.Square.Home_Square;
import model.card.card;
import model.player.Pawn;
import model.player.Player;
import model.turn.Deck;

public class Controller {
    public Deck deck ;
    public Player current_player ;
    public Player player1 ;
    public Player player2 ;
    public card current_card ;

    public card getCurrent_card() {
        return current_card;
    }

    public void setCurrent_card(card current_card) {
        this.current_card = current_card;
    }

    public Player getCurrent_player() {
        return current_player;
    }

    public void setCurrent_player(Player current_player) {
        this.current_player = current_player;
    }

    public Controller() {
        Board board = new Board();
        deck = new Deck();
        Pawn red_pawn1 = new Pawn(-1, "red");
        Pawn red_pawn2 = new Pawn(-1, "red");
        Pawn Yellow_pawn1 = new Pawn(-2, "yellow");
        Pawn Yellow_pawn2 = new Pawn(-2, "yellow");
        player1 = new Player("red",3 ,8,-1 ,red_pawn1 ,red_pawn2);
        player2 = new Player("yellow",39 ,44,-2 ,Yellow_pawn1 ,Yellow_pawn2);
        //randomly choose who plays first
        current_player = pick_first_player(player1, player2);
    }

    private Player pick_first_player(Player player1, Player player2) {
        //doit
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            player1.setTurn(true);
            player2.setTurn(false);
            return player1;
        } else {
            player1.setTurn(false);
            player2.setTurn(true);
            return player2;
        }
    }

    public void switch_current_player(Player player1, Player player2){
        if (player1.getTurn() == true) {
            player1.setTurn(false);
            player2.setTurn(true);
            current_player = player2;
        } else {
            player1.setTurn(true);
            player2.setTurn(false);
            current_player = player1;
        }
    }

    public String Current_card(card current) {
        return current.getId();
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

    public card Draw_card(){
        return deck.draw();
    }

    public card[] getCard(Deck deck){
        return deck.getCards();
    }

}
