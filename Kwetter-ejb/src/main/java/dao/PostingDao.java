/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public interface PostingDao {
    
    void create(Posting p);
    
    void update(Posting p);
    
    void delete(Long id);

    List<Posting> findAll(User u);

    Posting find(Long id);
}
