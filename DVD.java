/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.LibraryItem;

/**
 *
 * @author Rawan
 */
public class DVD extends LibraryItems implements Borrowable{
	
	 public DVD(String title, String author, String ISBN) {
		 super(title, author, ISBN);
		 }
	 
	 @Override
	public void Borrow() {
		if(isAvailable()==true) {
			setAvailable(false);
			System.out.println("DVD borrowed successfuly. Please return it within 14 days. ");
		}
		else
			System.out.println("DVD is not available");

		}
		  
}


