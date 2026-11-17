package service;

import config.HibernateConfig;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServicioAutor {
    public void actualizarAutor(Autor autor) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(autor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro : " + e.getMessage());
        }
    }

    public void borrarTodosOsAutores() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Autor").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro : " + e.getMessage());
        }
    }
}