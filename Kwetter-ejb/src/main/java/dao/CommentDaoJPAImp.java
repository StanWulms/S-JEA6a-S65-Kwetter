/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Comment;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public class CommentDaoJPAImp implements CommentDao{

    private final EntityManager em;
    
    private static CommentDaoJPAImp instance = null;
    
    public CommentDaoJPAImp(EntityManager em)
    {
        this.em = em;
    }
    
    public static synchronized CommentDaoJPAImp getCommentDao(EntityManager em)
    {
        if(instance == null) {
            instance = new CommentDaoJPAImp(em);
        }
        
        return instance;
    }
    
    @Override
    public void create(Comment c) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Comment c) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            em.merge(c);
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
            Comment c = em.find(Comment.class, id);
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Comment> findAll(Posting p) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            Query q = em.createNamedQuery("Comment.findAll", Comment.class);
            q.setParameter("post", p);
            return (List<Comment>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Comment find(Long id) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            Comment c = em.find(Comment.class, id);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return null;
    }
    
}
