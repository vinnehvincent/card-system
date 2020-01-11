package model;

import java.util.ArrayList;
import java.util.List;

public class CardHolder {

    private List<Card> cards = new ArrayList<>();
    public CardHolder(){
        Card card = new Card();
        card.setPrimarySecondaryIndicator(true);
        cards.add(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
