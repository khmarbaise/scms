package com.soebes.scms;

import java.util.UUID;

import org.testng.annotations.Test;

import com.soebes.scms.bo.blog.CommentBO;

public class CommentTest extends TestBase {

    @Test
    public void testFirst() {
        
        CommentBO bp = new CommentBO();
        bp.setPost("This is the first post.");
        bp.setTitle("This is the title of the first post.");

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(bp);
        getEntityManager().getTransaction().commit();
    }

    @Test
    public void testHundredthOfComments() {
        getEntityManager().getTransaction().begin();
        for(int i=0; i<100;i++) {
            CommentBO bp = new CommentBO();
            bp.setPost("Post:" + UUID.randomUUID().toString());
            bp.setTitle("Title:" + UUID.randomUUID());
            getEntityManager().persist(bp);
        }
        getEntityManager().getTransaction().commit();
    }

}
