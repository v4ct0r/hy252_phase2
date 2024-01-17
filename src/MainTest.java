import controller.Controller;
import model.card.Number_OneCard;
import model.card.Number_TwoCard;
import model.turn.Deck;
import org.junit.Test;
import view.BoardUI;
import view.GameView;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testgetoutofStart() {
        Main.main(null);
        while(true) {
            Main.game.background.ReceiveCard.doClick();
            Main.game.background.Fold.doClick();
            if(Main.controller.getCurrent_card() instanceof Number_OneCard || Main.controller.getCurrent_card() instanceof Number_TwoCard )
                break;
        }
        if(Main.controller.getCurrent_player()==Main.controller.player1) {
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(10).doClick();
            assertEquals(10,Main.controller.player1.getPawn1().getPosition());
        }else
        {
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(46).doClick();
            assertEquals(46,Main.controller.player2.getPawn1().getPosition());
        }
    }
    @Test
    public void testCard4() {
        Main.main(null);
        Main.controller.deck.setCard(new model.card.Number_TwoCard() ,43);
        Main.controller.deck.setCard(new model.card.Number_FourCard() ,42);
        while(true) {
            Main.game.background.ReceiveCard.doClick();
            Main.game.background.Fold.doClick();
            if(Main.controller.getCurrent_card() instanceof Number_OneCard || Main.controller.getCurrent_card() instanceof Number_TwoCard )
                break;
        }
        if(Main.controller.getCurrent_player()==Main.controller.player1) {
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(10).doClick();
            assertEquals(10,Main.controller.player1.getPawn1().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(0).doClick();
            assertEquals(0,Main.controller.player1.getPawn1().getPosition());
        }else
        {
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(46).doClick();
            assertEquals(46,Main.controller.player2.getPawn1().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(36).doClick();
            assertEquals(36,Main.controller.player2.getPawn1().getPosition());
        }
    }
    @Test
    public void testCard5() {
        Main.main(null);
        Main.controller.deck.setCard(new model.card.Number_TwoCard(), 43);
        Main.controller.deck.setCard(new model.card.Number_TwoCard(), 42);
        Main.controller.deck.setCard(new model.card.Number_TwoCard(), 41);
        Main.controller.deck.setCard(new model.card.Simple_Number_Card(5), 40);
        Main.game.background.ReceiveCard.doClick();
        if (Main.controller.getCurrent_player() == Main.controller.player1) {
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(10).doClick();
            assertEquals(10, Main.controller.player1.getPawn1().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(12).doClick();
            assertEquals(12, Main.controller.player1.getPawn1().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getRedPawn2().doClick();
            BoardUI.squares.get(10).doClick();
            assertEquals(10, Main.controller.player1.getPawn2().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(17).doClick();
            assertEquals(17, Main.controller.player1.getPawn1().getPosition());
            BoardUI.getRedPawn2().doClick();
            BoardUI.squares.get(15).doClick();
            assertEquals(15, Main.controller.player1.getPawn2().getPosition());
        }else{
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(46).doClick();
            assertEquals(46, Main.controller.player2.getPawn1().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(48).doClick();
            assertEquals(48, Main.controller.player2.getPawn1().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getYellowPawn2().doClick();
            BoardUI.squares.get(46).doClick();
            assertEquals(46, Main.controller.player2.getPawn2().getPosition());
            Main.game.background.ReceiveCard.doClick();
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(53).doClick();
            assertEquals(53, Main.controller.player2.getPawn1().getPosition());
            BoardUI.getYellowPawn2().doClick();
            BoardUI.squares.get(51).doClick();
            assertEquals(51, Main.controller.player2.getPawn2().getPosition());
        }
    }
    @Test
    public void testCard11() {
        Main.main(null);
        Main.controller.deck.setCard(new model.card.Number_OneCard(), 43);
        Main.controller.deck.setCard(new model.card.Number_OneCard(), 42);
        Main.controller.deck.setCard(new model.card.Number_ElevenCard(), 41);
        Main.game.background.ReceiveCard.doClick();
        if (Main.controller.getCurrent_player() == Main.controller.player1) {
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(10).doClick();
            assertEquals(10, Main.controller.player1.getPawn1().getPosition());
        }
        else{
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(46).doClick();
            assertEquals(46, Main.controller.player2.getPawn1().getPosition());
        }
        Main.game.background.ReceiveCard.doClick();
        if (Main.controller.getCurrent_player() == Main.controller.player1) {
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(10).doClick();
            assertEquals(10, Main.controller.player1.getPawn1().getPosition());
        }
        else{
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(46).doClick();
            assertEquals(46, Main.controller.player2.getPawn1().getPosition());
        }
        Main.game.background.ReceiveCard.doClick();
        if(Main.controller.getCurrent_player() == Main.controller.player1){
            BoardUI.getRedPawn1().doClick();
            BoardUI.getYellowPawn1().doClick();
            assertEquals(46, Main.controller.player1.getPawn1().getPosition());
            assertEquals(10, Main.controller.player2.getPawn1().getPosition());
        }
        else{
            BoardUI.getYellowPawn1().doClick();
            BoardUI.getRedPawn1().doClick();
            assertEquals(10, Main.controller.player1.getPawn1().getPosition());
            assertEquals(46, Main.controller.player2.getPawn1().getPosition());
        }
    }
    @Test
    public void testCardSorry() {
        Main.main(null);
        Main.controller.deck.setCard(new model.card.Number_OneCard(), 43);
        Main.controller.deck.setCard(new model.card.Sorry_Card(), 42);
        Main.game.background.ReceiveCard.doClick();
        if (Main.controller.getCurrent_player() == Main.controller.player1) {
            BoardUI.getRedPawn1().doClick();
            BoardUI.squares.get(10).doClick();
            assertEquals(10, Main.controller.player1.getPawn1().getPosition());
        } else {
            BoardUI.getYellowPawn1().doClick();
            BoardUI.squares.get(46).doClick();
            assertEquals(46, Main.controller.player2.getPawn1().getPosition());
        }

        Main.game.background.ReceiveCard.doClick();

        if (Main.controller.getCurrent_player() == Main.controller.player1) {
            BoardUI.getRedPawn1().doClick();
            BoardUI.getYellowPawn1().doClick();
            assertEquals(46, Main.controller.player1.getPawn1().getPosition());
            assertEquals(Main.controller.player2.getStartPosition(), Main.controller.player2.getPawn1().getPosition());
        } else {
            BoardUI.getYellowPawn1().doClick();
            BoardUI.getRedPawn1().doClick();
            assertEquals(10, Main.controller.player2.getPawn1().getPosition());
            assertEquals(Main.controller.player1.getStartPosition(), Main.controller.player1.getPawn1().getPosition());
        }
    }

}