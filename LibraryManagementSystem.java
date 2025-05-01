/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementsystem;
import com.mycompany.librarymanagementsystem.Library.Library;
import com.mycompany.librarymanagementsystem.LibraryItem.CD;
import com.mycompany.librarymanagementsystem.LibraryItem.DVD;
import com.mycompany.librarymanagementsystem.LibraryItem.EBook;
import com.mycompany.librarymanagementsystem.LibraryItem.Journal;
import com.mycompany.librarymanagementsystem.LibraryItem.LibraryItems;
import com.mycompany.librarymanagementsystem.LibraryItem.PhysicalBook;
import com.mycompany.librarymanagementsystem.LibraryItem.ReferenceBook;
import com.mycompany.librarymanagementsystem.user.Libraryuser;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Rawan
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {
   String name=JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null, "Welcome to Library Management System, " + name+"!");
   //  new LibraryManager();
  //  new MyFrame();
 //new my_frame();
   
    	      Library library = new Library(); // Create library object
            Libraryuser user; // Declare LibraryUser object
		 
		  while(true){
		        System.out.println(" Welcome to Library Managment System \n 1.Add a new Item\n 2.List Avaliable items\n 3.Borrow an item\n 4.Return an item \n 5.Exit");
		        System.out.println("Please Enter Choice =====>");
		       Scanner choice= new Scanner(System.in); // Scanner for user input
		       int c =choice.nextInt(); // Read user's choice

	
		       switch(c){
		           case 1:
		              System.out.println(" Enter Item Type (1) PhysicalBook (2) EBook (3) ReferenceBook (4) CD (5) DVD (6)Journal:");
		              int s =choice.nextInt();
		              choice.nextLine();
		               System.out.println("Enter Title:");
		               String title =choice.nextLine();
		               System.out.println("Enter Author:");
		               String Author =choice.nextLine();
		               System.out.println("Enter ISBN:");
		               String ISBN =choice.nextLine();
		               System.out.println("Enter Number of Copies:");
		               String number =choice.nextLine();
		              LibraryItems item; // Declare item object
		              
		                switch(s){ // Create an instance of the selected item type
		                    case 1:
		                        item=new PhysicalBook (title,Author,ISBN);
		                        break;
		                    case 2:
		                        item=new EBook(title,Author,ISBN);
		                        break;
		                    case 3:
		                        item=new  ReferenceBook(title,Author,ISBN);
		                        break;
		                    case 4:
		                        item=new CD(title,Author,ISBN);
		                        break;
		                    case 5:
		                        item=new DVD(title,Author,ISBN);
		                        break;
		                    case 6:
		                        item=new Journal(title,Author,ISBN);
		                        break;
		                    default:
		                        System.out.println("invalid choice");
		                        return;
		                        
		                }
		             // Add item to library
		                library.additem(item);
		                System.out.println("item "+"'"+ item.getTitle()+"' added successfully with ISBN "+item.getISBN());
		        break;
		           case 2:
		        	   // Display available items
		               System.out.println("Avaliable items:");
		               library.listAvaliableItems();
		                 break;
		         case 3:
		        	// Borrow an item
		                System.out.println("Enter User ID:");
		                String Id=choice.next();
		               
		                System.out.println("Enter ISBN of Item to Borrow:");
		                String iSBN=choice.next();
		      	               
		                user = new Libraryuser(Id, "name"); // Create user
		                library.addUser(user); // Add user to library
		                
		                LibraryItems itemToBorrow = library.getItemByISBN(iSBN); // Get item from library

		                // Check if item can be borrowed
		                if (itemToBorrow.getClass().getSimpleName().equals("Journal") || 
		                	    itemToBorrow.getClass().getSimpleName().equals("ReferenceBook")) {
		                	    System.out.println("Item cannot be borrowed.");
		                	    break;
		                	}
		               
	                    library.BorrowItems(Id,iSBN); //call borrow function
	                    
		               break;
		       
		         case 4:
		        	// Return an item
		    	        System.out.println("Enter User ID:");
                        String ID=choice.next();
               
                        System.out.println("Enter ISBN of Item to return:");
                        String isbn=choice.next();
                        user = library.getUserByID(ID); // Get user from library
                
                       library.returnItem(ID, isbn);	
                       break;
		           
		       case 5:
		    	// Exit program
		         choice.close();
		         System.exit(0);
		           break;
		        
		    }
		        } }}
