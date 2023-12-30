package controller;

import model.Board;
import model.Square.Home_Square;
import model.card.*;
import model.player.Pawn;
import model.player.Player;
import model.turn.Deck;

import java.util.Objects;

public class Controller {
    public Board board ;
    public Deck deck ;
    public Player current_player ;
    Pawn red_pawn1;
    Pawn red_pawn2 ;
    Pawn Yellow_pawn1;
    Pawn Yellow_pawn2 ;

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
        board = new Board();
        deck = new Deck();
        red_pawn1 = new Pawn(-1, "red",1);
        red_pawn2 = new Pawn(-1, "red",2);
        Yellow_pawn1 = new Pawn(-2, "yellow",1);
        Yellow_pawn2 = new Pawn(-2, "yellow",2);
        player1 = new Player("red",3 ,8,-1 ,10, red_pawn1 ,red_pawn2);
        player2 = new Player("yellow",39 ,44,-2 ,47,Yellow_pawn1 ,Yellow_pawn2);
        //randomly choose who plays first
        current_player = pick_first_player(player1, player2);
    }

    private Player pick_first_player(Player player1, Player player2) {
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
    public card draw_card(Deck deck){
        card temp = deck.draw();
        setCurrent_card(temp);
        return temp;
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
        card temp=getCurrent_card() ;
        if(temp instanceof Number_OneCard){
            Number_OneCard temp1 = new Number_OneCard();
            temp1.one(p,player1,player2);//check if myteam second pawn is in the same square
            bumping(p,player1,player2);
        }
        else if(temp instanceof Number_TwoCard){

        }
        else if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 3){

        }
        else if(temp instanceof Number_FourCard){

        }
        else if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 5){

        }
        else if(temp instanceof Number_SevenCard){

        }
        else if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 8){

        }
        else if(temp instanceof Number_TenCard){

        }
        else if(temp instanceof Number_ElevenCard){

        }
        else if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 12){

        }
        else if(temp instanceof Sorry_Card){

        }}

    private void bumping(Pawn p, Player player1, Player player2) {
        if(Objects.equals(p.getColor(), "red")){
            if(p.getPosition()==player2.getPawn1().getPosition()){
                player2.getPawn1().setPosition(-1);
            }
            else if(p.getPosition()==player2.getPawn2().getPosition()){
                player2.getPawn2().setPosition(-1);
            }
        }
        else if(Objects.equals(p.getColor(), "yellow")){
            if(p.getPosition()==player1.getPawn1().getPosition()){
                player1.getPawn1().setPosition(-1);
            }
            else if(p.getPosition()==player1.getPawn2().getPosition()){
                player1.getPawn2().setPosition(-1);
            }
        }
    }


    private Pawn check_if_another_is_already_placed_in_this_square(Pawn p, Player player1, Player player2, Board board) {
        //TODO
        return null;
    }

    public card[] getCard(Deck deck){
        return deck.getCards();
    }


    public Pawn getRed_pawn1() {
        return red_pawn1;
    }

    public void setRed_pawn1(Pawn red_pawn1) {
        this.red_pawn1 = red_pawn1;
    }

    public Pawn getRed_pawn2() {
        return red_pawn2;
    }

    public void setRed_pawn2(Pawn red_pawn2) {
        this.red_pawn2 = red_pawn2;
    }

    public Pawn getYellow_pawn1() {
        return Yellow_pawn1;
    }

    public void setYellow_pawn1(Pawn yellow_pawn1) {
        Yellow_pawn1 = yellow_pawn1;
    }

    public Pawn getYellow_pawn2() {
        return Yellow_pawn2;
    }

    public void setYellow_pawn2(Pawn yellow_pawn2) {
        Yellow_pawn2 = yellow_pawn2;
    }
}
