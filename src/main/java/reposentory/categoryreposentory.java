package reposentory;

import config.hibernet;
import entity.category;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class categoryreposentory {
    public List<category> getAll() {
        Session session = hibernet.getFACTORY().openSession();
        List<category> list = session.createQuery("FROM category").list();
        session.close();
        return list;
    }

    public boolean add(category category) {
        Transaction transaction = null;

        try (Session session = hibernet.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new categoryreposentory().getAll());
    }
}
