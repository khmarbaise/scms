package com.soebes.scms;

import java.util.UUID;


import org.testng.annotations.Test;

import com.soebes.scms.bo.blog.BlogPostBO;

public class BlogPostTest extends TestBase {
    @Test
    public void testFirst() {
        
        BlogPostBO bp = new BlogPostBO();
        bp.setPost("This is the first post.");
        bp.setTitle("This is the title of the first post.");
        
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(bp);
        getEntityManager().getTransaction().commit();
    }

    @Test
    public void testHundredthOfPosts() {
        getEntityManager().getTransaction().begin();
        for(int i=0; i<100;i++) {
            BlogPostBO bp = new BlogPostBO();
            bp.setPost("Post:" + UUID.randomUUID().toString());
            bp.setTitle("Title:" + UUID.randomUUID());
            getEntityManager().persist(bp);
        }
        getEntityManager().getTransaction().commit();
    }
}
