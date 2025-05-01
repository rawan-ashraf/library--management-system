/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.LibraryItem;

/**
 *
 * @author Rawan
 */
public class EBook extends LibraryItems implements Borrowable{
	
	 public EBook(String title, String author, String ISBN) {
		 super(title, author, ISBN);
		 }
		 
		 @Override
		public void Borrow() {
			if(isAvailable()==true) {
				setAvailable(false);
				System.out.println("EBook borrowed successfuly. It will expire within 14 days. ");
			}
			else
				System.out.println("EBook is not available");

			}

}
