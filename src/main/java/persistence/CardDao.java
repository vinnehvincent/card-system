package persistence;

import model.Card;

import javax.persistence.*;

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
        Query query = entityManager.createQuery("SELECT c FROM Card c WHERE c.cardNumber = :cardNumber");
        query.setParameter("cardNumber",cardNumber);
        return (Card) query.getSingleResult();
    }
}
