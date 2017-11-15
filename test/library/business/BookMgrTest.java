/*
 * This class will test the functionality of the Book manager, business layer.
 */
package library.business;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import library.domain.*;



/**
 * Book Manager Test class
 * @author Cherie Rodowsky
 * @Version 1, Assignment 9
 */
public class BookMgrTest {
         
    public BookMgrTest() {
    }

    @Test
    public void testAddBook() {
        
        System.out.println("addBook");
       
        ArrayList <String> testAuthColl = new ArrayList<>(Arrays.asList("Walter Isaacson", 
                                          "J.K. Rowling", "Stephen King"));
        Book storedBook = new Book("978-0743264747", testAuthColl);
        Book result = new Book ();
        BookMgr bookMgr = new BookMgr(); 
        
       try{
        result = bookMgr.storeBook(storedBook);          
      
       } 
       catch (Exception e){
            System.out.println ("Book not stored");
       }
        assertEquals(result,storedBook);
        
    }
    
}
