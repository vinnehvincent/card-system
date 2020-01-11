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
    @Test(expected = Exception.class)
    public void onceActivatedACardWillNeverBeSetToInactiveAgain() throws Exception {
        card.setStatus(ACTIVE);
        card.setStatus(INACTIVE);
    }
    @Test(expected = Exception.class)
    public void onceCLOSEDaCardStatusCannotBeChangedAgain() throws Exception {
        card.setStatus(CLOSED);
        card.setStatus(ACTIVE);
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
