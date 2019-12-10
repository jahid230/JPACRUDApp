package com.demoPackage.restapi.dao;

import com.demoPackage.restapi.models.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDAO {
	
	@PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public void update(User user) {
        em.merge(user);
    }

    public void create(User user) {
        em.persist(user);
    }

    public void delete(User user) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }

        em.remove(user);
    }
}
