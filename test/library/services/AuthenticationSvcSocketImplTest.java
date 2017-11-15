/*
*  Authentication service socket implementation test 
*/
package library.services;

import java.util.*;
import domain.*;
import org.junit.Test;
import static org.junit.Assert.*;

/** 
 * 
 * @Author: Cherie Rodowsky
 * @Version 1, Assignment 9
 */
public class AuthenticationSvcSocketImplTest {
    private Login goodLogin;
    private Login badLogin;
    private boolean goodTest;
    private boolean badTest;
   
    /**
     * Test of authenticate method, of IAuthenticationSvc.
     * @throws Exception
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("login");
        goodLogin = new Login("Cherie Rodowsky", "pw");
        badLogin = new Login("John Smith", "welcome1");
        Factory factory = new Factory();
        IAuthenticationSvc authenticationSvc = 
                   (IAuthenticationSvc)factory.getBookSvc("IAuthenticationSvc");
        goodTest = authenticationSvc.authenticate(goodLogin);
        badTest = authenticationSvc.authenticate(badLogin);
        assertTrue("expected true", goodTest);
        assertFalse("expected false", badTest);
    }
}