package com.dao.impl;

import com.dao.intf.CountryDao;
import com.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class CountryDaoImpl implements CountryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Country content) {
        em.persist(content);
    }

    @Override
    public List<Country> getAll() {
        return em.createQuery("from Country", Country.class).getResultList();
    }
}
