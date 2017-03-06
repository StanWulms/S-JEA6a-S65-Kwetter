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
public class PostingTest {
    
    private Posting posting;
    private User user;
    private ArrayList<Comment> comments;
    
    public PostingTest() {
    }
    
    @Before
    public void setUp() {
        user = new User("SetUp");
        posting = new Posting(user,"SetUpTitle","SetUpContent");
    }

    /**
     * Test method for testing the getAuthor method of the Posting class
     */
    @Test
    public void testGetAuthor()
    {
        System.out.println("-- Get Author --");
        String expResult = user.getUserName();
        String result = posting.getAuthor().getUserName();
        assertEquals("ExpResult and Result are not equal", expResult, result);
    }
    
    @Test
    public void testSetAuthor()
    {
        System.out.println("-- Set Author --");
        posting.setAuthor(new User("TestAuthor"));
        String expResult = "TestAuthor";
        String result = posting.getAuthor().getUserName();
        
        assertEquals("ExpResult and Result are not equal", expResult, result);
    }
}
