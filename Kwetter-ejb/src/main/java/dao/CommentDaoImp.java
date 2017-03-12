/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import model.Comment;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public class CommentDaoImp implements CommentDao {
    
    private static CommentDaoImp instance = null;
    private ConcurrentHashMap<Long, Comment> comments;
    private AtomicLong nextId = new AtomicLong(0L);
    
    public static synchronized CommentDao getCommentDao() {
        if (instance == null) {
            instance = new CommentDaoImp();
        }

        return instance;
    }

    private CommentDaoImp() {
    }

    @Override
    public void create(Comment c) {
        if (c == null) {
            throw new IllegalArgumentException("Comment is null");
        }
        c.setId(nextId.getAndIncrement());
        comments.put(c.getId(), c);
    }

    @Override
    public void update(Comment c) {
        if (c.getContent()== null || c.getPoster()== null) {
            throw new IllegalArgumentException("Content or Poster is null");
        }
        if (!comments.containsKey(c.getId())) {
            throw new IllegalArgumentException("Id not found: " + c.getId());
        }

        Comment c2 = comments.get(c.getId());
        c2.setPoster(c.getPoster());
        c2.setPost(c.getPost());
        c2.setContent(c.getContent());
    }

    @Override
    public void delete(Long id) {
        if (!comments.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }

        comments.remove(id);
    }

    @Override
    public List<Comment> findAll(Posting p) {
        return new ArrayList(comments.values());
    }

    @Override
    public Comment find(Long id) {
        if (!comments.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }
        return comments.get(id);
    }
}
