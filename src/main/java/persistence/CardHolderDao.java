package persistence;

import model.CardHolder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CardHolderDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("card-system");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(CardHolder cardHolder) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(cardHolder);
        tx.commit();
    }

    public CardHolder getCardHolderByID(String id) {
        return null;
    }
}
