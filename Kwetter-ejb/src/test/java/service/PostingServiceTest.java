/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public class PostingServiceTest {
    
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("kwetterPU");
     EntityManager  em;
    
     PostingService postingService;
     
     private User user;
     private Posting posting1;
     private Posting posting2;
    
    
    public PostingServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        em = emf.createEntityManager();
        postingService = new PostingService(em);
        
        user = new User("Henk");
        posting1 = new Posting(user, "Title", "Content");
        posting2 = new Posting(user, "Title2", "Content2");
        
        postingService.addPosting(posting2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addPosting method, of class PostingService.
     */
    @Test
    public void testAddPosting() {
        System.out.println("addPosting");
        postingService.addPosting(posting1);
        assertEquals(posting1, postingService.getPosting(posting1.getId()));
    }

    /**
     * Test of editPosting method, of class PostingService.
     */
    @Test
    public void testEditPosting() {
        System.out.println("editPosting");
        String content = "editedContent1";
        posting1.setContent(content);
        postingService.editPosting(posting1);
        assertSame(posting1.getContent(), content);
    }

    /**
     * Test of removePosting method, of class PostingService.
     */
    @Test
    public void testRemovePosting() {
        System.out.println("removePosting");
        postingService.removePosting(posting2.getId());
        assertNull(postingService.getPosting(posting2.getId()));
    }

    /**
     * Test of getPostings method, of class PostingService.
     */
    @Test
    public void testGetPostings() {
        System.out.println("getPostings");
        assertTrue("IF posting > 0, it is true", postingService.getPostings(user).size() > 0);
    }

    /**
     * Test of getPosting method, of class PostingService.
     */
    @Test
    public void testGetPosting() {
        System.out.println("getPosting");
        assertEquals(postingService.getPosting(2L).getContent(), "Content2");
    }
    
}
