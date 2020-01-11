package model;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void addSecondaryCard(Card card) {
        if(getSecondaryCards().size() < 6) {
            card.setPrimarySecondaryIndicator(false);
            cards.add(card);
        }
    }

    public Card getPrimaryCard() {
        List<Card> primaryCards = cards.stream().filter(card -> card.getPrimarySecondaryIndicator())
                .collect(Collectors.toList());
        Assert.assertEquals(1,primaryCards.size());
        return primaryCards.get(0);
    }

    public List<Card> getSecondaryCards() {
        return cards.stream().filter(card -> !card.getPrimarySecondaryIndicator())
                .collect(Collectors.toList());
    }
}
