/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Posting;

/**
 *
 * @author Stan
 */
public interface PostingDao {
    
    Posting create(Posting p);
    
    Posting update(Long id, String author, String title, String content);
    
    void delete(Long id);

    List<Posting> findAll();

    Posting find(Long id);
}
