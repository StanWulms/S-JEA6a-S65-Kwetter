/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stan
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Posting implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @ManyToOne
    private User author;
    private String title;
    private String content;
    private Date date;
    
    @OneToMany
    private List<Comment> comments;
    private Long nextCommentId;
    
    public Posting(User author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<Comment>();
        this.nextCommentId = 1L;
    }

    public Posting(Long id, User author, String title, String content) {
        this.Id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<Comment>();
        this.nextCommentId = 1L;
    }

    public List<Comment> getComments() {
        return comments;
    }
    
    public void addComment(String message) {
        Comment comment = new Comment(this.nextCommentId++, message, this.author, this);
        this.comments.add(comment);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}