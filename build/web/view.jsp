<%-- 
    Document   : view
    Created on : 7 Jun, 2021, 9:53:54 PM
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
        <title>View Customer</title>
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
               margin: 45px auto;;
                align-content: center;
                padding-bottom: 30px;
            }
            .text-left
            {
                border: 2px solid black;
                border-radius: 4px;
                padding: 4px 4px;
                font-size: 110%;

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
        <h1 class="heading">Customer Details</h1>


        <%
            Statement st = null;
            ResultSet rs = null;
            String email = null;
            String name = null;
            int id;
            int number;
            int balance;
        %>
       <section id ="home"> <table class="table-fill">
            <thead>
                <tr>
                    <th class="text-left"><B>Transaction Id</B></th>
                    <th class="text-left"><B>Name</B> </th>
                    <th class="text-left"><B>Email</B></th>
                    <th class="text-left"><B>Number</B> </th>
                    <th class="text-left"><B>Current Balance</B></th>
                </tr>
            </thead>
            <%
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
            %>
            <tbody class ="table-hover">
                <tr>
                    <td ><input class="textright" type="text" value="<%=id%> "name="Transcation Id"readonly</td>
                    <td ><input class="textright"type="text" value="<%= name%>"name="Name"readonly</td>
                    <td ><input class="textright"type="text" value="<%= email%>"name="Email"readonly</td>
                    <td ><input class="textright"type="text" value="<%= number%>"name="Number"readonly</td>
                    <td ><input class="textright"type="text" value="<%= balance%>"name="Current Balance"readonly</td>
                </tr>
            </tbody>

            <%
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            %>


        </table>    
            </section>
    </body>
</html>
