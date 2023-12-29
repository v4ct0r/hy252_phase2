package model.turn;

import javax.smartcardio.Card;

public class Deck {
    private int cardsLeft=44;
    Card[] cards= new Card[44];

    public Deck() {
        inistializeDeck(cards);
        shuffle(cards);
    }

    /**
     * Initialize the deck with the cards
     * @param cards
     * return: the deck with the cards(4 cards of each type)
     */
    Card[] inistializeDeck(Card[] cards) {
        // TODO
        return null;
    }



    public void shuffle(Card[] cards) {
    }

    public Card draw() {
        cardsLeft--;
        return null;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }
}
