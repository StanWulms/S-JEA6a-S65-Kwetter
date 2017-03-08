/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        user = new User("SetUp");
        posting = new Posting(user,"SetUpTitle","SetUpContent");
    }

    @After
    public void tearDown() throws Exception {
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

    /**
     * Test of getComments method, of class Posting.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        Posting instance = null;
        List<Comment> expResult = null;
        List<Comment> result = instance.getComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addComment method, of class Posting.
     */
    @Test
    public void testAddComment() {
        System.out.println("addComment");
        String message = "";
        Posting instance = null;
        instance.addComment(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class Posting.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Posting instance = null;
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class Posting.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "";
        Posting instance = null;
        instance.setContent(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Posting.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Posting instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Posting.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Posting instance = null;
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Posting.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Posting instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Posting.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Posting instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Posting.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Posting instance = null;
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
