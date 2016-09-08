package com.kainos.drilltwo;

import com.google.common.collect.Lists;
import com.kainos.drilltwo.models.Book;

import java.util.List;

public class DataStore {

	private static List<Book> books = Lists.newArrayList();

	public List<Book> getBooks() {
		return books;
	}

	public void registerBook(String isbn, String title, String author, String current) {
		Book newBook = new Book();
		newBook.setIsbn(isbn);
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setCurrent(current);

		books.add(newBook);
	}
}
