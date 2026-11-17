package service;

import config.HibernateConfig;
import model.Comic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ServicioComic {
    public void insertarComic(Comic comic) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(comic);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro : " + e.getMessage());
        }
    }

    public List<Comic> listarComics() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM Comic", Comic.class).list();
        }
    }

    public void borrarTodosOsComics() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Comic").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro : " + e.getMessage());
        }
    }
}