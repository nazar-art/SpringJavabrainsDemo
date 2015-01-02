package com.spring.database.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

    public static final String SELECT_COUNT_FROM_CIRCLE = "select count(*) from Circle";
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int getCircleCount() {
        Query query = getSessionFactory().openSession().createQuery(SELECT_COUNT_FROM_CIRCLE);
        return ((Long)query.uniqueResult()).intValue();
    }
}
