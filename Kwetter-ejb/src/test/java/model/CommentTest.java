/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
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
public class CommentTest {
    
    public CommentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Comment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Comment instance = null;
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Comment.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long Id = null;
        Comment instance = null;
        instance.setId(Id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class Comment.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Comment instance = null;
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class Comment.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "";
        Comment instance = null;
        instance.setContent(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Comment.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Comment instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Comment.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Comment instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoster method, of class Comment.
     */
    @Test
    public void testGetPoster() {
        System.out.println("getPoster");
        Comment instance = null;
        User expResult = null;
        User result = instance.getPoster();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPoster method, of class Comment.
     */
    @Test
    public void testSetPoster() {
        System.out.println("setPoster");
        User poster = null;
        Comment instance = null;
        instance.setPoster(poster);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPost method, of class Comment.
     */
    @Test
    public void testGetPost() {
        System.out.println("getPost");
        Comment instance = null;
        Posting expResult = null;
        Posting result = instance.getPost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPost method, of class Comment.
     */
    @Test
    public void testSetPost() {
        System.out.println("setPost");
        Posting post = null;
        Comment instance = null;
        instance.setPost(post);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
