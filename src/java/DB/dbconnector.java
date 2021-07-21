
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author reet
 */
public class dbconnector {
   static  Connection con =null;
   static  Statement st=null;
   
   
   static{
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rootsh24");
            System.out.println("connected");
            st=con.createStatement();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (SQLException e) 
        {
           System.out.println(e);
        }
   }
  public static Statement getStatement()
  {
      return st;
  }
  public static Connection getConnection()
  {
      return con;
  }
  
}

