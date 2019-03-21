<%-- 
    Document   : Parts
    Created on : 21-03-2019, 19:16:57
    Author     : Camilla
--%>

<%@page import="logic.models.Parts"%>
<%@page import="logic.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = (User) request.getSession().getAttribute("user");
    Parts orderParts = (Parts) request.getAttribute("parts");
    int orderId = Integer.parseInt(request.getParameter("orderID"));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PartsList</title>
    </head>
    <body>
        <h1>Parts List for Order nr: <%=orderId%></h1>
        
        <table>
            <tr>
                <th>
                    1x2 Brick
                </th>
                <th>
                    2x2 Brick
                </th>
                <th>
                    4x2 Brick
                </th>
                <th>
                    Door
                </th>
                <th>
                    Window
                </th>
            </tr>
            <tr>
                <td>
                    <%= orderParts.getOnes() %>
                </td>
                <td>
                    <%= orderParts.getTwos() %>
                </td>
                <td>
                    <%= orderParts.getFours() %>
                </td>
                <td>
                    <%= orderParts.isDoor() %>
                </td>
                <td>
                    <%= orderParts.isWindow() %>
                </td>
            </tr>
        </table>
        
    </body>
</html>
