package com.kainos.drilltwo.resources;

import javax.ws.rs.Path;
//import java.util.logging.Logger;
import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.kainos.drilltwo.DataStore;
import com.kainos.drilltwo.views.BookAddView;
import com.kainos.drilltwo.views.BookListView;
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

/**
 * Created by jordanw on 07/09/2016.
 */
@Path("")
public class BookResource
{


        final static Logger LOGGER = LoggerFactory.getLogger(BookResource.class);

        final DataStore dataStore;
        final com.kainos.drilltwo.config.DrillTwoConfiguration configuration;

        public BookResource(DataStore dataStore, com.kainos.drilltwo.config.DrillTwoConfiguration configuration) {
            this.dataStore = dataStore;
            this.configuration = configuration;
        }

        @GET
        @Timed
        @Produces(MediaType.TEXT_HTML)
        public View index(){
            return new BookListView(dataStore.getBooks());
        }

        @Path("add")
        @GET
        @Timed
        @Produces(MediaType.TEXT_HTML)
        public View add(){
            return new BookAddView(new ArrayList<String>());
        }

        @Path("add")
        @POST
        @Timed
        @Produces(MediaType.TEXT_HTML)
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        public View addBook(
                @FormDataParam("isbn") String isbn,
                @FormDataParam("title") String title,
                @FormDataParam("author") String author
        )
        {

            List<String> errors = Lists.newArrayList();

            if (isISBNError(isbn))
            {
                errors.add("Enter a valid ISBN");
            }


            if(isTextError(title)){
                errors.add("Enter a valid title");
            }

            if(isTextError(author))
            {
                errors.add("Enter a valid author");
            }

            if (!errors.isEmpty()) {
                return new BookAddView(errors);
            }

            //UUID idForNewPerson = UUID.randomUUID();

            LOGGER.info("Registering book " + String.format("isbn: %s title: %s author: %s", isbn, title, author));
            dataStore.registerBook(isbn, title, author);

            URI bookListUri = UriBuilder.fromUri("/").build();
            Response response = Response.seeOther(bookListUri).build();
            throw new WebApplicationException(response); // valid way to redirect in dropwizard


        }

        private boolean isTextError(String text)
        {
            return Strings.isNullOrEmpty(text) || text.length() > 200 || text.contains("<");
        }

        private boolean isISBNError(String isbn)
        {
            boolean isMissing = Strings.isNullOrEmpty(isbn);
            boolean matchesIsbn10 = isbn.matches("\\d{9}-\\d");
            boolean matchesIsbn13 = isbn.matches("\\d{3}-\\d-\\d{2}-\\d{6}-\\d");
            boolean matchesEitherFormat = matchesIsbn10 || matchesIsbn13;

            return isMissing || !matchesEitherFormat;
        }



}
