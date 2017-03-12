/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Posting;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stan
 */
public class UserServiceTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("kwetterPU");
    EntityManager  em;
    
    UserService userService;
    
    private User user = null;
    private User user2 = null;
    private Posting posting = null;
    private List<User> followers = new ArrayList<User>();
    private List<User> followings = new ArrayList<User>();
    private List<Posting> tweets = new ArrayList<Posting>();
    
    public UserServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        em  = emf.createEntityManager();
        userService = new UserService(em);
        
        user = new User("StanWulms");
        user.setId(1L);
        
        user2 = new User("TestSubject");
        user2.setId(2L);
        userService.addUser(user2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        userService.addUser(user);
        assertEquals(user, userService.find(user.getId()));
    }

    /**
     * Test of removeUser method, of class UserService.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        userService.removeUser(user2.getId());
        assertNull(userService.find(user2.getId()));
    }

    /**
     * Test of editUser method, of class UserService.
     */
    @Test
    public void testEditUser() {
        System.out.println("editUser");
        String url = "http://testURL.com";
        user.setWebsite(url);
        userService.editUser(user);
        assertSame(user.getWebsite(), url);
    }

    /**
     * Test of find method, of class UserService.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        userService.addUser(user);
        User userFind = userService.find(user.getId());
        assertSame(userFind, user);
    }

    /**
     * Test of findAllFollowers method, of class UserService.
     */
//    @Test
//    public void testFindAllFollowers() {
//        System.out.println("findAllFollowers");
//        userService.addUser(user2);
//        user.addFollowers(user2);
//        userService.editUser(user);
//        assertSame(user2, user.getFollowers().indexOf(0));
//    }

//    /**
//     * Test of findAllFollowings method, of class UserService.
//     */
//    @Test
//    public void testFindAllFollowings() {
//        System.out.println("findAllFollowings");
//        Long id = null;
//        UserService instance = new UserService();
//        List<User> expResult = null;
//        List<User> result = instance.findAllFollowings(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFollower method, of class UserService.
//     */
//    @Test
//    public void testGetFollower() {
//        System.out.println("getFollower");
//        Long id = null;
//        UserService instance = new UserService();
//        User expResult = null;
//        User result = instance.getFollower(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFollowings method, of class UserService.
//     */
//    @Test
//    public void testGetFollowings() {
//        System.out.println("getFollowings");
//        Long id = null;
//        UserService instance = new UserService();
//        User expResult = null;
//        User result = instance.getFollowings(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPassword method, of class UserService.
//     */
//    @Test
//    public void testSetPassword() {
//        System.out.println("setPassword");
//        Long id = null;
//        String password = "";
//        UserService instance = new UserService();
//        instance.setPassword(id, password);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
