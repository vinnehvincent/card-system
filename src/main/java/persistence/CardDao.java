package persistence;

import model.Card;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CardDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("card-system");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Card card) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(card);
        tx.commit();
    }

    public Card get(String cardNumber) {
        return null;

    }
}
