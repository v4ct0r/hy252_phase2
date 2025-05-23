package model.turn;
import java.util.Random;

import model.card.*;


public class Deck {
    private int cardsLeft=44;

    card[] cards= new card[44];


    public card[] getCards() {
        return cards;
    }


    public Deck() {
        initializeDeck(cards);
        shuffle(cards);
    }

    /**
     * Initialize the deck with the cards
     * @param cards return: the deck with the cards(4 cards of each type)
     */
   private void initializeDeck(card[] cards) {
        //4 cards of each kind
        for (int i = 0; i < 4; i++) {
            cards[i] = new Number_OneCard();
        }
        for (int i = 4; i < 8; i++) {
            cards[i] = new Number_TwoCard();
        }
        for (int i = 8; i < 12; i++) {
            cards[i] = new Simple_Number_Card(3);
        }
        for (int i = 12; i < 16; i++) {
            cards[i] = new Number_FourCard();
        }
        for (int i = 16; i < 20; i++) {
            cards[i] = new Simple_Number_Card(5);
        }
        for (int i = 20; i < 24; i++) {
            cards[i] = new Number_SevenCard();
        }
        for (int i = 24; i < 28; i++) {
            cards[i] = new Simple_Number_Card8_12(8);
        }
        for (int i = 28; i < 32; i++) {
            cards[i] = new Number_TenCard();
        }
        for (int i = 32; i < 36; i++) {
            cards[i] = new Number_ElevenCard();
        }
        for (int i = 36; i < 40; i++) {
            cards[i] = new Simple_Number_Card8_12(12);
        }
        for (int i = 40; i < 44; i++) {
            cards[i] = new Sorry_Card();
        }
    }


/**
 * Shuffle the deck
 * @param cards
 */
private void shuffle(card[] cards) {
    Random rand = new Random();
    for (int i = cards.length - 1; i > 0; i--) {
        int j = rand.nextInt(i + 1);
        card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }
}
    /**
     * Draw a card from the deck
     * @return the card drawn
     */
    public card draw() {
        if (cardsLeft == 0) {
            initializeDeck(cards);
            shuffle(cards);
            cardsLeft = 44;
        }
        cardsLeft--;
        return cards[cardsLeft];

    }
    public int getCardsLeft() {
        return cardsLeft;
    }
    public void setCard(card card, int index) {
        cards[index] = card;
    }
}
