/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.LibraryItem;

/**
 *
 * @author Rawan
 */

  abstract public class LibraryItems {
	   private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public LibraryItems() { // Default Constructor
        this.title = " ";
        this.author = " ";
        this.ISBN = " ";
        this.isAvailable = true;
    }

    public LibraryItems(String title, String author, String ISBN) { // Parameterized Constructor
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    abstract void Borrow();

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() { // Renamed from getAvailable()
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void returnItem() {
        isAvailable = true;
        System.out.println("Item returned successfully.");
    }
}
