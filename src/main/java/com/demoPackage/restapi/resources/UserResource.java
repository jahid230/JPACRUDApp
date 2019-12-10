package com.demoPackage.restapi.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.demoPackage.restapi.dao.UserDAO;
import com.demoPackage.restapi.models.User;

@RequestScoped
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserDAO userdao;

    @GET
    public Response getAll() {
        return Response.ok(userdao.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        User single_user = userdao.findById(id);

        return Response.ok(single_user).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, User user) {
        User currentUser = userdao.findById(id);
        
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastname(user.getLastname());
        currentUser.setEmail(user.getEmail());
        currentUser.setDob(user.getDob());
        currentUser.setPassword(user.getPassword()); 
        userdao.update(currentUser);
              
        return Response.ok().build();
    }

    @POST
    public Response create(User user) {
        userdao.create(user);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        User getUser = userdao.findById(id);
        
        userdao.delete(getUser);

        return Response.ok().build();
    }

}