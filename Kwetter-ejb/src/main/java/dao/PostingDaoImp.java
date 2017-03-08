/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Posting;
import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Stan
 */
public class PostingDaoImp implements PostingDao {

    private static PostingDaoImp instance = null;
    private ConcurrentHashMap<Long, Posting> postings;
    private AtomicLong nextId = new AtomicLong(0L);

    public static synchronized PostingDao getPostingDao() {
        if (instance == null) {
            instance = new PostingDaoImp();
        }

        return instance;
    }

    private PostingDaoImp() {
        //todo
    }


    @Override
    public void create(Posting p) {
        if (p == null) {
            throw new IllegalArgumentException("Posting is null");
        }
        p.setId(nextId.getAndIncrement());
        postings.put(p.getId(), p);
    }

    @Override
    public void update(Posting p) {
        if (p.getAuthor() == null || p.getTitle() == null || p.getContent() == null) {
            throw new IllegalArgumentException("Author, Title or Content is null");
        }
        if (!postings.containsKey(p.getId())) {
            throw new IllegalArgumentException("Id not found: " + p.getId());
        }

        Posting p2 = postings.get(p.getId());
        p2.setAuthor(p.getAuthor());
        p2.setTitle(p.getTitle());
        p2.setContent(p.getContent());

        //return p;
    }

    @Override
    public void delete(Long id) {
        if (!postings.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }

        postings.remove(id);
    }

    @Override
    public List<Posting> findAll(User u) {
        //List<Posting> x = (List<Posting>) postings.values();
        return new ArrayList(postings.values());
    }

    @Override
    public Posting find(Long id) {
        if (!postings.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }
        return postings.get(id);
    }
    
}
