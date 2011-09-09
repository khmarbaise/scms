package com.soebes.scms.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.soebes.scms.bo.blog.BlogPostBO;

public class HibernateUtil {
    private static Logger LOGGER = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory factory = null;

    public static Configuration getInitializedConfiguration() {
        LOGGER.debug("HibernateUtil()");
        AnnotationConfiguration config = new AnnotationConfiguration();

        // Here we define all annotated classes.
        config.addAnnotatedClass(BlogPostBO.class);

        HibernateConfig.getInstance().configure(config);
        config.setProperty("hibernate.current_session_context_class",
                "org.hibernate.context.ThreadLocalSessionContext");
        LOGGER.debug("HibernateUtil(done)");

        return config;
    }

    public static Session getSession() {
        if (factory == null) {
            Configuration config = HibernateUtil.getInitializedConfiguration();
            factory = config.buildSessionFactory();
        }
        Session hibernateSession = factory.getCurrentSession();
        return hibernateSession;
    }

    public static void closeSession() {
        HibernateUtil.getSession().close();
    }

    public static Session beginTransaction() {
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }

    public static void commitTransaction() {
        HibernateUtil.getSession().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        HibernateUtil.getSession().getTransaction().rollback();
    }

    public static void save(Object item) {
        beginTransaction();
        getSession().saveOrUpdate(item);
        commitTransaction();
    }

}
