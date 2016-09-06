package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.discoverydiary.views.Index;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class HomeResource {

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View Index() {
        return new Index();
    }

}
