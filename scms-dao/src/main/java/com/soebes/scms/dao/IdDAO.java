package com.soebes.scms.dao;

import java.util.List;

import com.soebes.scms.bo.BaseBO;

/**
 * This class will define the interface for all operations which
 * can be done on the Database. This will define the primary key
 * as a Long object.
 *
 * @author Karl Heinz Marbaise
 *
 * @param <T> The parameter type which is used.
 */
public class IdDAO<T extends BaseBO> extends HibernateDAO<T, Long> {

    public IdDAO(Class<T> c) {
        super(c);
    }

    public List<T> get() {
        return super.get();
    }

    public T get(Long id) {
        return super.get(id);
    }

    public List<T> getByExample(T example, String[] excludeProperties) {
        //FIXME: Implement Exception handling
        return super.getByExample(example, excludeProperties);
    }

    public void remove(Long id) {
        //FIXME: Implement Exception handling
        super.remove(id);
    }

    public void remove(T entity) {
        //FIXME: Implement Exception handling
        super.remove(entity);
    }

    public T save(T entity) {
        //FIXME: Implement Exception handling
        return super.save(entity);
    }

    public T saveWithoutTransaction(T item) {
        return super.saveWithoutTransaction(item);
    }

}
