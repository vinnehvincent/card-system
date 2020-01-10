package model;

import model.Card;
import model.CardStatus;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void aNewCardMustBeInactive(){
        Card card = new Card();
        Assert.assertEquals(CardStatus.INACTIVE, card.getStatus());
    }
    @Test
    public void onceActivatedACardWillNeverBeSetToInactiveAgain(){
        Card card = new Card();
        card.setStatus(CardStatus.ACTIVE);
        card.setStatus(CardStatus.INACTIVE);
        Assert.assertEquals(CardStatus.ACTIVE,card.getStatus());
    }
    @Test
    public void onceCLOSEDaCardStatusCannotBeChangedAgain(){
        Card card = new Card();
        card.setStatus(CardStatus.CLOSED);
        card.setStatus(CardStatus.ACTIVE);
        Assert.assertEquals(CardStatus.CLOSED,card.getStatus());
    }
}
