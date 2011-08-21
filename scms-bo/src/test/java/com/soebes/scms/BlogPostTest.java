package com.soebes.scms;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.Test;

import com.soebes.scms.bo.BlogPostBO;

public class BlogPostTest {

    @Test
    public void testFirst() {
        Map<String, Object> configOverrides = new HashMap<String, Object>();
        EntityManagerFactory programmaticEmf = Persistence.createEntityManagerFactory("manager1", configOverrides);
        EntityManager em = programmaticEmf.createEntityManager();
        
        BlogPostBO bp = new BlogPostBO();
        bp.setPost("This is the first post.");
        bp.setTitle("This is the title of the first post.");
        em.persist(bp);
        em.close();
    }
}
