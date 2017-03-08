/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name= "User")
@NamedQueries({
    @NamedQuery(name = "User.setPassword", query = "upate User u set u.password = :password where u.id= :id"),
    @NamedQuery(name = "User.getFollower", query = "select u from User as u where u.id= :id"),
    @NamedQuery(name = "User.getFollowings", query = "select u from User as u where u.id= :id"),
    @NamedQuery(name = "User.findAllFollowers", query = "select u from User as u where u.followers IN :followers"),
    @NamedQuery(name = "User.findAllFollowings", query = "select u from User as u where u.followings IN :followings"),
    @NamedQuery(name = "User.findByUsername", query = "select u from User as u where u.userName= :username")
})
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String userName;
    private String password;
    private String bio;
    private String location;
    private String website;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private ArrayList<User> followers;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private ArrayList<User> followings;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private ArrayList<Posting> tweets;
    
    public User(String userName)
    {
        this.userName = userName;
    }
    
    public User(String userName,String password, String bio, String location, String website, ArrayList<User> followers, ArrayList<User> followings, ArrayList<Posting> tweets)
    {
        this.userName = userName;
        this.password = password;
        this.bio = bio;
        this.location = location;
        this.website = website;
        this.followers = followers;
        this.followings = followings;
        this.tweets = tweets;
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }

    public void setFollowings(ArrayList<User> followings) {
        this.followings = followings;
    }

    public ArrayList<Posting> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Posting> tweets) {
        this.tweets = tweets;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
}
