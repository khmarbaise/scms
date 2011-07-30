package com.soebes.scms.hibernate;

import java.util.Properties;
import java.util.logging.Logger;

/**
 * This class will handle the access to the different
 * properties.
 * @author Karl Heinz Marbaise
 */
public class Property {

//TODO: May be we should move the complete code into HibernateConfig file.
    public static final String PROPERTY_FILE = "/database.properties";

    private static Properties properties;

    private static Logger LOGGER = Logger.getLogger(Property.class);

    static {
        properties = new Properties();
        try {
            LOGGER.debug("Start loading " + PROPERTY_FILE);
            properties.load(Property.class.getResourceAsStream(PROPERTY_FILE));
            LOGGER.debug("Successfully loaded " + PROPERTY_FILE + " file.");
        } catch (Exception e) {
            LOGGER.warn("Error while reading the property file " + PROPERTY_FILE + " " + e.getMessage());
        }
    }

    public static DatabaseConnectionBean getConnection() {
        DatabaseConnectionBean bean = new DatabaseConnectionBean();
        bean.setDialect(getDBDialect());
        bean.setDriverclass(getDBDriver());
        bean.setPassword(getDBPassword());
        bean.setUrl(getDBUrl());
        bean.setUsername(getDBUser());
        return bean;
    }

    public static String getDBUrl() {
        return properties.getProperty(HibernateConfig.CONNECTION_URL);
    }
    public static String getDBDriver () {
        return properties.getProperty(HibernateConfig.CONNECTION_DRIVER_CLASS);
    }
    public static String getDBUser () {
        return properties.getProperty(HibernateConfig.CONNECTION_USERNAME);
    }
    public static String getDBPassword () {
        return properties.getProperty(HibernateConfig.CONNECTION_PASSWORD);
    }
    public static String getDBDialect() {
        return properties.getProperty(HibernateConfig.CONNECTION_DIALECT);
    }

    public static Properties getProperties() {
        return properties;
    }
}
