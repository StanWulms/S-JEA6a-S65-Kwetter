/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public class UserDaoJPAImp implements UserDao {

    private final EntityManager em;
    
    private static UserDaoJPAImp instance = null;
    
    public UserDaoJPAImp(EntityManager em)
    {
        this.em = em;
    }
    
    public static synchronized UserDaoJPAImp getUserDao(EntityManager em)
    {
        if(instance == null) {
            instance = new UserDaoJPAImp(em);
        }
        
        return instance;
    }

    @Override
    public void create(User u) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(User u) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            User u = em.find(User.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public User find(Long id) {
        try {
            User u = em.find(User.class, id);
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            Query q = em.createNamedQuery("User.findAll", Posting.class);
            return (List<User>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<User> findAllFollowers(Long id) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        Query q =  em.createNamedQuery("User.findAllFollowers",User.class);
        q.setParameter("followers", id);
        return (List<User>) q.getResultList();
    }

    @Override
    public List<User> findAllFollowings(Long id) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        Query q =  em.createNamedQuery("User.findAllFollowings",User.class);
        q.setParameter("followings", id);
        return (List<User>) q.getResultList();
    }

    @Override
    public User getFollower(Long id) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        Query q =  em.createNamedQuery("User.getFollower",User.class);
        q.setParameter("id", id);
        return (User) q.getResultList();
    }

    @Override
    public User getFollowings(Long id) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
         Query q =  em.createNamedQuery("User.getFollowings",User.class);
        q.setParameter("id", id);
        return (User) q.getResultList();
    }

    @Override
    public void setPassword(Long id, String password) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        Query q =  em.createNamedQuery("User.setPassword",User.class);
        q.setParameter("id",id);
        q.setParameter("password", password);
    }
    
}
