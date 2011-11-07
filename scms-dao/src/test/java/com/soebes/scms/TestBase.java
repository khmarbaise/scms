package com.soebes.scms;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    private EntityManager entityManager;
    private EntityManagerFactory programmaticEmf;

    @BeforeClass
    public void beforeSuite() {
        programmaticEmf = Persistence.createEntityManagerFactory("manager1");
        entityManager = programmaticEmf.createEntityManager();
    }

    @AfterClass
    public void afterSuite() {
        entityManager.close();
        programmaticEmf.close();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
