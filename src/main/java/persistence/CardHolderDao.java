package persistence;

import model.CardHolder;

import javax.persistence.*;

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
        Query query = entityManager.createQuery("SELECT ch from CardHolder ch where ch.govId = :id");
        query.setParameter("id",id);
        return (CardHolder) query.getSingleResult();
    }
}
