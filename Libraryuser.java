/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.user;

import com.mycompany.librarymanagementsystem.LibraryItem.LibraryItems;

/**
 *
 * @author Rawan
 */
public class Libraryuser {
    private String userID;
    private String name;
    private LibraryItems[] borrowedItems;
    private int size = 0;

    
    public Libraryuser(String id, String name) {
        this.userID = id;
        this.name = name;
        this.size++;
        this.borrowedItems = new LibraryItems[size]; 
    }

    public String getUserID() {
        return userID;
    }

    public void BorrowItems(LibraryItems item) {
    	
    	if(item.isAvailable()==false){ 
            System.out.println("The Book isn't avaliable!");
            return;
        }
    	 boolean added=false;
         if(item.isAvailable()==true){ //check if item available
             for(int i=0;i<borrowedItems.length;i++){ //iterate over the array
             if(borrowedItems[i]==null){ // if empty place is found
                  borrowedItems[i]=item;
                  size++;
                  item.setAvailable(false); //mark the item as not available
                  System.out.println("Item borrowed successfully");
                  added=true;
                  break;
                
             }
         }
             if(added==false){
                 System.out.println("you can't borrow more!");
             }
         }
          
         }

    public void returnItem(LibraryItems item) {
        
    	boolean found=false;
        for(int i=0;i<size;i++){
         if(borrowedItems[i] != null && borrowedItems[i].equals(item)){ // check if item is in the borrowedItems array
             found=true;
             item.setAvailable(true); // set item as available
             borrowedItems[i]=null; // remove item from array
             //size--; //decrement array size
             System.out.println("Item returned successfully");
             break;
         }
        
        }
        if (found==false){ //if item not found display message
            System.out.println("You didn't borrow this item");
        }
    }



}
