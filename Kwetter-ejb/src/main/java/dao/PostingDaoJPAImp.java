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
public class PostingDaoJPAImp implements PostingDao {

    private final EntityManager em;
    private static PostingDaoJPAImp instance = null;
    
    public PostingDaoJPAImp(EntityManager em)
    {
        this.em = em;
    }
    
    public static synchronized PostingDaoJPAImp getPostingDao(EntityManager em)
    {
        if(instance == null) {
            instance = new PostingDaoJPAImp(em);
        }
        
        return instance;
    }
    @Override
    public void create(Posting p) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Posting p) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            em.merge(p);
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
            Posting p = em.find(Posting.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Posting> findAll(User u) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            Query q = em.createNamedQuery("Posting.findAll", Posting.class);
            q.setParameter("author", u);
            return (List<Posting>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Posting find(Long id) {
        try {
            Posting p = em.find(Posting.class, id);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return null;
    }
    
}
