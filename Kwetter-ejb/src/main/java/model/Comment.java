/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Table(name= "Comment")
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "select c from Comment as c where c.post = :post")
})
public class Comment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String content;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private GregorianCalendar date;
    
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private User poster;
    
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Posting post;

    public Comment() {
    }

    public Comment(String content, User poster, Posting post) {
        this.content = content;
        this.poster = poster;
        this.post = post;
    }
    
    public Comment(Long Id, String content, User poster, Posting post) {
        this.Id = Id;
        this.content = content;
        this.poster = poster;
        this.post = post;
    }

    public Comment(Long Id, String content, GregorianCalendar date, User poster, Posting post) {
        this.Id = Id;
        this.content = content;
        this.date = date;
        this.poster = poster;
        this.post = post;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Posting getPost() {
        return post;
    }

    public void setPost(Posting post) {
        this.post = post;
    }
    
    
}
