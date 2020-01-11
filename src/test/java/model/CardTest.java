package model;

import org.junit.Test;

import static model.CardStatus.*;
import static org.junit.Assert.assertEquals;

public class CardTest {

    private final Card card = new Card();

    @Test
    public void aNewCardMustBeInactive(){
        assertEquals(INACTIVE, card.getStatus());
    }
    @Test
    public void onceActivatedACardWillNeverBeSetToInactiveAgain(){
        card.setStatus(ACTIVE);
        card.setStatus(INACTIVE);
        assertEquals(ACTIVE,card.getStatus());
    }
    @Test
    public void onceCLOSEDaCardStatusCannotBeChangedAgain(){
        card.setStatus(CLOSED);
        card.setStatus(ACTIVE);
        assertEquals(CLOSED,card.getStatus());
    }
    @Test
    public void cardNumberMustBeA16DigitNumber(){
        assertEquals(16,String.valueOf(card.getCardNumber()).length());
    }

    @Test
    public void cardExpiresAfter5years(){
        //Assumption I am making...as expiry date isn't specified in the requirements
        assertEquals(card.getCreatedDate().getYear() + 5, card.getExpiryDate().getYear());
    }
}
