package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Entity
@Table(name="CARDHOLDERS")
public class CardHolder {

    @Id
    @Column(name="identity_number",unique = true)
    private String govId;

    private String title;
    private String name;
    private String surname;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @OneToMany(cascade = CascadeType.PERSIST)
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

    public void addSecondaryCard() throws Exception {
        if(getSecondaryCards().size() >= 6)
            throw new Exception("A card holder cannot have more than 6 secondary cards");
        Card card = new Card();
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

    public String getId() {
        return govId;
    }
}
