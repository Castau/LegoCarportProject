<%-- 
    Document   : Employee
    Created on : 19-03-2019, 15:10:47
    Author     : Camilla
--%>

<%@page import="logic.models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.models.HouseOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    ArrayList<HouseOrder> orders = (ArrayList<HouseOrder>) request.getAttribute("allOrders");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Home Page</title>
    </head>
    <body>

        <h1>Hello <%= user.getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        <br/>
        <br/>
        <table>
            <tr>
                <th>
                    Order ID
                </th>
                <th>
                    Customer ID
                </th>
                <th>
                    Order Status
                </th>
                <th>
                    House Length
                </th>
                <th>
                    House Height
                </th>
                <th>
                    House Width
                </th>
                <th>
                    Door Chosen
                </th>
                <th>
                    Window Chosen
                </th>
                <th>
                    See Parts List
                </th>
            </tr>
            <% for (int i = 0; i < orders.size(); i++) {%>
            <tr>
                <td>
                    <%= orders.get(i).getOrderID()%>
                </td>
                <td>
                    <%= orders.get(i).getUserID()%>
                </td>
                <td>
                    <%= orders.get(i).getStatus()%>
                </td>
                <td>
                    <%= orders.get(i).getLength()%>
                </td>
                <td>
                    <%= orders.get(i).getHeight()%>
                </td>
                <td>
                    <%= orders.get(i).getWidth()%>
                </td>
                <td>
                    <%= orders.get(i).isDoor()%>
                </td>
                <td>
                    <%= orders.get(i).isWindow()%>
                </td>
                <td>
                    <a href="Home?command=employee"> Not working yet</a>
                </td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
