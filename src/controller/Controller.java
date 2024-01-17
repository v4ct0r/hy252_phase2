package controller;

import model.Board;
import model.Square.*;
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
    /**
     * Constructor of the class
     * Creates the board
     * Creates the deck
     * initializes the pawns
     * initializes the players
     * Randomly chooses who plays first
     */
    public Controller() {
        board = new Board();
        deck = new Deck();
        red_pawn1 = new Pawn(-1, "red",1);
        red_pawn2 = new Pawn(-1, "red",2);
        Yellow_pawn1 = new Pawn(-2, "yellow",1);
        Yellow_pawn2 = new Pawn(-2, "yellow",2);
        player1 = new Player("red",3 ,8,-1 ,10, red_pawn1 ,red_pawn2);
        player2 = new Player("yellow",39 ,44,-2 ,46,Yellow_pawn1 ,Yellow_pawn2);
        //randomly choose who plays first
        current_player = pick_first_player(player1, player2);
    }

    /**
     * @param player1
     * @param player2
     * @return the player who plays first
     * pre-condition: player1 and player2 are initialized
     * post-condition: the player who plays first is returned
     */
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
    /**
     * @param player1
     * @param player2
     * pre-condition: player1 and player2 are initialized
     * post-condition: the current player is switched
     */
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

    /**
     * @return true if the game has finished
     * pre-condition: player1 and player2 are initialized
     * post-condition: true is returned if the game has finished
     */
    public boolean game_has_finished() {
        if (player1.getPawn1().getHome() && player1.getPawn2().getHome()) {
            return true;
        } else if (player2.getPawn1().getHome() && player2.getPawn2().getHome()) {
            return true;
        }
        return false;
    }
    /**
     * @param deck
     * draws a card from the deck and sets it as the current card
     */
    public card draw_card(Deck deck){
        card temp = deck.draw();
        setCurrent_card(temp);
        return temp;
    }

    /**
     * @param p
     * @return the prediction of the pawn when the current card is 10 and player chooses to move 1 square backwards
     */
    public int predict1(Pawn p){
        card temp=getCurrent_card() ;
        if(temp instanceof Number_TenCard){
            Number_TenCard temp1 = new Number_TenCard();

            return temp1.ten_1(p,player1,player2);
        }
        return 0;
    }
    /**
     * @param p
     * @return the array of the predictions of the pawn when the current card is 7
     * pre-condition: both pawns of the player are not in the start square
     * post-condition: the prediction of the pawn is returned
     */
    public int[] predict7(Pawn p){
        card temp=getCurrent_card() ;
        if(temp instanceof Number_SevenCard){
            Number_SevenCard temp1 = new Number_SevenCard();

            return temp1.seven_7(p,player1,player2);
        }
        return null;
    }
    /**
     * @param p
     * @param value  the value that the pawn is gonna move forward
     * @return How many squares the pawn will move when the current card is 7
     * pre-condition: the other same team pawn move less than 7 squares
     * post-condition: the prediction of the pawn is returned
     */
    public int predictdiff7(Pawn p,int value){
        card temp=getCurrent_card() ;
        if(temp instanceof Number_SevenCard){
            Number_SevenCard temp1 = new Number_SevenCard();

            return temp1.seven_7diff(p,player1,player2,value);
        }
        return 0;
    }
    /**
     * @param p
     * @return the prediction of the pawn , if there is more than one option for the player it will need more than one prediction
     */
    public int predict(Pawn p){
        card temp=getCurrent_card() ;
        if(temp instanceof Number_OneCard){
            Number_OneCard temp1 = new Number_OneCard();

            return temp1.one(p,player1,player2);
        }
        if(temp instanceof Number_TwoCard){
            Number_TwoCard temp1 = new Number_TwoCard();

            return temp1.two(p,player1,player2);
        }
        if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 3){
            Simple_Number_Card temp1 = new Simple_Number_Card(3);

            return temp1.simple(p,player1,player2);
        }
        if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 5){
            Simple_Number_Card temp1 = new Simple_Number_Card(5);

            return temp1.simple(p,player1,player2);
        }
        if(temp instanceof Number_FourCard){
            Number_FourCard temp1 = new Number_FourCard();

            return temp1.four(p,player1,player2);
        }
        if(temp instanceof Number_TenCard){
            Number_TenCard temp1 = new Number_TenCard();
            return temp1.ten(p,player1,player2);
        }
        if(temp instanceof Simple_Number_Card8_12 && ((Simple_Number_Card8_12) temp).getValue() == 8){
            Simple_Number_Card8_12 temp1 = new Simple_Number_Card8_12(8);
            return temp1.simple8_12(p,player1,player2);
        }
        if(temp instanceof Simple_Number_Card8_12 && ((Simple_Number_Card8_12) temp).getValue() == 12){
            Simple_Number_Card8_12 temp1 = new Simple_Number_Card8_12(12);
            return temp1.simple8_12(p,player1,player2);
        }
        if(temp instanceof Number_SevenCard){
            Number_SevenCard temp1 = new Number_SevenCard();
            return temp1.seven(p,player1,player2);
        }
        if(temp instanceof Number_ElevenCard){
            Number_ElevenCard temp1 = new Number_ElevenCard();
            return temp1.eleven(p,player1,player2);
        }
        if(temp instanceof Sorry_Card){
            Sorry_Card temp1 = new Sorry_Card();
            return temp1.sorry(p,player1,player2);
        }
        return 0;
    }
    /**
     * @param p
     * @param prediction
     * sets the position of the pawn after the prediction when square is clicked
     * check for bumping
     */
    public void play(Pawn p,int prediction){
        card temp=getCurrent_card() ;
        if(temp instanceof Number_OneCard){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Number_TwoCard){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 3){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Number_FourCard){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Simple_Number_Card && ((Simple_Number_Card) temp).getValue() == 5){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Number_SevenCard){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Simple_Number_Card8_12 && ((Simple_Number_Card8_12) temp).getValue() == 8){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Number_TenCard){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Number_ElevenCard){
            int mypawnpos = p.getPosition();
            p.setPosition(prediction);
            swap(p,player1,player2,mypawnpos);
        }
        else if(temp instanceof Simple_Number_Card8_12 && ((Simple_Number_Card8_12) temp).getValue() == 12){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
        else if(temp instanceof Sorry_Card){
            p.setPosition(prediction);
            bumping(p,player1,player2);
        }
    }
    /**
     * @param p
     * @param player1
     * @param player2
     * @param mypawnpos
     * swaps the position of the pawn with the other pawn of the enemy team
     * pre-condition: Current card is 11
     * post-condition: the position of the pawn is swapped with the other pawn of the enemy team
     */
    private void swap(Pawn p, Player player1, Player player2, int mypawnpos) {
        if(Objects.equals(p.getColor(), "red")){
            if(p.getPosition()==player2.getPawn1().getPosition()){
                player2.getPawn1().setPosition(mypawnpos);
            }
            else if(p.getPosition()==player2.getPawn2().getPosition()){
                player2.getPawn2().setPosition(mypawnpos);
            }
        }
        else if(Objects.equals(p.getColor(), "yellow")){
            if(p.getPosition()==player1.getPawn1().getPosition()){
                player1.getPawn1().setPosition(mypawnpos);
            }
            else if(p.getPosition()==player1.getPawn2().getPosition()){
                player1.getPawn2().setPosition(mypawnpos);
            }
        }
    }
    /**
     * @param p
     * @param player1
     * @param player2
     if two different team pawns share the same square, the pawn of the other team is sent to the start square
     */
    private void bumping(Pawn p, Player player1, Player player2) {
        if(Objects.equals(p.getColor(), "red")){
            if(p.getPosition()==player2.getPawn1().getPosition()){
                player2.getPawn1().setPosition(player2.getStartPosition());
            }
            else if(p.getPosition()==player2.getPawn2().getPosition()){
                player2.getPawn2().setPosition(player2.getStartPosition());
            }
        }
        else if(Objects.equals(p.getColor(), "yellow")){
            if(p.getPosition()==player1.getPawn1().getPosition()){
                player1.getPawn1().setPosition(player1.getStartPosition());
            }
            else if(p.getPosition()==player1.getPawn2().getPosition()){
                player1.getPawn2().setPosition(player1.getStartPosition());
            }
        }
    }

    /**
     * @param p
     * @return true if the pawn is in the start Slide square and the color of the pawn is different from the color of the start slide square
     * pre-condition: the pawn is in the start slide square
     * post-condition: if true sent to the end slide square and bump every pawn in the way
     */
    public boolean check_for_slide(Pawn p){
        if(Objects.equals(p.getColor(), "red")) {
            if (board.squares[p.getPosition()] instanceof Start_Slide_Square && !((Start_Slide_Square) board.squares[p.getPosition()]).getColor().equals("red")) {
                for (int i = p.getPosition(); i <= ((Start_Slide_Square) board.squares[p.getPosition()]).getEndPosition(); i++) {
                    if((board.squares[i] instanceof Internal_Slide_Square) || (board.squares[i] instanceof End_Slide_Square)) {
                        if (i == getYellow_pawn1().getPosition())
                            getYellow_pawn1().setPosition(player2.getStartPosition());
                        else if (i == getYellow_pawn2().getPosition())
                            getYellow_pawn2().setPosition(player2.getStartPosition());
                        else if (i == theotherpawn(p).getPosition())
                            theotherpawn(p).setPosition(player1.getStartPosition());
                    }
                }
                p.setPosition(((Start_Slide_Square) board.squares[p.getPosition()]).getEndPosition());
                return true;
            }
        }if(Objects.equals(p.getColor(), "yellow")) {
            if (board.squares[p.getPosition()] instanceof Start_Slide_Square && !((Start_Slide_Square) board.squares[p.getPosition()]).getColor().equals("yellow")) {
                for (int i = p.getPosition(); i <= ((Start_Slide_Square) board.squares[p.getPosition()]).getEndPosition(); i++) {
                    if(board.squares[i] instanceof Internal_Slide_Square || board.squares[i] instanceof End_Slide_Square) {
                        if (i == getRed_pawn1().getPosition())
                            getRed_pawn1().setPosition(player1.getStartPosition());
                        else if (i == getRed_pawn2().getPosition())
                            getRed_pawn2().setPosition(player1.getStartPosition());
                        else if (i == theotherpawn(p).getPosition())
                            theotherpawn(p).setPosition(player2.getStartPosition());
                    }
                }
                p.setPosition(((Start_Slide_Square) board.squares[p.getPosition()]).getEndPosition());
                return true;
            }
        }
        return false;
    }
    /**
     * @param p
     * @return true if the pawn is in the end slide square and the color of the pawn is different from the color of the end slide square
     * pre-condition: the pawn is in the end slide square
     * post-condition: if true sent to the start slide square and bump every pawn in the way
     */
    public Pawn theotherpawn(Pawn p) {
        if(Objects.equals(p.getColor(), "red")){
            if(p.getId()==1){
                return getRed_pawn2();
            }
            else if(p.getId()==2){
                return getRed_pawn1();
            }
        }
        else if(Objects.equals(p.getColor(), "yellow")){
            if(p.getId()==1){
                return getYellow_pawn2();
            }
            else if(p.getId()==2){
                return getYellow_pawn1();
            }
        }
        return null;
    }
    /**
     * @param s
     * @return the pawn with the given id
     */
    public Pawn get_pawn(String s){
        if(Objects.equals(s, "redPawn1")){
            return getRed_pawn1();
        }
        else if(Objects.equals(s, "redPawn2")){
            return getRed_pawn2();
        }
        else if(Objects.equals(s, "yellowPawn1")){
            return getYellow_pawn1();
        }
        else if(Objects.equals(s, "yellowPawn2")){
            return getYellow_pawn2();

        }
        return null;
    }


    public Pawn getRed_pawn1() {
        return red_pawn1;
    }


    public Pawn getRed_pawn2() {
        return red_pawn2;
    }


    public Pawn getYellow_pawn1() {
        return Yellow_pawn1;
    }

    public Pawn getYellow_pawn2() {
        return Yellow_pawn2;
    }


    /**
     * @param pawn2
     * @return the other pawn of the same team
     */
    public Pawn teammate(Pawn pawn2) {
        if(Objects.equals(pawn2.getColor(), "red")){
            if(pawn2.getId()==1){
                return getRed_pawn2();
            }
            else if(pawn2.getId()==2){
                return getRed_pawn1();
            }
        }
        else if(Objects.equals(pawn2.getColor(), "yellow")){
            if(pawn2.getId()==1){
                return getYellow_pawn2();
            }
            else if(pawn2.getId()==2){
                return getYellow_pawn1();
            }
        }
        return null;
    }
}
