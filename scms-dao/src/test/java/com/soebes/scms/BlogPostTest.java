package com.soebes.scms;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.soebes.scms.bo.blog.BlogPostBO;

public class BlogPostTest {
    private EntityManager entityManager;
    private EntityManagerFactory programmaticEmf;

    @BeforeTest
    public void beforeTest() {
        programmaticEmf = Persistence.createEntityManagerFactory("manager1");
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
        
        entityManager.getTransaction().begin();
        entityManager.persist(bp);
        entityManager.getTransaction().commit();
    }

    @Test
    public void testHundredthOfPosts() {
        entityManager.getTransaction().begin();
        for(int i=0; i<100;i++) {
            BlogPostBO bp = new BlogPostBO();
            bp.setPost("Post:" + UUID.randomUUID().toString());
            bp.setTitle("Title:" + UUID.randomUUID());
            entityManager.persist(bp);
        }
        entityManager.getTransaction().commit();
    }
}
