/*
 * MSAccessConnectionTest.java
 * JUnit based test
 *
 * Created on 11 September 2007, 16:09
 */

package com.amc.demo.data.msaccess;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

/**
 *
 * @author 109365
 */
public class MSAccessConnectionTest extends TestCase {
    
    public MSAccessConnectionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of getConnection method, of class com.cts.dbconnection.MSAccessConnection.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public void testGetConnection() throws ClassNotFoundException, SQLException {
        System.out.println("getConnection");
        
        MSAccessConnection instance = new MSAccessConnection("jdbc:odbc:rmtprod");
        
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class com.cts.dbconnection.MSAccessConnection.
     */
    public void testMain() {
        System.out.println("main");
        
        String[] args = null;
        
        MSAccessConnection.main(args);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
