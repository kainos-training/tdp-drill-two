package com.kainos.drilltwo.resources;

import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Lists;
import com.kainos.drilltwo.DataStore;
import com.kainos.drilltwo.config.DrillTwoConfiguration;
import com.kainos.drilltwo.models.Book;
import com.kainos.drilltwo.views.BookAddView;
import io.dropwizard.testing.junit.ResourceTestRule;
import io.dropwizard.views.View;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.ViewRenderer;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BookResourceTest {

    private static List<ViewRenderer> renders = Lists.<ViewRenderer>newArrayList(new FreemarkerViewRenderer());

    DataStore dataStore;
    DrillTwoConfiguration configration;

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new com.kainos.drilltwo.resources.HomeResource())
            .addProvider(new ViewMessageBodyWriter(new MetricRegistry(), renders))
            .build();

    @Before
    public void setup() {
        dataStore =  new DataStore();
        dataStore.getBooks().clear();
        configration = new DrillTwoConfiguration();
    }


    @Test
    public void validationISBN() {
        BookResource resource = new BookResource(dataStore, configration);

        BookAddView result = resource.addBook("", "", "", "");

        result.getErrors();

        assertEquals(result.getErrors().get(0), ("Enter a valid ISBN"));
    }

    @Test
    public void validationTitle() {
        BookResource resource = new BookResource(dataStore, configration);

        BookAddView result = resource.addBook("", "", "", "");

        result.getErrors();

        assertEquals(result.getErrors().get(1), ("Enter a valid title"));
    }

    @Test
    public void validationAuthor() {
        BookResource resource = new BookResource(dataStore, configration);

        BookAddView result = resource.addBook("", "", "", "");

        result.getErrors();

        assertEquals(result.getErrors().get(2), ("Enter a valid author"));
    }


    @Test
    public void validateBookAdded()
    {
        Book book = new Book();
        book.setIsbn("123456789-7");
        book.setTitle("zzz");
        book.setAuthor("zzz");
        book.setCurrent("this");

        dataStore.registerBook(book.getIsbn(),book.getTitle(),book.getAuthor(),book.getCurrent());

        Book books = dataStore.getBooks().get(0);

        assertEquals(book.getTitle(),books.getTitle());

    }

    @Test
    public void isTitlesSorted(){
        Book book = new Book();
        book.setIsbn("123456789-7");
        book.setTitle("High");
        book.setAuthor("flying");
        book.setCurrent("this");

        Book book2 = new Book();
        book2.setIsbn("123456789-7");
        book2.setTitle("Bye");
        book2.setAuthor("Sky");
        book2.setCurrent("this");

        dataStore.registerBook(book.getIsbn(),book.getTitle(),book.getAuthor(),book.getCurrent());
        dataStore.registerBook(book2.getIsbn(),book2.getTitle(),book2.getAuthor(),book.getCurrent());

        dataStore.sortByTitle();

        Book bookCheck = dataStore.getBooks().get(0);

        assertEquals(book2.getTitle(), bookCheck.getTitle());

    }

    @Test
    public void isAuthorsSorted(){
        Book book = new Book();
        book.setIsbn("123456789-7");
        book.setTitle("High");
        book.setAuthor("flying");
        book.setCurrent("this");

        Book book2 = new Book();
        book2.setIsbn("123456789-7");
        book2.setTitle("zeb");
        book2.setAuthor("alpha");
        book2.setCurrent("this");

        dataStore.registerBook(book.getIsbn(),book.getTitle(),book.getAuthor(), book.getCurrent());
        dataStore.registerBook(book2.getIsbn(),book2.getTitle(),book2.getAuthor(),book.getCurrent());

        dataStore.sortByAuthor();

        Book bookCheck = dataStore.getBooks().get(0);

        assertEquals(book2.getAuthor(), bookCheck.getAuthor());

    }


}
