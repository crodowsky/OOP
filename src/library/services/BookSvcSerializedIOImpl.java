/*
 *  This class implements serialization of a book object.
 */
package library.services;

import library.domain.*;
import java.io.*;

/**
 *
 * @author Cherie Rodowsky
 * @ Version 1, Assignment 9
 * @ BookSvcSerializedIOImpl
 */
public class BookSvcSerializedIOImpl implements IBookSvc {
    
    //@Override
     public Book add(Book book) throws Exception{
                
        FileOutputStream outFile = new FileOutputStream ("books.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
        objectOut.writeObject(book);
        objectOut.flush();
        objectOut.close();
        return book;
        
        
    }
}
