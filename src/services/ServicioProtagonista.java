package service;

import config.HibernateConfig;
import model.Protagonista;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServicioProtagonista {
    public void actualizarProtagonista(Protagonista protagonista) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(protagonista);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro : " + e.getMessage());
        }
    }

    public void borrarTodosOsProtagonistas() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createMutationQuery("DELETE FROM Protagonista").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro : " + e.getMessage());
        }
    }
}