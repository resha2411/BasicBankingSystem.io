
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reet
 */
public class history extends HttpServlet {

 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
       response.sendRedirect("index.html");   
    }
   
    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("history.jsp"); 
    }  
}