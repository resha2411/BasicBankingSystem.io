
import DB.dbconnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author reet
 */
public class money extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("transection.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         PrintWriter out = response.getWriter();
         String senderid = request.getParameter("senderid");
        String sendername = request.getParameter("sendername");
        String senderbalance = request.getParameter("senderbalance");
        String receiverid = request.getParameter("receiverid");
        String receivername = request.getParameter("receivername");
        String money = request.getParameter("money");
  
        int sid = Integer.parseInt(senderid);
      int sbalance = Integer.parseInt(senderbalance);
        int rid = Integer.parseInt(receiverid);
        int amount = Integer.parseInt(money);

        Statement st = null;
        ResultSet rs = null;

        int tableid = 0;
        int balance = 0;

        try {
            st = dbconnector.getStatement();

            String query = "select id,balance from customer where id='" + rid + "'";
            System.out.println("query=" + query);
            rs = st.executeQuery(query);
            if (rs.next()) {
                tableid = rs.getInt(1);
                balance = rs.getInt(2);
            }
            if (tableid == rid) {
               
                HttpSession session = request.getSession(true);
                int updatesenderbalance = sbalance - amount;
                int updatereceiverbalance = amount + balance;
                String query1="UPDATE customer set balance='"+updatesenderbalance+"'where id='"+sid+"'";
                String query2="UPDATE customer set balance='"+updatereceiverbalance+"'where id='"+tableid+"'";
                String query3="insert into history_customer (sid,sname,amount,rid,rname) values('"+sid+"','"+sendername+"','"+amount+"','"+rid+"','"+receivername+"')";
               
                st.executeUpdate(query1);
                st.executeUpdate(query2);
                System.out.println("Database updated");
                
                st.executeUpdate(query3);
                System.out.println("history Database updated");
                 
                out.println("<HTML>");
                out.println("<HEAD>");
                out.println("<TITLE>First Servlet</TITLE>");
                out.println("</HEAD>");
                out.println("<BODY>");
                out.println("<SCRIPT>");
                out.println("alert('Transaction successful');");
                 out.println("location='transection.jsp';");
                out.println("</SCRIPT>");
                out.println("</BODY>");
                out.println("</HTML>");
            } else 
            {
                out.println("<HTML>");
                out.println("<HEAD>");
                out.println("<TITLE>First Servlet</TITLE>");
                out.println("</HEAD>");
                out.println("<BODY>");
                out.println("<SCRIPT>");
                out.println("alert('Transaction NOT Done');");
                 out.println("location='transection.jsp';");
                out.println("</SCRIPT>");
                out.println("</BODY>");
                out.println("</HTML>");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

  
    }

}
