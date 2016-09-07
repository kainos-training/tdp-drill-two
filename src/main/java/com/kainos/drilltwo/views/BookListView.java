package com.kainos.drilltwo.views;

import com.kainos.drilltwo.models.Book;
import com.kainos.drilltwo.models.Person;
import io.dropwizard.views.View;

import java.util.List;

public class BookListView extends View {

    private final List<Book> books;

    public BookListView(List<Book> books) {
        super("/Views/book/index.ftl");
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}