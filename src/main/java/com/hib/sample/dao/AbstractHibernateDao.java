package com.hib.sample.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractHibernateDao<T, ID extends Serializable> {
    T findById(ID id, boolean lock);
    
    List<T> findAll();
    
    T makePersistent(T entity);
 
    void makeTransient(T entity);
    
    public void flush();
}
