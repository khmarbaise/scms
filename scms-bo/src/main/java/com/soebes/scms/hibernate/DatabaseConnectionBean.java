package com.soebes.scms.hibernate;

/**
 * This class is just a container to store the
 * information about the database connections.
 * This is done, cause we have this information
 * stored in different sources.
 * @author Karl Heinz Marbaise
 *
 */
public class DatabaseConnectionBean {
    private String url;
    private String username;
    private String password;
    private String driverclass;
    private String dialect;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDriverclass() {
        return driverclass;
    }
    public void setDriverclass(String driverclass) {
        this.driverclass = driverclass;
    }
    public String getDialect() {
        return dialect;
    }
    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

}
