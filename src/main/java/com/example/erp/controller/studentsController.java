package com.example.erp.controller;

import com.example.erp.bean.students;
import com.example.erp.service.orgService;
import com.example.erp.service.studentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("student")
public class studentsController {

    studentsService studentsService = new studentsService();

    @GET
    @Path("/year")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYear() {
        List<String> years = new ArrayList<>();
        years.add("2016");
        years.add("2017");
        years.add("2018");
        years.add("2019");
        years.add("2020");
        return Response.ok().entity(years).build();
    }

    @GET
    @Path("/domain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomain() {
        List<String> domain = new ArrayList<>();
        domain.add("MT2019");
        domain.add("MT2020");
        domain.add("IMT2018");
        domain.add("IMT2017");
        domain.add("IMT2016");
        return Response.ok().entity(domain).build();
    }

    @GET
    @Path("/specialisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialisation() {
        List<String> spls = new ArrayList<>();
        spls.add("TSCD");
        spls.add("AIML");
        spls.add("NC");
        spls.add("VLSI");
        return Response.ok().entity(spls).build();
    }

    @GET
    @Path("/get_placed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaced_Students() {
        List<Object[]> courses = studentsService.getPlaced_Students();
        return Response.ok().entity(courses).build();
    }

    /*@GET
    @Path("/displayall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAll() throws URISyntaxException {

        List<students> result = studentsService.getAll();

        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }*/
}
