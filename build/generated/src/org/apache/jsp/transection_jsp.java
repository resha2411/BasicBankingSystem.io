package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import DB.dbconnector;
import java.sql.ResultSet;
import java.sql.Statement;

public final class transection_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <style>\n");
      out.write("            #home::before{\n");
      out.write("                content: \"\";\n");
      out.write("                background: url('images/bank5.jpg')no-repeat center center/cover;\n");
      out.write("                position:absolute;\n");
      out.write("                top:0px;\n");
      out.write("                left:0px; \n");
      out.write("                height:100%;\n");
      out.write("                width:100%;\n");
      out.write("                z-index:-1;\n");
      out.write("                opacity:0.5;\n");
      out.write("            }\n");
      out.write("            .table-fill{\n");
      out.write("                border: 2px solid black;\n");
      out.write("                padding-left: 20px;\n");
      out.write("                padding-right: 20px;\n");
      out.write("                margin-left: 60px;\n");
      out.write("                padding-top: 40px;\n");
      out.write("                margin-top: 40px;\n");
      out.write("                padding-bottom: 30px;\n");
      out.write("                background: rgb(260, 258, 233);\n");
      out.write("            }\n");
      out.write("            .text-left\n");
      out.write("            {\n");
      out.write("                border: 2px solid black;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                padding: 4px 4px;\n");
      out.write("                font-size: 110%;\n");
      out.write("            }\n");
      out.write("            input.textright\n");
      out.write("            {\n");
      out.write("                font-size: 100%;\n");
      out.write("                border: 1px solid black;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                text-align: center;\n");
      out.write("                background: floralwhite;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .color-button\n");
      out.write("            {\n");
      out.write("                color:#fff;\n");
      out.write("                background-color:#00a3cc; \n");
      out.write("                border-radius: 3px;\n");
      out.write("                padding: 3px;\n");
      out.write("            }\n");
      out.write("            .heading{\n");
      out.write("                font-size: 40px;\n");
      out.write("                line-height: 12px;\n");
      out.write("                font-weight: 500;\n");
      out.write("                margin-bottom: 0px;\n");
      out.write("                margin-top: 0px;\n");
      out.write("                padding: 40px 0px;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                background: #00a3cc;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                /*;margin: 20px;text-decoration: solid; font-size: 280%;*/\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>Transaction</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 class=\"heading\">Transaction</h1>\n");
      out.write("        <section id =\"home\"><table>\n");
      out.write("\n");
      out.write("                ");

                    Statement st = null;
                    ResultSet rs = null;
                    String email = null;
                    String name = null;
                    int id;
                    int number;
                    int balance;
                    int receiverid;
                    String receivername;
                    int money;
                
      out.write("\n");
      out.write("                <table class=\"table-fill\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th class=\"text-left\"><B>Transaction Id</B></th>\n");
      out.write("                            <th class=\"text-left\"><B>Name</B> </th>\n");
      out.write("                            <th class=\"text-left\"><B>Email</B></th>\n");
      out.write("                            <th class=\"text-left\"><B>Number</B> </th>\n");
      out.write("                            <th class=\"text-left\"><B>Current Balance</B></th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    ");

                        try {
                            st = dbconnector.getStatement();
                            String query = "select * from customer";
                            System.out.println(query);
                            rs = st.executeQuery(query);
                            while (rs.next()) {
                                id = rs.getInt(1);
                                name = rs.getString(2);
                                email = rs.getString(3);
                                number = rs.getInt(4);
                                balance = rs.getInt(5);
                    
      out.write("\n");
      out.write("                    <tbody class =\"table-hover\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"text-right\"><input class=\"textright\" type=\"text\" value=\"");
      out.print(id);
      out.write(" \"name=\"Transcation Id\"readonly></td>\n");
      out.write("                            <td class=\"text-right\"><input class=\"textright\"type=\"text\" value=\"");
      out.print( name);
      out.write("\"name=\"Name\"readonly></td>\n");
      out.write("                            <td class=\"text-right\"><input class=\"textright\"type=\"text\" value=\"");
      out.print( email);
      out.write("\"name=\"Email\"readonly></td>\n");
      out.write("                            <td class=\"text-right\"><input class=\"textright\"type=\"text\" value=\"");
      out.print( number);
      out.write("\"name=\"Number\"readonly></td>\n");
      out.write("                            <td class=\"text-right\"><input class=\"textright\" type=\"text\" value=\"");
      out.print( balance);
      out.write("\"name=\"Current Balance\"readonly></td>\n");
      out.write("                            <!--<td class=\"text-left\"><form action=\"money\"method=\"post\"><input type=\"submit\"value=\"Transact\"readonly</td>-->\n");
      out.write("                            <td class=\"text-right\"><button onclick=\"document.getElementById('id01').style.display = 'block'\" class=\"color-button\">Transaction</button></td>                  \n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                    <div id=\"id01\" class=\"w3-modal\">\n");
      out.write("                        <div class=\"w3-modal-content w3-card-4\">\n");
      out.write("                            <header class=\"w3-container w3-teal\"> \n");
      out.write("                                <span onclick=\"document.getElementById('id01').style.display = 'none'\" class=\"w3-button w3-display-topright\">&times;</span>\n");
      out.write("                                <h1 style=\"color:white;padding: 10px 0 5px 20px;font-size:40px;\"><center><strong><b>Transaction</b></strong></center></h1>\n");
      out.write("                            </header>\n");
      out.write("                            <div class=\"w3-container\">\n");
      out.write("                                <div class=\"form\">\n");
      out.write("                                    <form action=\"money\" method=\"post\">\n");
      out.write("                                        <label for=\"lname\" class=\"labelc\">Sender ID :</label>\n");
      out.write("                                        <input type=\"number\" id=\"lname\" name=\"senderid\" placeholder=\"Sender ID...\">\n");
      out.write("                                        <br><br> \n");
      out.write("                                        <label for=\"lname\" class=\"labelc\">Sender Name : </label>\n");
      out.write("                                        <input type=\"text\" id=\"lname\" name=\"sendername\" placeholder=\"Sender Name..\">\n");
      out.write("                                        <br><br> \n");
      out.write("                                        <label for=\"lname\" class=\"labelc\">Sender Balance : </label>\n");
      out.write("                                        <input type=\"number\" id=\"lname\" name=\"senderbalance\" placeholder=\"Sender Balance\">\n");
      out.write("                                        <br><br> \n");
      out.write("                                        <label for=\"lname\" class=\"labelc\">Receiver ID : </label>\n");
      out.write("                                        <input type=\"number\" id=\"lname\" name=\"receiverid\" placeholder=\"Receiver ID...\">\n");
      out.write("                                        <br><br> \n");
      out.write("                                        <label for=\"lname\" class=\"labelc\">Receiver Name : </label>\n");
      out.write("                                        <input type=\"text\" id=\"lname\" name=\"receivername\" placeholder=\"Receiver Name\">\n");
      out.write("                                        <br>  <br>                                  \n");
      out.write("                                        <label for=\"lname\" class=\"labelc\">Amount Transfer : </label>\n");
      out.write("                                        <input type=\"number\" id=\"lname\" name=\"money\" placeholder=\"Amount Transfer...\">\n");
      out.write("                                        <br>\n");
      out.write("                                        <!--<input type=\"hidden\" id=\"lname\" name=\"time\" value=\"\">-->\n");
      out.write("\n");
      out.write("                                        <footer class=\"w3-container w3-teal\">\n");
      out.write("                                            <input type=\"submit\" value=\"Transfer\">\n");
      out.write("                                        </footer>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                                }
                            } catch (SQLException e) {
                                System.out.println(e);
                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                </table>\n");
      out.write("        </section>\n");
      out.write("        <script>\n");
      out.write("            // Get the modal\n");
      out.write("            var modal = document.getElementById('id01');\n");
      out.write("\n");
      out.write("            // When the user clicks anywhere outside of the modal, close it\n");
      out.write("            window.onclick = function (event) {\n");
      out.write("                if (event.target == modal) {\n");
      out.write("                    modal.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <!-- Javascript files--> \n");
      out.write("        <script src=\"js/jquery.min.js\"></script> \n");
      out.write("        <script src=\"js/popper.min.js\"></script> \n");
      out.write("        <script src=\"js/bootstrap.bundle.min.js\"></script> \n");
      out.write("        <script src=\"js/jquery-3.0.0.min.js\"></script> \n");
      out.write("        <script src=\"js/plugin.js\"></script> \n");
      out.write("\n");
      out.write("        <!-- sidebar --> \n");
      out.write("        <script src=\"js/jquery.mCustomScrollbar.concat.min.js\"></script> \n");
      out.write("        <script src=\"js/custom.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
