/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

/**
 *
 * @author Rawan
 */ import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
public class MyFrame extends JFrame implements ActionListener {

    JComboBox<String> ComboBox;
    private String selectedBookType = null;  // Store the selected book type
    private boolean selectionMade = false;   // Flag to indicate selection completion

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] options = {" 1.Add a new Item", " 2.List Avaliable items", " 3.Borrow an item", " 4.Return an item ", " 5.Exit"}; 
        ComboBox = new JComboBox<>(options);
        ComboBox.addActionListener(this);
        this.add(ComboBox);
this.setPreferredSize(new Dimension(400, 300));
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ComboBox) {
           String choice =  (String) ComboBox.getSelectedItem();
            System.out.println("User selected: " + choice); // Debugging output

            if (choice == " 1.Add a new Item") {
                String[] bookTypes = {"PhysicalBook", "EBook", "ReferenceBook", "CD", "DVD","journal"};
                selectedBookType = (String) JOptionPane.showInputDialog(
                        this,
                        "Select Book Type:",
                        "Choose Type",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        bookTypes,
                        bookTypes[0]
                );

                if (selectedBookType != null) {
                    System.out.println("User selected book type: " + selectedBookType);
                    selectionMade = true;
                    this.dispose(); // Close GUI when selection is done
                }
            }
            else if(choice == " 3.Borrow an item"){
                 int ID=Integer.parseInt(JOptionPane.showInputDialog("Enter your ID"));
                 System.out.println("User ID: " + ID);
                 int ISBN=Integer.parseInt(JOptionPane.showInputDialog("Enter your ISBN"));
                 System.out.println("ISBN: " + ISBN);
                 this.dispose();
            }
            else if(choice==" 4.Return an item "){
                 int ID=Integer.parseInt(JOptionPane.showInputDialog("Enter your ID"));
                 System.out.println("User ID: " + ID);
                 int ISBN=Integer.parseInt(JOptionPane.showInputDialog("Enter your ISBN"));
                   System.out.println("ISBN: " + ISBN);
                   this.dispose();
            }
            else if(choice==" 5.Exit"){
            System.out.println("Exiting the application...");
                System.exit(0); 
            }
        }
    }

    // Getter method to return the selected book type
    public String getSelectedBookType() {
        return selectedBookType;
    }

    // Getter method to check if selection is made
    public boolean isSelectionMade() {
        return selectionMade;
    }
}
