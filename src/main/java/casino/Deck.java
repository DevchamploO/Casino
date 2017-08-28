package casino;

import java.util.Random;

/**
 * Created by tiffany on 7/6/17.
 */
public class Deck {

    private String[] suites = {"SPADES", "HEARTS", "CLUBS", "DIAMONDS"};

    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "KING", "QUEEN", "JACK", "ACE"};

    private Card[] deck = new Card[52];

    public Card[] getDeck() {
        return deck;
    }

    //Constructor creates a deck of cards
    public Deck() {
        int x = 0;
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                deck[x] = new Card(suites[i], ranks[j]);
                x++;
            }
        }
    }

    //Draw a random card from the deck
    public Card drawCard() {
        Random r = new Random();
        int randomCard;

        do {
            randomCard = r.nextInt(52);
        }
        //Cards that have been chosen will turn null.
        // If a card that has already been picked is chosen (a.k.a null) then it will pick another.
        while (deck[randomCard] == null);
        Card newCard = deck[randomCard];
        deck[randomCard] = null;
        return newCard;
    }
}
