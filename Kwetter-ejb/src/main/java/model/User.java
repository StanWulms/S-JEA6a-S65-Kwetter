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

/**
 *
 * @author Stan
 */
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String userName;
    private String password;
    private String bio;
    
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
    
    public User(String userName,String password, String bio, ArrayList<User> followers, ArrayList<User> followings, ArrayList<Posting> tweets)
    {
        this.userName = userName;
        this.password = password;
        this.bio = bio;
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
