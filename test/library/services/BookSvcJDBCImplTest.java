/*
 * This class tests the JDBC implementation class and its add method.
 */
package library.services;

import java.util.*;
import library.domain.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cherie Rodowsky
 * @ Version 1, Assignment 9
 */
public class BookSvcJDBCImplTest {
    
    public BookSvcJDBCImplTest() {
        
    }

    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        ArrayList <String> testAuthColl = new ArrayList<>(Arrays.asList("Walter Isaacson","J.K. Rowling","Stephen King"));
              
        Book storedBook = new Book("978-0743264747", testAuthColl);
        Book results = new Book();
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc)factory.getBookSvc("IBookSvc");
        results = bookSvc.add(storedBook);
        assertEquals(results, storedBook);
    }
    
}
