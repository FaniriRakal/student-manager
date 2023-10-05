package student.manager.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private HibernateUtil() {
    }

    private static SessionFactory sessionFactory;
    public static void init() {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            LogUtil.logError("HibernateUtil.init", e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void rollback(Transaction transaction) {
        if (transaction != null && transaction.isActive()) {
            try {
                transaction.rollback();
            } catch (Exception e) {
                LogUtil.logError("HibernateUtil.getSessionFactory", e.getMessage());
            }
        }
    }

    public static void closeSession(Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (Exception e) {
                LogUtil.logError("HibernateUtil.closeSession", e.getMessage());
            }
        }
    }
    public static Session createSession() {
        SessionFactory sessionFactory = getSessionFactory();
        return sessionFactory.openSession();
    }
}
