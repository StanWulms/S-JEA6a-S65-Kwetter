/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Comment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String content;
    private Date date;
    
    @ManyToOne
    private User poster;
    
    @OneToOne
    private Posting post;

    public Comment(Long Id, String content, User poster, Posting post) {
        this.Id = Id;
        this.content = content;
        this.poster = poster;
        this.post = post;
    }

    public Comment(Long Id, String content, Date date, User poster, Posting post) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
