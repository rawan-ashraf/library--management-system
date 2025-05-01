/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.Library;
import com.mycompany.librarymanagementsystem.LibraryItem.LibraryItems;
import com.mycompany.librarymanagementsystem.user.Libraryuser;
  import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class Library {

	private HashMap<String, LibraryItems> items = new HashMap<>(); 
	
	// HashMap to store library users with user ID as the key
	private HashMap<String, Libraryuser> users = new HashMap<>();    

	
	public Library(){  // Default constructor to initialize HashMaps
		 items = new HashMap<>();
	     users = new HashMap<>();
	}
	
	public void additem(LibraryItems item){
        items.put(item.getISBN(), item); // Store item in HashMap with ISBN as key
	}
	
	public void addUser(Libraryuser user) {
	    users.put(user.getUserID(), user); // Store user in HashMap with User ID as key
	}
	
	 public Libraryuser getUserByID(String ID) {
		 return users.get(ID); // Retrieve the user from the HashMap
	    }
	 
	 public LibraryItems getItemByISBN(String ISBN) {
	        return items.get(ISBN); // Retrieve the item from the HashMap
	    }
	
	public void listAvaliableItems(){ 
	
		boolean found = false;

	    for (LibraryItems item : items.values()) { // Loop through all items
	        if (item.isAvailable()) { // Check if the item is available
	            System.out.println("Title: " + item.getTitle() + " - ISBN: " + item.getISBN());
	            found = true;
	        }
	    }

	    if (!found) { // If not available items found, display a message
	        System.out.println("No available items.");
	    }
	}
	
	
	 public void returnItem(String ID ,String ISBN){
		
		 Libraryuser user = users.get(ID); // Get user from HashMap
		 LibraryItems item = items.get(ISBN); // Get item from HashMap

		 user.returnItem(item); // Call user's returnItem method
	 }
	 public void BorrowItems(String ID ,String ISBN){
	   
        Libraryuser user = users.get(ID); // Get user from HashMap
        LibraryItems item = items.get(ISBN); // Get item from HashMap

	    user.BorrowItems(item);
	      
}
}
