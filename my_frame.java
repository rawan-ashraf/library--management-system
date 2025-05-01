/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

/**
 *
 * @author Rawan
 */
import com.mycompany.librarymanagementsystem.Library.Library;
import com.mycompany.librarymanagementsystem.LibraryItem.CD;
import com.mycompany.librarymanagementsystem.LibraryItem.DVD;
import com.mycompany.librarymanagementsystem.LibraryItem.EBook;
import com.mycompany.librarymanagementsystem.LibraryItem.Journal;
import com.mycompany.librarymanagementsystem.LibraryItem.LibraryItems;
import com.mycompany.librarymanagementsystem.LibraryItem.PhysicalBook;
import com.mycompany.librarymanagementsystem.LibraryItem.ReferenceBook;
import com.mycompany.librarymanagementsystem.user.Libraryuser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import com.mycompany.librarymanagementsystem.Library.Library;
import com.mycompany.librarymanagementsystem.LibraryItem.*;
import com.mycompany.librarymanagementsystem.user.Libraryuser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class my_frame extends JFrame implements ActionListener {
    private Library library;
    private Libraryuser user;

    private JButton addItemButton, listItemsButton, borrowItemButton, returnItemButton, exitButton;

    public my_frame() {
        // Initialize the library object
        library = new Library();

        // Setting up the JFrame
        setTitle("Library Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 buttons in a grid layout

        // Initialize buttons
        Font customFont = new Font("Comic Sans MS", Font.BOLD, 20);
        addItemButton = createButton("Add a New Item", customFont, buttonPanel);
        listItemsButton = createButton("List Available Items", customFont, buttonPanel);
        borrowItemButton = createButton("Borrow an Item", customFont, buttonPanel);
        returnItemButton = createButton("Return an Item", customFont, buttonPanel);
        exitButton = createButton("Exit", customFont, buttonPanel);

        // Add the panel to the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    // Helper method to create a button and add it to the panel
    private JButton createButton(String text, Font font, JPanel panel) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setFocusable(false);
        button.addActionListener(this);
        panel.add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItemButton) {
            String input = JOptionPane.showInputDialog(
                this,
                "Enter Item Type number:\n(1) PhysicalBook\n(2) EBook\n(3) ReferenceBook\n(4) CD\n(5) DVD\n(6) Journal"
            );
            String Title=JOptionPane.showInputDialog("Enter your Title");
            String Author=JOptionPane.showInputDialog("Enter your Author");
            String ISBN=JOptionPane.showInputDialog("Enter your ISBN");
            String number=JOptionPane.showInputDialog("Enter your Number of copies");
           int num = Integer.parseInt(input.trim());
             LibraryItems item;
             if (num==1){
                     item=new PhysicalBook(Title,Author,ISBN);
           }
             else if(num==2){
                     item=new EBook(Title,Author,ISBN);}
             else if(num==3){
                     item=new ReferenceBook(Title,Author,ISBN);}
              else if(num==4){
                     item=new CD(Title,Author,ISBN);}
              else if(num==5){
                     item=new DVD(Title,Author,ISBN);}
              else if(num==6){
                     item=new Journal(Title,Author,ISBN);
                     
              }
              else{
                  System.out.println("invalid choice");
                  return;
              }
                 
                 
              library.additem(item);
              System.out.println("Item added successfully.");
            // Process the input here (not implemented yet)
        }
        else if (e.getSource() == listItemsButton) {
          library.listAvaliableItems();}
          else if (e.getSource() ==  borrowItemButton ){
     String input = JOptionPane.showInputDialog(
            this,
            "Enter Item Type number:\n(1) PhysicalBook\n(2) EBook\n(3) ReferenceBook\n(4) CD\n(5) DVD\n(6) Journal"
        );

        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int num;
        try {
            num = Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (num == 3 || num == 6) {
            JOptionPane.showMessageDialog(this, "You can't borrow this item", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String userID = JOptionPane.showInputDialog(this, "Please enter user ID");
        String isbn = JOptionPane.showInputDialog(this, "Please enter item ISBN");

        if (userID == null || isbn == null || userID.trim().isEmpty() || isbn.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (num == 2) {
            library.BorrowItems(isbn, userID);
        } else {
            String quan = JOptionPane.showInputDialog(this, "Please enter quantity");
            int quantity;
            try {
                quantity = Integer.parseInt(quan.trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < quantity; i++) {
                library.BorrowItems(isbn, userID);
            }
        }
    }

     
    else if (e.getSource() == returnItemButton) {
        String ID=JOptionPane.showInputDialog("Enter your ID");
            String ISBN=JOptionPane.showInputDialog("Enter your ISBN");
           library.returnItem(ID, ISBN);
        } 
    else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    
}
