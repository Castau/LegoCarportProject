<%-- 
    Document   : Customer
    Created on : 19-03-2019, 15:10:26
    Author     : Camilla
--%>

<%@page import="logic.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% User user = (User) request.getSession().getAttribute("user"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Home Page</title>
    </head>
    <body>
        <h1>Hello <%= user.getEmail()%> </h1>
        You are now logged in as a CUSTOMER of our wonderful site.
        
        <a href="Home?command=design"> Design House</a>
    </body>
</html>