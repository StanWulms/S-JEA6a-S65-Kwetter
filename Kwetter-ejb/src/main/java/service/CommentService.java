/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CommentDao;
import dao.CommentDaoJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import model.Comment;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public class CommentService {
    
    private final CommentDao commentDao;
    
    public CommentService(EntityManager em)
    {
        this.commentDao = CommentDaoJPAImp.getCommentDao(em);
    }
    
    public void addComment(Comment c)
    {
        if(find(c.getId()) == null) {
            if(c.getContent()!= null && c.getContent().length() > 140) {
                throw new IllegalArgumentException("Content cannot be longer than 140 characters");
            } else {
                commentDao.create(c);    
            }
            
        } else {
            throw new IllegalArgumentException("Id not found: " + c.getId());
        }
    }
    
    public void editComment(Comment c)
    {
//        if(find(c.getId()) != null) {
            if(c.getContent()!= null && c.getContent().length() > 140) {
                throw new IllegalArgumentException("Content cannot be longer than 140 characters");
            } else {
                commentDao.update(c);    
            }  
//        } else {
//            throw new IllegalArgumentException("Id not found: " + c.getId());
//        }
    }
    
    public void removeComment(Long id)
    {
        //if(find(id) != null) {
            commentDao.delete(id);    
        //} else {
         //   throw new IllegalArgumentException("Id not found: " + id);
        //}
    }
    
    public Comment find(Long id){
        return commentDao.find(id);
    };
    
    public List<Comment> findAll(Posting p) {
        return commentDao.findAll(p);
    }
    
}
