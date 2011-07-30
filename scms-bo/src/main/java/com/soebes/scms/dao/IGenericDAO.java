package com.soebes.scms.dao;

import java.io.Serializable;
import java.util.List;

/**
 * This defines an generic DAO interface which will provide
 * the usual CRUD operations.
 *
 * http://www.ibm.com/developerworks/java/library/j-genericdao.html
 * http://www.ibm.com/developerworks/library/j-dao/
 *
 * Very interesting:
 * http://www.dhptech.com/node/18
 *
 * with implementation.
 * http://saloon.javaranch.com/cgi-bin/ubb/ultimatebb.cgi?ubb=get_topic&f=78&t=003917
 *
 * http://www.hiberbook.com/HiberBookWeb/learn.jsp?tutorial=21advanceddaos
 *
 * @author Karl Heinz Marbaise
 *
 * @param <T> The type of the class which will be used for the DAO
 * @param <I> The type of the primary key for objects of such kind of class.
 */
public interface IGenericDAO<T, I extends Serializable> {

   /**
    * Get the object with the particular id.
    *
    * @param id the id of the instance to retrieve.
    * @return the instance with the given id.
    */
    T get(I id);

    /**
     * Get all instances that match the properties that are set in the given
     * object using a standard Query by Example method.
     *
     * @param t the example bean
     * @return a list of beans that match the example.
     */
    List<T> getByExample(T example, String[] exludeProperties);

    /**
     * Get all instances of this bean that have been persisted.
     *
     * @return a list of all instances.
     */
    List<T> get();

    /**
     * Remove the bean passed.
     *
     * @param t the object to remove.
     */
    void remove(T item);

    /**
     * Remove the bean with the given id.
     *
     * @param id the id of the bean to remove.
     */
    void remove(I id);

    /**
     * Persist the given bean.
     *
     * @param t the bean to persist.
     */
    T save(T item);

    /**
     * persist the given bean
     * without an transaction. User has to
     * be responsible for it.
     * @param item
     * @return
     */
    T saveWithoutTransaction(T item);

}