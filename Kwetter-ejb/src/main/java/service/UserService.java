/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import dao.UserDaoImp;
import java.util.ArrayList;
import java.util.List;
import model.Posting;
import model.User;

/**
 *
 * @author Stan
 */
public class UserService {
    
    private final UserDao userDao;
    
    public UserService()
    {
        this.userDao = UserDaoImp.getUserDao();
    }
    
    public void addUser(User u)
    {
        if(find(u.getId()) == null) {
            if(u.getBio().length() > 160) {
                throw new IllegalArgumentException("Bio cannot be longer than 160 characters");
            } else {
                userDao.create(u);    
            }
            
        } else {
            throw new IllegalArgumentException("Id not found: " + u.getId());
        }
        
    }
    
    public void removeUser(Long id)
    {
        if(find(id) != null) {
            userDao.delete(id);    
        } else {
            throw new IllegalArgumentException("Id not found: " + id);
        }
        
    }
    
    public void editUser(User u)
    {
        if(find(u.getId()) == null) {
            if(u.getBio().length() > 160) {
                throw new IllegalArgumentException("Bio cannot be longer than 160 characters");
            } else {
                userDao.update(u);    
            }  
        } else {
            throw new IllegalArgumentException("Id not found: " + u.getId());
        }
        
    };
        
    
    public User find(Long id){
        return userDao.find(id);
    };
    
    public List<User> findAllFollowers(Long id){
        return userDao.findAllFollowers(id);
    };
    
    public List<User> findAllFollowings(Long id){
        return userDao.findAllFollowings(id);
    };    
    
    public User getFollower(Long id){
        return userDao.getFollower(id);
    };
    
    public User getFollowings(Long id){
        return userDao.getFollowings(id);
    };
    
    public void setPassword(Long id , String password){
        userDao.setPassword(id,password);
    };
}
