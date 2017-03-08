/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public interface UserDao {
 
    void create(User u);
    
    void update(User u);
    
    void delete(Long id);

    User find(Long id);
    
    List<User> findAll();
    
    List<User> findAllFollowers(Long id);
    
    List<User> findAllFollowings(Long id);    
    
    User getFollower(Long id);
    
    User getFollowings(Long id);
    
    void setPassword(Long id , String password);
}
