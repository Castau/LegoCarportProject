<%-- 
    Document   : DesignHouse
    Created on : 19-03-2019, 21:08:02
    Author     : Camilla
--%>
<jsp:include page='Header.jsp'></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class='center'>
        <div class='legoContainer center'>
            <h1>Design your Lego House</h1>
            <p>In order to make sure that there is room to fit a door and a window <br> the minimum requirements for dimensions of the House are:</p>
            <div class="width200 centerElement textleft">
                <p>Length min.: 8 <br> Width min.: 8 <br> Height min.: 5</p>
                <div class="width100p">
                    <form name="design" action="Home" method="POST">
                        <input class='form-control' type="hidden" name="command" value="create">
                        Length:<br>
                        <input class='form-control' type="number" name="length" value="" required min="8">
                        <br/>
                        Width:<br>
                        <input class='form-control' type="number" name="width" value="" required min="8">
                        <br/>
                        Height:<br>
                        <input class='form-control' type="number" name="height" value="" required min="5">
                        <br/>
                        <input class='form-check-input' type="checkbox" name="door" value="door"> Add Front Door<br>
                        <input class='form-check-input' type="checkbox" name="window" value="window"> Add Side Window<br>
                        <br/>
                        <div class="center">
                            <button type="submit" class="btn marginBottom1"><i class="fas fa-tools iconMarginRight"></i>Create House</button>
                        </div>
                    </form>
                </div>
            </div>
            <br/>
            <br/>
            <a href="Home?command=customer" class='button'> <button class="btn marginBottom1"><i class="fas fa-chevron-left iconMarginRight"></i>Back</button></a>
        </div>
    </div>
</body>
</html>
