package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardHolder {

    private List<Card> cards = new ArrayList<>();
    public CardHolder(){
        addPrimaryCard();
    }

    private void addPrimaryCard() {
        Card card = new Card();
        card.setPrimarySecondaryIndicator(true);
        cards.add(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addSecondaryCard(Card card) {
        if(getSecondaryCards().size() >= 6)
            return;
        card.setPrimarySecondaryIndicator(false);
        cards.add(card);

    }

    public Card getPrimaryCard() {
        List<Card> primaryCards = cards.stream().filter(card -> card.getPrimarySecondaryIndicator())
                .collect(Collectors.toList());
        assert primaryCards.size() == 1;
        final Card card = primaryCards.get(0);
        return card;
    }

    public List<Card> getSecondaryCards() {
        List<Card> secondaryCards = cards.stream().filter(card -> !card.getPrimarySecondaryIndicator())
                .collect(Collectors.toList());
        return secondaryCards;
    }
}
