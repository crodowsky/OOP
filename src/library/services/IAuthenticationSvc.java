/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.services;

import domain.*;
/**
 *
 * @author Cherie Rodowsky
 * @Version 1, Assignment 9
 */
public interface IAuthenticationSvc extends IService {
    
      public boolean authenticate(Login login);
}
