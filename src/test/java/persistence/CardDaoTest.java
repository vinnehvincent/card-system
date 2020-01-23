package persistence;

import model.Card;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CardDaoTest {
    @Test
    public void shouldPersistNewCard(){
        Card card = new Card();
        CardDao cardDao = new CardDao();
        cardDao.save(card);
        Card persistedCard = cardDao.get(card.getCardNumber());
        Assert.assertNotNull(persistedCard.getId());
    }
    @Test
    public void teardown() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM PUBLIC.CARDS");
    }
}
