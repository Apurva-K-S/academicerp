package com.example.erp.controller;

import com.example.erp.bean.organisations;
import com.example.erp.service.alumni_organisationService;
import com.example.erp.service.studentsService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("almorg")
public class almorgController {

    alumni_organisationService alumni_organisationService = new alumni_organisationService();

    @POST
    @Path("/get_alumni")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumni(organisations org) {
        //System.out.println("step2 " + org.getName());
        List<Object[]> alumni = alumni_organisationService.getAlumni(org);
        return Response.ok().entity(alumni).build();
    }
}
