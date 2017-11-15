/*
 *This file contains main as well as the interface for accepting an isbn
 * and a possible list of authors.  This is the framework for the format of the
 * interface. 
 */

package library.presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import library.domain.*;
import library.business.*;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Cherie Rodowsky
 * @Version 1, Assignment 9
 * @User Interface
 */

public class MainUI extends JFrame {
    
    private JLabel isbnLbl = new JLabel("Isbn");
    private JLabel authorLbl = new JLabel ("Author(s)");
    private JLabel authInstruc = new JLabel ("Please use a comma to seperate\n" +
                " the author names" );
    private JTextField isbnFld = new JTextField (10);
    private JTextField authorFld = new JTextField (10);
    private JButton addBtn = new JButton ("Add");
    private JButton cancelBtn = new JButton ("Cancel");
    private ArrayList<String> authorColl;
    
    
    public MainUI (){
        super("Add a Book");
        
        Container container = getContentPane();
        GridBagLayout layout = new GridBagLayout();
        container.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        
        
        isbnLbl = new JLabel("Isbn:");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,10,0,0);
        add(isbnLbl, constraints);
        
        isbnFld = new JTextField("");
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,0,0,0);
        add(isbnFld, constraints);
        
        authorLbl = new JLabel("Author(s):");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(10,0,0,0);
        add(authorLbl, constraints);
        
        authorFld = new JTextField("");
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,0,0,0);
        add(authorFld, constraints);
        
        authInstruc = new JLabel("Please use a comma to seperate \n" +
                " the author names");
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        constraints.insets = new Insets(10,0,0,0);
        add(authInstruc, constraints);
        
        
        addBtn = new JButton("Add");
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10,5,0,0);
        add(addBtn, constraints);
        
        
        cancelBtn = new JButton("Cancel");
        constraints.gridx = 4;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10,5,0,0);
        add(cancelBtn, constraints);
        
                
        addBtn.addActionListener( new ActionListener(){
            
        public void actionPerformed (ActionEvent event) {
                        
                Book book = new Book();                //creating a new book object
                Book storeBook = new Book();           // creatging a storebook object
                book.setIsbn(isbnFld.getText());    //setting the isbn number to the text entered in the field
                String[] authors = authorFld.getText().split(",");    // setting the author array to the authors
                                                                    // entered into the author field and serarating them 
                                                                    // using the comma delimiter
                authorColl = new ArrayList<> (Arrays.asList(authors));      
                book.setAuthors(authorColl);                          //setting the authors to the array list
                if (!book.validate()){                              //validiating the book contains an isbn and author
                    System.out.println("isbn and author required");
                }
                
                    try {
                        BookMgr bookMgr = new BookMgr();            // call to the BookMgr business layer
                        storeBook = bookMgr.storeBook(book);        // pushing the object to the BookMgr storeBook method
                        System.out.println(book.toString());   
                    }
                    catch (Exception e){
                        System.out.println("Error adding book");
                    }
            System.out.println("Add button pressed");
                }
           
          } 
        );
        cancelBtn.addActionListener(new ActionListener(){
       
        public void actionPerformed (ActionEvent event) {
            System.out.println ("Cancel button pressed");
            isbnFld.setText ("");
            authorFld.setText("");
                }
           }
        );
        
       
    }
    

public static void main(String args[]) {
 
    MainUI mui = new MainUI(); 
    mui.setVisible(true);  
    mui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    mui.setSize(500, 200);

        }
    }

