package com.soebes.scms.dao;

import com.soebes.scms.bo.blog.BlogPostBO;

/**
 * This is factory class to create the different DAO instances.
 *
 * @author Karl Heinz Marbase
 *
 */
public final class DAOFactory {

    public static IdDAO<BlogPostBO> getBestellung() {
        return new IdDAO<BlogPostBO>(BlogPostBO.class);
    }
}
