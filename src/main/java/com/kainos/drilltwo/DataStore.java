package com.kainos.drilltwo;

import com.google.common.collect.Lists;
import com.kainos.drilltwo.models.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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


	public void sortByTitle()
	{
		Collections.sort(books, new Comparator<Book>()
		{
			public int compare(Book book1, Book book2)
			{
				return book1.getTitle().toLowerCase().compareTo(book2.getTitle().toLowerCase());
			}
		});
	}


	public void sortByAuthor()
	{
		sortByTitle();
		Collections.sort(books, new Comparator<Book>()
		{

			public int compare(Book book1, Book book2)
			{
				return book1.getAuthor().toLowerCase().compareTo(book2.getAuthor().toLowerCase());

			}

		});
	}




}
