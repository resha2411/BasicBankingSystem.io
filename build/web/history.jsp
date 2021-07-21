<%-- 
    Document   : history
    Created on : 7 Jun, 2021, 7:14:46 PM
    Author     : reet
--%>

<%@page import="DB.dbconnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer History</title>
          <style>
.body
{
    margin:0px;
    padding:0px;
}
 #home::before{
                content: "";
                background: url('images/bank5.jpg')no-repeat center center/cover;
                position:absolute;
                top:0px;
                left:0px; 
                height:100%;
                width:100%;
                z-index:-1;
                opacity:0.5;
            }
            .table-fill{

                border: 3px solid black;
                padding-left: 20px;
                padding-right: 20px;
                padding-top: 40px;
                background: rgb(260, 258, 233);
                margin: 47px auto;
                align-content: center;
                padding-bottom: 30px;
                
            }
            .text-left
            {
                border: 2px solid black;
                border-radius: 4px;
                padding: 4px 4px;
                font-size: 120%;
            }
            .heading{
                font-size: 40px;
                line-height: 12px;
                font-weight: 500;
                margin-bottom: 0px;
                margin-top: 0px;
                
                padding: 40px 0px;
                text-transform: uppercase;
                background: #00a3cc;
                color: white;
                text-align: center;

            }
            input.textright
            {
                font-size: 100%;
                border: 1px solid black;
                border-radius: 3px;
                text-align: center;
                background: floralwhite;
            }
        </style>
    </head>
    <body class="body">
        <h1 class="heading">Customer History</h1>
        <section id ="home">
        <table>

            <%
                Statement st = null;
                ResultSet rs = null;
                String sname = null;
                String  rname= null;
                int sid;
                int rid;
                int amount;
            %>
            <table class="table-fill">
                <thead>
                    <tr>
                        <th class="text-left"><B>Sender Id</B></th>
                        <th class="text-left"><B>Sender Name</B> </th>
                        <th class="text-left"><B>Amount Transfer</B></th>
                        <th class="text-left"><B>Receiver Id</B> </th>
                        <th class="text-left"><B>Receiver Name</B></th>
                    </tr>
                </thead>
                <%
                    
                    try {
                        st = dbconnector.getStatement();
                        String query = "select * from history_customer";
                        System.out.println(query);
                        rs=st.executeQuery(query);
                        while (rs.next()) {
                            sid = rs.getInt(1);
                            sname = rs.getString(2);
                            amount = rs.getInt(3);
                            rid = rs.getInt(4);
                            rname = rs.getString(5);
                %>
                <tbody class ="table-hover">
                    <tr>
                        <td ><input class="textright" type="text" value="<%=sid%> "name="Sender Id"readonly</td>
                        <td ><input class="textright"type="text" value="<%= sname%>"name="Sender Name"readonly</td>
                        <td ><input class="textright"type="text" value="<%= amount%>"name="Amount Transfer"readonly</td>
                        <td ><input class="textright"type="text" value="<%= rid%>"name="Receiver Id"readonly</td>
                        <td ><input class="textright"type="text" value="<%= rname%>"name="Receiver Name"readonly</td>
                    </tr>
                </tbody>

                <% 
               }
               }
                catch (SQLException e) 
                {
                    System.out.println(e);
                }
                %>


            </table> 
        </section>
    </body>
</html>
