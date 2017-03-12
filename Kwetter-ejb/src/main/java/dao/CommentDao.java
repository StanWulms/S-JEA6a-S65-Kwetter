/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Comment;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public interface CommentDao {
    
    void create(Comment c);
    
    void update(Comment c);
    
    void delete(Long id);

    List<Comment> findAll(Posting p);

    Comment find(Long id);
}
