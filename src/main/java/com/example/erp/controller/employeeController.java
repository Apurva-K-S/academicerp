package com.example.erp.controller;

//import com.example.erp.services.CoursesService;
//import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("departments")
public class employeeController {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartments() {
        List<String> departments = new ArrayList<>();
        departments.add("IT");
        departments.add("Management");
        departments.add("Admission");
        departments.add("Grievance");
        departments.add("Counseller");
        departments.add("Outreach");
        departments.add("Library");
        return Response.ok().entity(departments).build();
    }

    /*@POST
    @Path("/register")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerCourse(@FormDataParam("name") String name,
                                   @FormDataParam("description") String description,
                                   @FormDataParam("credits") Integer credits) throws URISyntaxException {
        System.out.println(name);
        System.out.println(description);
        System.out.println(credits);
        CoursesService courseservice = new CoursesService();
        courseservice.addCourse(name, description, credits);
        return Response.ok().build();

    }*/
}
