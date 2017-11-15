/* 
* This is the book manager class,  this has a method that 
* only returns a book. 
*/
package library.business;

import library.services.*;
import library.domain.*;

/**
 *
 * @author Cherie Rodowsky
*  @Version 1, Assignment 9
 */
public class BookMgr {
    
    public Book storeBook (Book book)throws Exception{
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc) factory.getBookSvc("IBookSvc");
        return bookSvc.add(book);   
    }
    
}
