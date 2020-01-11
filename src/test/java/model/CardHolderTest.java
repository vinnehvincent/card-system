package model;

import org.junit.Assert;
import org.junit.Test;

public class CardHolderTest {
    @Test
    public void aCardHolderMustAlwaysBelinkedToACard(){
        CardHolder cardHolder = new CardHolder();
        Assert.assertTrue(cardHolder.getCards().size() > 0);
    }
}
