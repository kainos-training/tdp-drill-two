package com.kainos.drilltwo;

import com.google.common.collect.Lists;
import com.kainos.drilltwo.models.Book;

import java.util.List;
import java.util.UUID;

public class DataStore {

	private static List<Book> books = Lists.newArrayList();

	public List<Book> getBooks() {
		return books;
	}

	public void registerBook(String isbn, String title, String author) {
		Book newBook = new Book();
		newBook.setIsbn(isbn);
		newBook.setTitle(title);
		newBook.setAuthor(author);

		books.add(newBook);
	}

	public Book getBook(int BookID){
		for(Book book: books){
			//if the book IDs match, return that book
			if(BookID == book.getID()){
				return book;
			}
		}
	}
}
