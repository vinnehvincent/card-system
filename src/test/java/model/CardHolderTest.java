package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardHolderTest {
    @Test
    public void aCardHolderMustAlwaysBeLinkedToACard(){
        CardHolder cardHolder = new CardHolder();
        assertEquals(1, cardHolder.getCards().size());
        assertNotNull(cardHolder.getPrimaryCard());
    }
    @Test(expected = Exception.class)
    public void aCardHolderCannotHaveNoMoreThan1PrimaryCardAnd6SecondaryCards() throws Exception {
        CardHolder cardHolder = new CardHolder();
        for (int i = 0; i<= 7; i++)
            cardHolder.addSecondaryCard();

    }
}
