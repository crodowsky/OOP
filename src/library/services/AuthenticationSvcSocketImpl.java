/*
 * Authentication server socket implimentation
 */
package library.services;

import java.io.*;
import java.net.*;
import domain.*;

/**
 *
 * @author Cherie Rodowsky
 * @ Version 1, Assignment 9
 */
public class AuthenticationSvcSocketImpl implements IAuthenticationSvc {
    
    public boolean authenticate(Login login) {
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        boolean authenticated = false;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9000);
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(login);
            authenticated = (boolean)in.readObject();
        } 
        catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        } 
        finally {
            try {
                in.close();
                out.close();
                socket.close();
            } 
            catch (Exception e) {
             // log the error
                System.out.println("Exception " + e.getMessage());
            }
        }
        return authenticated;
    }
    
}
