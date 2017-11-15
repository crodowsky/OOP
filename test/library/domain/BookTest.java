/*
 *   This is the test class for the library application.
*/

package library.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cherie Rodowsky
 * @Version 1, Assignment 9
 * @ Library Application Collections
 */
public class BookTest {
    
    public BookTest() {
    }

     @Test
    public void testEquals(){
        
        ArrayList<String> authors = new ArrayList<>();
        
        System.out.println ("equals");
        
        
        //Creating an object and setting it to string
        Object obj1 = new Book("0545582997", authors);
        authors.add("J.K. Rowling");
        authors.add("Stephen King");
        authors.add ("F. Scott Fitzgerald");
        
        //creating an object and setting it to strings 
        Book book1 = new Book("0545582997", authors);
        
        //Testing that the array is the expected size.
        assertEquals (authors.size(), 3);
        boolean expResult = true;
        boolean result = book1.equals(obj1);
        assertEquals (expResult, result);
        
        //Testing that my array is working
               
        System.out.println ("equals");
        //creating a new object with strings
        Object obj2 = new Book("978-0743258074", authors);
        //forcing the strings to be a mismatch
        Book book2 = new Book( "", null);
        
       
        //indicating that the expected result is false
        expResult = false;
        boolean result2 = book2.equals(obj2);
        //Checking that the first object matchs the second
        assertEquals (expResult, result2);
        
      
    }

    @Test
    public void testValidate() {
          ArrayList<String> authors = new ArrayList<>();
        
        System.out.println ("validate");
        
        //creating a new book object
        Book book1 = new Book();
        boolean expResult = false;
        boolean result = book1.validate ();
        assertEquals (expResult, result);
                       
        //setting the isbn to a string
        book1.setIsbn ("0545582997");
        book1.setAuthors(authors);
        authors.add ("J.K. Rowling");
        authors.add ("Stephen King");
        authors.add ("F. Scott Fitzgerald");
        
        //checking that neither the author nor the isbn are null or empty strings
        result = book1.validate();
        assertEquals ("expected true", true, result);
        
        System.out.println ("validate");
        //creating a new book object
        Book book2 = new Book();
        boolean expResult2 = false;
        boolean result2 = book2.validate ();
        assertEquals (expResult2, result2);
       
        //setting the isbn to an empty string, forcing a false response
        book1.setIsbn ("");
        //checking if the author and isbn strings are null or empty strings
        result = book1.validate();
        //assert modified to reflect that a false response it expected
        assertEquals ("expected false", false, result2);
               
    }
}
