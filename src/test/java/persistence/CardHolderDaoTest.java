package persistence;

import model.CardHolder;
import org.junit.After;
import org.junit.Test;

import java.sql.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CardHolderDaoTest {
    @Test
    public void shouldPersistCardHolder() {
        CardHolder cardHolder = new CardHolder("9005273445080","Mr","Vinneh","da Vinci",new Date());
        CardHolderDao cardHolderDao = new CardHolderDao();
        cardHolderDao.save(cardHolder);
        CardHolder persistedCardHolder = cardHolderDao.getCardHolderByID(cardHolder.getId());
        assertNotNull(persistedCardHolder);
        assertEquals(1, persistedCardHolder.getCards().size());
    }
    @After
    public void teardown() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM PUBLIC.CARDHOLDERS");
    }
}