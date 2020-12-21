package com.example.erp.controller;

import com.example.erp.service.employeeService;
import com.example.erp.service.orgService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("org")
public class orgController {

    orgService orgService = new orgService();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganisations() {
        List<String> orgns = new ArrayList<>();
        orgns.add("Morgan Stanley");
        orgns.add("HP");
        orgns.add("Cisco");
        orgns.add("Microsoft");
        orgns.add("Flipkart");
        orgns.add("Amazon");
        return Response.ok().entity(orgns).build();
    }
}
