<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<jsp:include page='jsp/Header.jsp'></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class='center'>
        <div class='legoContainer center'>
            <h1>Lego Carport Project</h1>
            <div class="width200 centerElement textleft">
                <div class="width100p">
                    <form name="login" action="Home" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input class='form-control' type="text" name="email" value="" placeholder="">
                        <br>
                        Password:<br>
                        <input class='form-control' type="password" name="password" value="" placeholder="">
                        <br>
                        <div class="center">
                            <button type="submit" class="btn marginBottom1"><i class="fas fa-sign-in-alt iconMarginRight"></i>Login</button>
                        </div>
                    </form>
                    <br>
                    <form name="register" action="Home" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input class='form-control' type="text" name="email" value="" placeholder="">
                        <br>
                        Password:<br>
                        <input class='form-control' type="password" name="password1" value="" placeholder="">
                        <br>
                        Retype Password:<br>
                        <input class='form-control' type="password" name="password2" value="" placeholder="">
                        <br>
                        <div class="center">
                            <button type="submit" class="btn marginBottom1"><i class="fas fa-user-plus iconMarginRight"></i>Register</button>
                        </div>
                    </form>
                    <% String error = (String) request.getAttribute("error");
                        if (error != null) {
                            out.println("<H2>Error!!</h2>");
                            out.println(error);
                        }
                    %>
                </div>
            </div>
        </div> 
    </div> 
</body>
</html>
