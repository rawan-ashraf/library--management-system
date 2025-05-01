/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.LibraryItem;

/**
 *
 * @author Rawan
 */
public class ReferenceBook extends LibraryItems {

	 public ReferenceBook(String title, String author, String ISBN) {
		 super(title, author, ISBN);
		 }
	 
	public void Borrow() {
		
		System.out.println("Reference Book cannot be borrowed");

		}

   	  
}
