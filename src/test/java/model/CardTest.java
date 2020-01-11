package model;

import org.junit.Test;

import static model.CardStatus.*;
import static org.junit.Assert.assertEquals;

public class CardTest {
    @Test
    public void aNewCardMustBeInactive(){
        Card card = new Card();
        assertEquals(INACTIVE, card.getStatus());
    }
    @Test
    public void onceActivatedACardWillNeverBeSetToInactiveAgain(){
        Card card = new Card();
        card.setStatus(ACTIVE);
        card.setStatus(INACTIVE);
        assertEquals(ACTIVE,card.getStatus());
    }
    @Test
    public void onceCLOSEDaCardStatusCannotBeChangedAgain(){
        Card card = new Card();
        card.setStatus(CLOSED);
        card.setStatus(ACTIVE);
        assertEquals(CLOSED,card.getStatus());
    }
    @Test
    public void cardNumberMustBeA16DigitNumber(){
        Card card = new Card();
        assertEquals(16,String.valueOf(card.getCardNumber()).length());
    }
}
