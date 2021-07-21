<%-- 
    Document   : transaction
    Created on : 7 Jun, 2021, 7:15:20 PM
    Author     : reet
--%>


<%@page import="java.sql.SQLException"%>
<%@page import="DB.dbconnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="w3.css">
        <style>
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
                border: 2px solid black;
                padding-left: 20px;
                padding-right: 20px;
                margin-left: 80px;
                padding-top: 40px;
                margin-top: 40px;
                padding-bottom: 30px;
                background: rgb(260, 258, 233);
            }
            .text-left
            {
                border: 2px solid black;
                border-radius: 4px;
                padding: 4px 4px;
                font-size: 110%;
            }
            input.textright
            {
                font-size: 100%;
                border: 1px solid black;
                border-radius: 3px;
                text-align: center;
                background: floralwhite;
            }

            .color-button
            {
                color:#fff;
                background-color:#00a3cc; 
                border-radius: 3px;
                padding: 3px;
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
                /*;margin: 20px;text-decoration: solid; font-size: 280%;*/
            }
        </style>
        <title>Transaction</title>
    </head>
    <body>
        <h1 class="heading">Transaction</h1>
        <section id ="home"><table>

                <%
//                      String sendername = (String) request.getSession().getAttribute("name");
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
                %>
                <table class="table-fill">
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
   
                            String query = "select * from customer ";
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
                            <td class="text-right"><input class="textright" type="text" value="<%=id%> "name="Transaction Id"readonly></td>
                            <td class="text-right"><input class="textright"type="text" value="<%= name%>"name="Name"readonly></td>
                            <td class="text-right"><input class="textright"type="text" value="<%= email%>"name="Email"readonly></td>
                            <td class="text-right"><input class="textright"type="text" value="<%= number%>"name="Number"readonly></td>
                            <td class="text-right"><input class="textright" type="text" value="<%= balance%>"name="Current Balance"readonly></td>
                            <!--<td class="text-left"><form action="money"method="post"><input type="submit"value="Transact"readonly</td>-->
                            <td class="text-right"><button onclick="document.getElementById('id01').style.display = 'block'" class="color-button">Transaction</button></td>                  
                        </tr>

                    <div id="id01" class="w3-modal">
                        <div class="w3-modal-content w3-card-4">
                            <header class="w3-container w3-teal"> 
                                <span onclick="document.getElementById('id01').style.display = 'none'" class="w3-button w3-display-topright">&times;</span>
                                <h1 style="color:white;padding: 0px 0 0px 20px;font-size:40px;"><center><strong><b>Transaction</b></strong></center></h1>
                            </header>
                            <div class="w3-container">
                                <div class="form">
                                    <form action="money" method="post">
                                        <label for="lname" class="labelc">Sender ID :</label>
                                        <input type="number" id="lname" name="senderid" placeholder="Sender ID" >
                                        <br><br> 
                                        <label for="lname" class="labelc">Sender Name    : </label>
                                        <input type="text" id="lname" name="sendername"  placeholder="Sender Name">
                                        <br><br> 
                                        <label for="lname" class="labelc">Sender Balance : </label>
                                        <input type="number" id="lname" name="senderbalance"  placeholder="Sender Balance" >
                                        <br><br> 
                                        <label for="lname" class="labelc">Receiver ID    : </label>
                                        <input type="number" id="lname" name="receiverid" placeholder="Receiver ID">
                                        <br><br> 
                                        <label for="lname" class="labelc">Receiver Name  : </label>
                                        <input type="text" id="lname" name="receivername" placeholder="Receiver Name">
                                        <br>  <br>                                  
                                        <label for="lname" class="labelc">Amount Transfer : </label>
                                        <input type="number" id="lname" name="money" placeholder="Amount Transfer">
                                        <br>
                                        <!--<input type="hidden" id="lname" name="time" value="">-->

                                        <footer class="w3-container w3-teal">
                                            <input type="submit" value="Transfer">
                                        </footer>
                                    </form>
                                </div>
                            </div>
                        </div>


                        <%
                                }

                            } catch (SQLException e) {
                                System.out.println(e);
                            }
                        %>

                        </tbody>
                </table>
        </section>
        <script>
            // Get the modal
            var modal = document.getElementById('id01');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
        <!-- Javascript files--> 
        <script src="js/jquery.min.js"></script> 
        <script src="js/popper.min.js"></script> 
        <script src="js/bootstrap.bundle.min.js"></script> 
        <script src="js/jquery-3.0.0.min.js"></script> 
        <script src="js/plugin.js"></script> 

        <!-- sidebar --> 
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script> 
        <script src="js/custom.js"></script>
    </body>
</html>

