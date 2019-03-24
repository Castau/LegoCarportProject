<%-- 
    Document   : Employee
    Created on : 19-03-2019, 15:10:47
    Author     : Camilla
--%>
<jsp:include page='Header.jsp'></jsp:include>
<%@page import="logic.models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.models.HouseOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    ArrayList<HouseOrder> orders = (ArrayList<HouseOrder>) request.getAttribute("allOrders");
%>
    <div class='center'>
        <div class='legoContainer center'>
            <h1>Logged in as: <%= user.getEmail()%> </h1>
            <p>You are now logged in as a EMPLOYEE. <br> Here is the list of all orders in the system. Mark orders when you ship them.</p>
            <br/>
            <br/>
            <table class='centerElement table table-hover'>
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
                    <th>
                        Seet Order As SHIPPED
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
                        <% if (orders.get(i).isDoor()) { %>
                        <i class="fa fa-check"></i>
                        <% } else { %>
                        <i class="fa fa-times"></i>
                        <% }%>
                    </td>
                    <td>
                        <% if (orders.get(i).isWindow()) { %>
                        <i class="fa fa-check"></i>
                        <% } else { %>
                        <i class="fa fa-times"></i>
                        <% }%>
                    </td>
                    <td>
                        <a href="Home?command=parts&orderID=<%= orders.get(i).getOrderID()%>"> See Parts List </a>
                    </td>
                    <td>
                        <form name="shipbutton" action="Home" method="POST">
                            <input type="hidden" name="command" value="ship">
                            <button class='btnSmall' name="ship" type="submit" value="<%= orders.get(i).getOrderID()%>">
                                Ship Order
                            </button>
                        </form>
                    </td>
                </tr>
                <% }%>
            </table>
        </div>
    </div> 
</body>
</html>
