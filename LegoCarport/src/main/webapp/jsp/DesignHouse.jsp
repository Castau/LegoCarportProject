<%-- 
    Document   : DesignHouse
    Created on : 19-03-2019, 21:08:02
    Author     : Camilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Designer</title>
    </head>
    <body>

        <h1>Design your Lego House</h1>

        <table>
            <tr><td>Designer</td>
                <tr><td>
                    <form name="design" action="Home" method="POST">
                        <input type="hidden" name="command" value="create">
                        Length:<br>
                        <input type="number" name="length" value="" required min="1">
                        <br>
                        Width:<br>
                        <input type="number" name="width" value="" required min="1">
                        <br>
                        Height:<br>
                        <input type="number" name="height" value="" required min="1">
                        <br>
                        <br>
                        <input type="checkbox" name="door" value="door"> Add Front Door<br>
                        <input type="checkbox" name="window" value="window"> Add Side Window<br>
                        <br>
                        <input type="submit" value="Create House">
                    </form>
                </td></tr>
            </tr>
        </table>
    </body>
</html>
