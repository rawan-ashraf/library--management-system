/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.LibraryItem;

/**
 *
 * @author Rawan
 */


public class PhysicalBook extends LibraryItems implements Borrowable {

	 public PhysicalBook(String title, String author, String ISBN) {
		 super(title, author, ISBN);
		 }
		 
		 @Override
		public void Borrow() {
			if(isAvailable()==true) {
				setAvailable(false);
				System.out.println("Physical Book borrowed successfuly. Please return it within 14 days. ");
			}
			else
				System.out.println("Physical Book is not available");

			}
			
	
}