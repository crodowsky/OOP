/* This class is used to create the book object for a library application. 
    For each book the isbn number is gathered as well as the author or authors.
    The author or authors for each book is placed into an array list collection
*/
package library.domain;

import java.util.*;
import java.io.*;

/**
 *
 * @author Cherie Rodowsky
 * @Version 1, Assignment 9
 * @User Interface Book.java
 */
public class Book implements Serializable {
    // create an ArrayList called authorColl
    private String isbn;
    private ArrayList<String> authorColl;
    
    //Constructor
    public Book (){
        isbn = null;
        authorColl = null;
       
    }
  
    public Book (String isbn, ArrayList<String> author){
        this.isbn = isbn;
        this.authorColl = author;
       
    }
    
    //get isbn string
    public String getIsbn () {
        return isbn;
    }
    //set author string
    public void setIsbn(String isbn) {
       this.isbn = isbn;
    }
    
    public ArrayList<String> getAuthors () {
        return authorColl;
    }
  
    public void setAuthors(ArrayList<String> list) {
       this.authorColl = list;
    }
  
   /*
    public void addAuthor (String author){
        
        authorColl.add(author);
             
    }
    */
   @Override
     public boolean equals (Object obj){
         if (this == obj) return false;
         if (! (obj instanceof Book)) return false;
         Book book = (Book)obj;
         if (!this.getIsbn().equals (book.getIsbn())) return false;
         if(!this.getAuthors().equals(book.getAuthors())) return false;
         return true;
     }
     //Method for making sure the strings are not null or without content
      public boolean validate (){
        //if (author == null || author.equals ("")) return false;
        if (isbn == null || isbn.equals ("")) return false;
        if (authorColl == null) return false;
        return true;
    }
 @Override
    public String toString() {
        return "Isbn:" + isbn + " Author(s):" + authorColl;
    }
  
}
