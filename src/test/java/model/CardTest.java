package model;

import org.junit.Assert;
import org.junit.Test;

import static model.CardStatus.*;

public class CardTest {
    @Test
    public void aNewCardMustBeInactive(){
        Card card = new Card();
        Assert.assertEquals(INACTIVE, card.getStatus());
    }
    @Test
    public void onceActivatedACardWillNeverBeSetToInactiveAgain(){
        Card card = new Card();
        card.setStatus(ACTIVE);
        card.setStatus(INACTIVE);
        Assert.assertEquals(ACTIVE,card.getStatus());
    }
    @Test
    public void onceCLOSEDaCardStatusCannotBeChangedAgain(){
        Card card = new Card();
        card.setStatus(CLOSED);
        card.setStatus(ACTIVE);
        Assert.assertEquals(CLOSED,card.getStatus());
    }
}
