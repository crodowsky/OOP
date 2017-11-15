/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.business;

import java.util.*;
import library.domain.*;
import library.services.*;
import domain.*;

import domain.*;


/**
 *
 * @author Cherie Rodowsky
 * @ Version 1, Assignment 9
 */
public class AuthenticationMgr {
    
     public AuthenticationMgr () {}
    
    public boolean authenticate (Login login) throws Exception{
        Factory factory = new Factory();
        IAuthenticationSvc authenticationSvc = 
                  (IAuthenticationSvc)factory.getBookSvc("IAuthenticationSvc");
        return authenticationSvc.authenticate(login);
    }
}
