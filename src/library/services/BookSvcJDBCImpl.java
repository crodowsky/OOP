/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.services;
/*
* This is the JDBC implementation for my library application.
*/
import java.sql.*;
import javax.sql.*;
import library.domain.*;

/**
 *
 * @author Cherie Rodowsky
 * @ Version 1, Assignment 9
 */
public class BookSvcJDBCImpl implements IBookSvc {
        
    private final String connString = 
             "jdbc:mysql://localhost/rodowskylibrary?user=root&password=admin";
    
    private Connection getConnection() throws Exception {
		return DriverManager.getConnection(connString);
	}

       @Override
	public Book add(Book book) throws Exception {
		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO book (isbn, authors) " + 
			 "VALUES ('" + book.getIsbn() + "', '" 
                                    + book.getAuthors() + "')";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
		   throw e;
		} finally {
		  if (conn != null) conn.close();
		}
                return book;
	}	

}

