package com.soebes.scms.hibernate;

import java.util.logging.Logger;

/**
 * This class will handle all Hibernate properties.
 *
 * @author Karl Heinz Marbaise
 */
public class HibernateConfig {
    private static Logger LOGGER = Logger.getLogger(HibernateConfig.class);

    private DatabaseConnectionBean bean = null;

    private static HibernateConfig configuration = null;

    private final static String PREFIX = "hibernate.connection.";

    public final static String CONNECTION_URL = PREFIX + "url";
    public final static String CONNECTION_PASSWORD = PREFIX + "password";
    public final static String CONNECTION_USERNAME = PREFIX + "username";
    public final static String CONNECTION_DRIVER_CLASS = PREFIX + "driver_class";
    public final static String CONNECTION_DIALECT = "hibernate.dialect";

    /**
     * Make this constructor private to prevent
     * other to create their instances.
     */
    private HibernateConfig () {
        bean = null;
    }

    public static HibernateConfig getInstance() {
        if (configuration == null) {
            configuration = new HibernateConfig();
            //We load the information about the configuration from property file.
            //as first level of initialization.
            configuration.setBean(Property.getConnection());
        }
        return configuration;
    }

    public void configure(AnnotationConfiguration cfg) {
        cfg.setProperty(CONNECTION_URL, bean.getUrl());
        cfg.setProperty(CONNECTION_PASSWORD, bean.getPassword());
        cfg.setProperty(CONNECTION_USERNAME, bean.getUsername());
        cfg.setProperty(CONNECTION_DRIVER_CLASS, bean.getDriverclass());
        cfg.setProperty(CONNECTION_DIALECT, bean.getDialect());
        LOGGER.debug(
                "\n"
                +	CONNECTION_URL + " = " + bean.getUrl() + "\n"
                +	CONNECTION_PASSWORD + " = ;-) ;-)" + "\n"
                +	CONNECTION_USERNAME + " = " + bean.getUsername() + "\n"
                +	CONNECTION_DRIVER_CLASS + " = " + bean.getDriverclass() + "\n"
                +	CONNECTION_DIALECT + " = " + bean.getDialect() + "\n"
        );
    }

    public DatabaseConnectionBean getBean() {
        return this.bean;
    }

    public void setBean(DatabaseConnectionBean bean) {
        this.bean = bean;
    }

}
