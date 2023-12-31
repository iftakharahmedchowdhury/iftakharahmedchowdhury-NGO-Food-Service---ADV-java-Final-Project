package dev.repository.Admin;

import dev.domain.DeliveryMan.StoredFoodItem;
import dev.domain.User.Role;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class InventoryTrackingRepo {
    private SessionFactory sessionFactory;

    public InventoryTrackingRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(StoredFoodItem sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(StoredFoodItem sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        StoredFoodItem sf = findById(id);
        session.delete(sf);
    }

    public List<StoredFoodItem> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<StoredFoodItem> userQuery = session.createQuery("from StoredFoodItem", StoredFoodItem.class);
        return userQuery.getResultList();
    }

    public StoredFoodItem findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StoredFoodItem.class, id);
    }

    public StoredFoodItem findByItemName(String item) {
        Session session = sessionFactory.getCurrentSession();
        Query<StoredFoodItem> query = session.createQuery("from StoredFoodItem where itemName = :item", StoredFoodItem.class);
        query.setParameter("item", item);

        try {
            return query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            return null;
        }
    }




}
