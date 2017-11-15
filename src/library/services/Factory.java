/*
 *  This is the Factory class
 */
package library.services;

import java.io.*;
import java.util.*;
/**
 * 
 * @author Cherie Rodowsky
 * @ Version 1, Assignment 9
 */
public class Factory {
    
       
   public Factory() {}

   public IService getBookSvc(String serviceName) throws Exception {
		Class c = Class.forName(getImplName(serviceName));
		return (IService) c.newInstance();
   }

   private String getImplName(String serviceName) throws Exception {
	FileInputStream fis = new FileInputStream("config/properties.txt");
	Properties props = new Properties();
 	props.load(fis);
	fis.close();
	return props.getProperty(serviceName);
   }
    
}
