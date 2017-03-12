///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//import model.Posting;
//import model.User;
//
///**
// *
// * @author Stan
// */
//public class UserDaoImp implements UserDao {
//
//    private static UserDaoImp instance = null;
//    private ConcurrentHashMap<Long, User> users;
//    private AtomicLong nextId = new AtomicLong(0L);
//
//    public static synchronized UserDao getUserDao() {
//        if (instance == null) {
//            instance = new UserDaoImp();
//        }
//
//        return instance;
//    }
//        
//    public UserDaoImp() {
//        //todo
//    }
//    
//    
//    @Override
//    public void create(User u) {
//        if (u == null) {
//            throw new IllegalArgumentException("User is null");
//        }
//        u.setId(nextId.getAndIncrement());
//        users.put(u.getId(), u);
//        //return u;
//    }
//
//    @Override
//    public void update(User u) {
//        if (u.getUserName() == null || u.getPassword() == null) {
//            throw new IllegalArgumentException("Username or password is null");
//        }
//        if (!users.containsKey(u.getId())) {
//            throw new IllegalArgumentException("Id not found: " + u.getId());
//        }
//
//        User u2 = users.get(u.getId());
//        u2.setUserName(u.getUserName());
//        u2.setPassword(u.getPassword());
//        u2.setBio(u.getBio());
////        u2.setFollowers(u.getFollowers());
////        u2.setFollowings(u.getFollowings());
////        u2.setTweets(u.getTweets());
//
//        //return u2;
//    }
//
//    @Override
//    public void delete(Long id) {
//        if(users.containsKey(id)){
//           User deleteUser = users.get(id);
//           users.remove(id, deleteUser);
//       }else{
//           throw new IllegalArgumentException("User not found: " + id);
//       }
//    }
//
//    @Override
//    public User find(Long id) {
//        if (!users.containsKey(id)) {
//            throw new IllegalArgumentException("Id not found: " + id);
//        }
//        return users.get(id);
//    }
//    
//    @Override
//    public List<User> findAll() {
//        return new ArrayList(users.values());
//    }
//
//    @Override
//    public List<User> findAllFollowers(Long id) {
//        if (!users.containsKey(id)) {
//            throw new IllegalArgumentException("Id not found: " + id);
//        }
//        return users.get(id).getFollowers();
//    }
//
//    @Override
//    public List<User> findAllFollowings(Long id) {
//        if (!users.containsKey(id)) {
//            throw new IllegalArgumentException("Id not found: " + id);
//        }
//        return users.get(id).getFollowings();
//    }
//
//    @Override
//    public User getFollower(Long id) {
//        if (!users.containsKey(id)) {
//            throw new IllegalArgumentException("Id not found: " + id);
//        }
//        return users.get(id);
//    }
//
//    @Override
//    public User getFollowings(Long id) {
//        if (!users.containsKey(id)) {
//            throw new IllegalArgumentException("Id not found: " + id);
//        }
//        return users.get(id);
//    }
//
//    @Override
//    public void setPassword(Long id, String password) {
//        if (!users.containsKey(id)) {
//            throw new IllegalArgumentException("Id not found: " + id);
//        }
//        User u = users.get(id);
//        u.setPassword(password);
//    }
//    
//}
