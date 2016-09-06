package com.kainos.drilltwo.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.kainos.drilltwo.DataStore;
import com.kainos.drilltwo.views.PeopleAddView;
import com.kainos.drilltwo.views.PeopleListView;
import io.dropwizard.views.View;
import org.assertj.core.util.Strings;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("people")
public class PeopleResource {

    final static Logger LOGGER = LoggerFactory.getLogger(PeopleResource.class);

    final DataStore dataStore;
    final com.kainos.drilltwo.config.DrillTwoConfiguration configuration;

    public PeopleResource(DataStore dataStore, com.kainos.drilltwo.config.DrillTwoConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View index(){
        return new PeopleListView(dataStore.getPeople());
    }

    @Path("add")
    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View add(){
        return new PeopleAddView(new ArrayList<String>());
    }

    @Path("add")
    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View addPerson(
            @FormDataParam("name") String name,
            @FormDataParam("age") Integer age
    ){

        List<String> errors = Lists.newArrayList();

        if (Strings.isNullOrEmpty(name)) {
            errors.add("Enter a valid name");
        }

        if (age == null || age < 0 || age > 120) {
            errors.add("Enter a valid age between 1 and 120");
        }

        if (!errors.isEmpty()) {
            return new PeopleAddView(errors);
        }

        UUID idForNewPerson = UUID.randomUUID();

        LOGGER.info("Registering person " + String.format("id: %s name: %s age: %s", idForNewPerson, name, age));
        dataStore.registerPerson(idForNewPerson, name, age);

        URI peopleListUri = UriBuilder.fromUri("/people").build();
        Response response = Response.seeOther(peopleListUri).build();
        throw new WebApplicationException(response); // valid way to redirect in dropwizard
    }
}

