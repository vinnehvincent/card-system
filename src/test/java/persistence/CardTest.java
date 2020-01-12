package persistence;

import model.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void shouldPersistNewCard(){
        Card card = new Card();
        CardDao cardDao = new CardDao();
        cardDao.save(card);
        Card persistedCard = cardDao.get(card.getCardNumber());
        Assert.assertNotNull(persistedCard.getId());
    }
}
