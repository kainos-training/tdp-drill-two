package com.kainos.drilltwo.models;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private int ID;
    private String current;

    private static int nextID = 0;

    public Book (){
        this.ID = nextID;
        nextID++;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getID (){
        return ID;
    }

    public String getCurrent(){ return current;}

    public void setCurrent(String current){
        this.current = current;
    }


}
