<%-- 
    Document   : Customer
    Created on : 19-03-2019, 15:10:26
    Author     : Camilla
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="logic.models.HouseOrder"%>
<%@page import="logic.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = (User) request.getSession().getAttribute("user");
    ArrayList<HouseOrder> userOrders = (ArrayList<HouseOrder>) request.getAttribute("allUserOrders");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Home Page</title>
    </head>
    <body>
        <h1>Hello <%= user.getEmail()%> </h1>
        You are now logged in as a CUSTOMER of our wonderful site.

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
            <% for (int i = 0; i < userOrders.size(); i++) {%>
            <tr>
                <td>
                    <%= userOrders.get(i).getOrderID()%>
                </td>
                <td>
                    <%= userOrders.get(i).getUserID()%>
                </td>
                <td>
                    <%= userOrders.get(i).getStatus()%>
                </td>
                <td>
                    <%= userOrders.get(i).getLength()%>
                </td>
                <td>
                    <%= userOrders.get(i).getHeight()%>
                </td>
                <td>
                    <%= userOrders.get(i).getWidth()%>
                </td>
                <td>
                    <%= userOrders.get(i).isDoor()%>
                </td>
                <td>
                    <%= userOrders.get(i).isWindow()%>
                </td>
                <td>
                    <a href="Home?command=parts&orderID=<%= userOrders.get(i).getOrderID()%>"> See Parts List </a>
                </td>
            </tr>
            <% }%>
        </table>
        <a href="Home?command=design"> Design House</a>
    </body>
</html>