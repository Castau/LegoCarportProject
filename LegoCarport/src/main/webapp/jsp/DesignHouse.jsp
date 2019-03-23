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
        <p>In order to make sure that there is room to fit a door and a window <br> the minimum requirements for dimensions of the House are:</p>
        <p>Length min.: 8 <br> Width min.: 8 <br> Height min.: 5</p>

        <table>
            <tr><td>Designer</td>
                <tr><td>
                    <form name="design" action="Home" method="POST">
                        <input type="hidden" name="command" value="create">
                        Length:<br>
                        <input type="number" name="length" value="" required min="8">
                        <br>
                        Width:<br>
                        <input type="number" name="width" value="" required min="8">
                        <br>
                        Height:<br>
                        <input type="number" name="height" value="" required min="5">
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
        <br/>
        <br/>
        <a href="Home?command=customer"> Back to Customer Page</a>
    </body>
</html>
