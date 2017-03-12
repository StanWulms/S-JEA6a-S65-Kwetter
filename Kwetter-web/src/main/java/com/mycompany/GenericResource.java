/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import model.*;
import dao.*;
import service.*;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Stan
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    private UserService userService;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kwetterPU");
    private final EntityManager em;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        em  = emf.createEntityManager();
        userService = new UserService(em);
    }

//    /**
//     * Retrieves representation of an instance of com.mycompany.GenericResource
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public String getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * PUT method for updating or creating an instance of GenericResource
//     * @param content representation for the resource
//     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void putXml(String content) {
//    }
    @GET
    @Path("/user/getUser/{emailAddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("emailAddress") String emailAddress) {
        if (emailAddress.isEmpty() || !emailAddress.contains("@") || emailAddress == null) {
            return null;
        }
        return userService.find(1L);
    }
}
