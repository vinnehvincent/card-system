package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardHolderTest {
    @Test
    public void aCardHolderMustAlwaysBelinkedToACard(){
        CardHolder cardHolder = new CardHolder();
        assertTrue(cardHolder.getCards().size() > 0);
    }
    @Test(expected = Exception.class)
    public void aCardHolderCannotHaveNoMoreThan1PrimaryCardAnd6SecondaryCards() throws Exception {
        CardHolder cardHolder = new CardHolder();
        for (int i = 0; i<= 7; i++)
            cardHolder.addSecondaryCard();

    }
}
