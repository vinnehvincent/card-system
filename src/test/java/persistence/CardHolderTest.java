package persistence;

import model.CardHolder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CardHolderTest {
    @Test
    public void shouldPersistCardHolder() {
        CardHolder cardHolder = new CardHolder();
        CardHolderDao cardHolderDao = new CardHolderDao();
        cardHolderDao.save(cardHolder);
        CardHolder persistedCardHolder = cardHolderDao.getCardHolderByID(cardHolder.getId());
        assertNotNull(persistedCardHolder);
        assertEquals(1, persistedCardHolder.getCards().size());
    }
}