/*
 * This class will test the service layer Serialized Implementation.
 */
package library.services;

import java.util.*;
import library.domain.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
/**
 * Test Book Service serialized Implementation
 * @author Cherie Rodowsky
 * @Version 1, Assignment 9
 */
public class BookSvcSerializedIOImplTest {
    
        
    public BookSvcSerializedIOImplTest() {
    }

    @Test
    public void testAdd(){
        
       System.out.println("add");
      ArrayList<String> testAuthColl = new ArrayList<>(Arrays.asList("Walter Isaacson","J.K. Rowling","Stephen King"));      
        
        Book storedBook = new Book("978-0743264747", testAuthColl);
       
        Book returnedBook = new Book();
        try{
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc)factory.getBookSvc("IBookSvc");
        returnedBook = bookSvc.add(storedBook);
        }
        catch (Exception e){
            System.out.println ("Book was not added");
            
        }
        assertEquals(returnedBook,storedBook); 
    }
    
}
