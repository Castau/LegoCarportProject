<%-- 
    Document   : Parts
    Created on : 21-03-2019, 19:16:57
    Author     : Camilla
--%>
<%@page import="logic.models.HouseOrder"%>
<jsp:include page='Header.jsp'></jsp:include>
<%@page import="logic.models.Parts"%>
<%@page import="logic.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = (User) request.getSession().getAttribute("user");
    Parts orderParts = (Parts) request.getAttribute("parts");
    int orderId = Integer.parseInt(request.getParameter("orderID"));
    HouseOrder houseOrder = (HouseOrder) request.getAttribute("houseorder");
%>
    <div class='center'>
        <div class='legoContainer center'>
            <h1>Parts List for Order nr: <%=orderId%></h1>
            <p>The order has the following dimensions: <br> Length <%=houseOrder.getLength()%> | Width  <%=houseOrder.getWidth()%> | Height <%=houseOrder.getHeight()%></p>
            <table class='centerElement table table-hover'>
                <tr>
                    <th>1x2 Brick</th>
                    <td><%= orderParts.getOnes()%></td>
                    </th> 
                <tr>
                    <th>2x2 Brick</th>
                    <td><%= orderParts.getTwos()%></td>
                    </th>
                <tr>
                    <th>4x2 Brick</th>
                    <td><%= orderParts.getFours()%></td>
                    </th>
                <tr>
                    <th>Door</th>
                    <td>
                        <% if (orderParts.isDoor()) { %>
                        <i class="fa fa-check"></i>
                        <% } else { %>
                        <i class="fa fa-times"></i>
                        <% }%>
                    </td>
                    </th>
                <tr>
                    <th>Window</th>
                    <td>
                        <% if (orderParts.isWindow()) { %>
                        <i class="fa fa-check"></i>
                        <% } else { %>
                        <i class="fa fa-times"></i>
                        <% }%>
                    </td>
                </tr>
            </table>
            <br/>
            <br/>
            <% if (User.Role.employee == user.getRole()) { %>
            <a href="Home?command=employee" class='button'> <button class="btn marginBottom1"><i class="fas fa-chevron-left iconMarginRight"></i>Back</button></a>
            <% } else { %>
            <a href="Home?command=customer" class='button'> <button class="btn marginBottom1"><i class="fas fa-chevron-left iconMarginRight"></i>Back</button></a>
            <% }%>
        </div>
    </div>
</body>
</html>
