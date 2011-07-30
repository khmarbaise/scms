package com.soebes.scms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import com.soebes.scms.bo.BaseBO;
import com.soebes.scms.hibernate.HibernateUtil;

/**
 * An Hibernate implementation for the DAO based on the {@link IGenericDAO}.
 * @author Karl Heinz Marbaise
 *
 * @param <T> Parameter for the type
 * @param <ID> Paramer for the primary key of the class.
 */
public class HibernateDAO<T extends BaseBO, ID extends Serializable>
    implements IGenericDAO<T, ID> {

    private static Logger LOGGER = Logger.getLogger(HibernateDAO.class);

    private static Locale LOCALIZATION = Locale.GERMAN;

    private Class<T> persistentClass;

    public HibernateDAO(Class<T> c) {
        persistentClass = c;
    }

    @SuppressWarnings("unchecked")
    public T get(ID id) {
        HibernateUtil.beginTransaction();
        T result = (T) HibernateUtil.getSession().get(persistentClass, id);
        HibernateUtil.commitTransaction();
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<T> getByExample(T exampleInstance, String[] excludeProperty) {
        HibernateUtil.beginTransaction();
        Criteria crit = HibernateUtil
            .getSession()
            .createCriteria(persistentClass);
        Example example = Example.create(exampleInstance);
        for (int i = 0; i < excludeProperty.length; i++) {
            example.excludeProperty(excludeProperty[i]);
        }
        crit.add(example);
        List<T> result = crit.list();
        HibernateUtil.commitTransaction();
        return result;
    }

    /**
     * @param startIndex
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll(int startIndex) {
        HibernateUtil.beginTransaction();
        Criteria crit = HibernateUtil
            .getSession()
            .createCriteria(persistentClass);
        crit.setFirstResult(startIndex);
        List<T> result = crit.list();
        LOGGER.debug("findAll(" + persistentClass.getSimpleName() + "):" + result.size());
        HibernateUtil.commitTransaction();
        return result;
    }

    public List<T> get() {
        return findAll(0);
    }

    public T save(T entity) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().saveOrUpdate(entity);
        HibernateUtil.commitTransaction();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("save(" + entity.getClass().getSimpleName() + " id:" + entity.getId() + ") done.");
        }
        return entity;
    }

    public T saveWithoutTransaction(T item) {
        HibernateUtil.getSession().saveOrUpdate(item);
        return item;
    }

    public void remove(T entity) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(entity);
        HibernateUtil.commitTransaction();
    }

    public void remove(ID id) {
        T item = this.get(id);
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(item);
        HibernateUtil.commitTransaction();
    }

    public void beginTransaction() {
        HibernateUtil.beginTransaction();
    }

    public void commitTransaction() {
        HibernateUtil.commitTransaction();
    }

    public void rollbackTransaction() {
        HibernateUtil.rollbackTransaction();
    }

}
