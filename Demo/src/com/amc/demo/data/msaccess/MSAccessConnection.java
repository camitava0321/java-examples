/*
 * MSAccessConnection.java
 *
 * Created on 04 September 2007, 18:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.amc.demo.data.msaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 109365
 */
public class MSAccessConnection {

    private Connection conn;
    /** Creates a new instance of MSAccessConnection */
    public MSAccessConnection(String url) throws 
            ClassNotFoundException,
            SQLException
    {
        super();
	// Load Sun's jdbc-odbc driver
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn = DriverManager.getConnection(url);
    }
    
    public Connection getConnection()
    {
        return conn;
    }
    
    public static void main(String []args)
    {
        try
        {
        MSAccessConnection conn = new MSAccessConnection("jdbc:odbc:rmtprod");
                Connection connection = conn.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from usecase");
                while(rs.next())
                {
                    System.out.println(rs.getString("usecase_name"));
                }
        }
        catch (ClassNotFoundException e) // driver not found
        {
                System.err.println (e);
                System.exit(0);
        }
        catch (SQLException e) // driver not found
        {
                System.err.println (e);
                System.exit(0);
        }
        
    }
    
}
