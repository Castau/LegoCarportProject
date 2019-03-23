<%-- 
    Document   : Customer
    Created on : 19-03-2019, 15:10:26
    Author     : Camilla
--%>

<jsp:include page='Header.jsp'></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.models.HouseOrder"%>
<%@page import="logic.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = (User) request.getSession().getAttribute("user");
    ArrayList<HouseOrder> userOrders = (ArrayList<HouseOrder>) request.getAttribute("allUserOrders");
%>
<body>
    <div class='center'>
        <div class='legoContainer center'>
            <h1>Logged in as: <%= user.getEmail()%> </h1>
            <p>You are now logged in as a CUSTOMER. <br> Design a new house or check your previous orders</p>

            <a href="Home?command=design" class='button'> <button class="btn marginBottom1"><i class="fa fa-home"></i> Design House</button></a>

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
                        <% if (userOrders.get(i).isDoor()) { %>
                        <i class="fa fa-check"></i>
                        <% } else { %>
                        <i class="fa fa-times"></i>
                        <% }%>
                    </td>
                    <td>
                        <% if (userOrders.get(i).isWindow()) { %>
                        <i class="fa fa-check"></i>
                        <% } else { %>
                        <i class="fa fa-times"></i>
                        <% }%>
                    </td>
                    <td>
                        <a href="Home?command=parts&orderID=<%= userOrders.get(i).getOrderID()%>"> See Parts List </a>
                    </td>
                </tr>
                <% }%>
            </table>
        </div>
    </div> 

</body>
</html>