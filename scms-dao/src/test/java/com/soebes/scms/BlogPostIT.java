package com.soebes.scms;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.soebes.scms.bo.blog.BlogPostBO;

public class BlogPostIT {
    private EntityManager entityManager;
    private EntityManagerFactory programmaticEmf;

    @BeforeTest
    public void beforeTest() {
        Map<String, Object> configOverrides = new HashMap<String, Object>();
        programmaticEmf = Persistence.createEntityManagerFactory("manager1", configOverrides);
        entityManager = programmaticEmf.createEntityManager();
    }
    
    @AfterTest
    public void afterTest() {
        entityManager.close();
        programmaticEmf.close();
    }

    @Test
    public void testFirst() {
        
        BlogPostBO bp = new BlogPostBO();
        bp.setPost("This is the first post.");
        bp.setTitle("This is the title of the first post.");
        entityManager.persist(bp);
    }

}
