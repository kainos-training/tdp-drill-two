package com.kainos.drilltwo.views;

import com.kainos.drilltwo.models.Person;
import io.dropwizard.views.View;

import java.util.List;

public class BookListView extends View {

    private final List<Book> book;

    public BookListView(List<Book> book) {
        super("/Views/book/index.ftl");
        this.book = book;
    }

    public List<Book> getBook() {
        return book;
    }
}