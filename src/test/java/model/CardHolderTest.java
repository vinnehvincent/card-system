package model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CardHolderTest {
    @Test
    public void aCardHolderMustAlwaysBeLinkedToACard(){
        CardHolder cardHolder = new CardHolder("9005273445080", "Mr", "Vinneh", "da Vinci", new Date());
        assertEquals(1, cardHolder.getCards().size());
        assertNotNull(cardHolder.getPrimaryCard());
    }
    @Test(expected = Exception.class)
    public void aCardHolderCannotHaveNoMoreThan1PrimaryCardAnd6SecondaryCards() throws Exception {
        CardHolder cardHolder = new CardHolder("9005273445080", "Mr", "Vinneh", "da Vinci", new Date());
        for (int i = 0; i<= 7; i++)
            cardHolder.addSecondaryCard();

    }
}
