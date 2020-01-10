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
}
