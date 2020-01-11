package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardHolderTest {
    @Test
    public void aCardHolderMustAlwaysBelinkedToACard(){
        CardHolder cardHolder = new CardHolder();
        assertTrue(cardHolder.getCards().size() > 0);
    }
    @Test
    public void aCardHolderMustHaveAMaximumOf1PrimaryCardAndUpTo6SecondaryCards(){
        CardHolder cardHolder = new CardHolder();
        for (int i = 0; i < 7; i++){
            Card card = new Card();
            cardHolder.addSecondaryCard(card);
        }
        assertNotNull(cardHolder.getPrimaryCard());
        assertEquals(6, cardHolder.getSecondaryCards().size());
    }

}
