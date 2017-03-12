/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PostingDao;
import dao.PostingDaoImp;
import dao.PostingDaoJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public class PostingService {
    private final PostingDao postingDao;

    public PostingService() {
        this.postingDao = PostingDaoImp.getPostingDao();
    }

    public PostingService(EntityManager em) {
        this.postingDao = PostingDaoJPAImp.getPostingDao(em);
    }
    
    
    
    public void addPosting(Posting p) {
        if(p.getContent().length() > 140) {
            throw new IllegalArgumentException("Content cannot be longer than 140 characters");
        } else {
            postingDao.create(p);    
        }
        
    }
    
    public void editPosting(Posting p) {
        if(p.getContent().length() > 140) {
            throw new IllegalArgumentException("Content cannot be longer than 140 characters");
        } else {
            postingDao.update(p);
        }
        
    }
    
    public void removePosting(Long id) {
        postingDao.delete(id);
    }

    public List<Posting> getPostings(User u) {
        return postingDao.findAll(u);
    }
    
    public Posting getPosting(Long id) {
        return postingDao.find(id);
    }
    
}
