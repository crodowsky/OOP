/*
 * This is the IBookSvc class
 */
package library.services;

import library.domain.*;
/**
 *
 * @author Cherie Rodowsky
 * @Version 1, Assignment 9
 */
public interface IBookSvc extends IService{
    
   public Book add(Book book)throws Exception;
}
