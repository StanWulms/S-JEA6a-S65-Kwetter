/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class UserTest {
//    private User user = null;
//    private Posting posting = null;
//    private ArrayList<User> followers = new ArrayList<User>();
//    private ArrayList<User> followings = new ArrayList<User>();
//    private ArrayList<Posting> tweets = new ArrayList<Posting>();
//    
//    public UserTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        user = new User("SetUp");
//        
//        //create a set of followers / followings / tweets beforehand.
//        for (int i = 0; i < 10; i++) {
//            User u = new User("User" + i);
//            followers.add(u);
//            followings.add(u);
//        }
//        user.setFollowers(followers);
//        user.setFollowings(followings);
//        
//        for (int i = 0; i < 10; i++) {
//            Posting p = new Posting(user,"TestTitle" + i, "TestContent number" + i);
//            tweets.add(p);
//        }
//        user.setTweets(tweets);
//    }
//    
//    /**
//     * Test method for testing the setId method of the User class
//     */
//    @Test
//    public void testSetId()
//    {
//        System.out.println("-- Set Id --");
//        Long id = 1234L;
//        user.setId(id);
//        Long expResult = id;
//        Long result = user.getId();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    @Test
//    public void testGetId()
//    {
//        System.out.println("-- Get Id --");
//        Long id = 12345L;
//        user.setId(id);
//        Long expResult = id;
//        Long result = user.getId();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//
//    /**
//     * Test method for testing the getUserName method of the User class
//     */
//    @Test
//    public void testGetUserName()
//    {
//        System.out.println("-- Get UserName --");
//        String expResult = "SetUp";
//        String result = user.getUserName();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the setUserName method of the User class
//     */
//    @Test
//    public void testSetUserName()
//    {
//        System.out.println("-- Set UserName --");
//        user.setUserName("NewUserName");
//        String expResult = "NewUserName";
//        String result = user.getUserName();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the setPassword method of the User class
//     */
//    @Test
//    public void testSetPassword()
//    {
//        System.out.println("-- Set Password --");
//        user.setPassword("pass123");
//        String expResult = "pass123";
//        String result = user.getPassword();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    /**
//     * Test method for testing the getPassword method of the User class
//     */
//    @Test
//    public void testGetPassword()
//    {
//        System.out.println("-- Get Password --");
//        user.setPassword("pass1234");
//        String expResult = "pass1234";
//        String result = user.getPassword();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the setBio method of the User class
//     */
//    @Test
//    public void testSetBio()
//    {
//        System.out.println("-- Set Bio --");
//        user.setBio("ThisIsABiography");
//        String expResult = "ThisIsABiography";
//        String result = user.getBio();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the getBio method of the User class
//     */
//    @Test
//    public void testGetBio()
//    {
//        System.out.println("-- Get Bio --");
//        user.setBio("biography");
//        String expResult = "biography";
//        String result = user.getBio();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the setFollowers method of the User class
//     */
//    @Test
//    public void testSetFollowers()
//    {
//        System.out.println("-- Set Followers --");
//        int expResult = followers.size();
//        int result = user.getFollowers().size();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the getFollowers method of the User class
//     */
//    @Test
//    public void testGetFollowers()
//    {
//        System.out.println("-- Get Followers --");
//        int expResult = followers.size();
//        int result = user.getFollowers().size();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the setFollowings method of the User class
//     */
//    @Test
//    public void testSetFollowings()
//    {
//        System.out.println("-- Set Followings --");
//        int expResult = followings.size();
//        int result = user.getFollowings().size();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    
//    /**
//     * Test method for testing the getFollowings method of the User class
//     */
//    @Test
//    public void testGetFollowings()
//    {
//        System.out.println("-- Get Followings --");
//        int expResult = followings.size();
//        int result = user.getFollowings().size();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the setTweets method of the User class
//     */
//    @Test
//    public void testSetTweets()
//    {
//        System.out.println("-- Set Tweets --");
//        int expResult = tweets.size();
//        int result = user.getTweets().size();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    /**
//     * Test method for testing the getTweets method of the User class
//     */
//    @Test
//    public void testGetTweets()
//    {
//        System.out.println("-- Get Tweets --");
//        int expResult = tweets.size();
//        int result = user.getTweets().size();
//        assertEquals("ExpectedResult and Result are not equal", expResult, result);
//    }
//    
//    @Test
//    public void testEquals()
//    {
//        System.out.println("-- Equals --");
//        User test1 = new User("Test1");
//        User test2 = new User("Test2");
//        Long id = 123L;
//        Long id2 = 1234L;
//        user.setId(id);
//        test1.setId(id);
//        test2.setId(id2);
//        
//        assertFalse(user.equals(test2));
//        assertTrue(user.equals(test1));
//        assertTrue(user.equals(user));
//    }
}
