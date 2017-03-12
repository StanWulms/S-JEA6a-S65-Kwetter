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
import model.Comment;
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
public class CommentServiceTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("kwetterPU");
    EntityManager  em;
    
    CommentService commentService;
    
    private User user;
    private User user2;
    private Posting posting;
    private Comment comment1;
    private Comment comment2;
    
    public CommentServiceTest() {
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
        commentService = new CommentService(em);
        
        user = new User("StanWulms");
        user2 = new User("Bert");
        posting = new Posting(user2, "PostingTitle", "PostingContent");
        
        comment1 = new Comment("Content", user, posting);
        comment2 = new Comment("Content2", user, posting);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addComment method, of class CommentService.
     */
    @Test
    public void testAddComment() {
        System.out.println("addComment");
        commentService.addComment(comment1);
        assertEquals(comment1, commentService.find(comment1.getId()));
    }

    /**
     * Test of editComment method, of class CommentService.
     */
    @Test
    public void testEditComment() {
        System.out.println("editComment");
        String content = "editedContent1";
        comment1.setContent(content);
        commentService.editComment(comment1);
        assertSame(comment1.getContent(), content);
    }

    /**
     * Test of removeComment method, of class CommentService.
     */
    @Test
    public void testRemoveComment() {
        System.out.println("removeComment");
        commentService.removeComment(comment2.getId());
        assertNull(commentService.find(comment2.getId()));
    }

    /**
     * Test of find method, of class CommentService.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        assertEquals(commentService.find(1L).getContent(), "Content");
    }
    
}
