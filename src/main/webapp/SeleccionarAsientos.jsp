<%-- 
    Document   : SeleccionarAsientos
    Created on : Apr 5, 2021, 8:12:35 PM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form id="reservation" method="post" action="test.php">
            <section id="seats">
                <%
                    String seat = "seat-";
                    int top = 160;
                    int g = 0;
                    int y = 1;
                    int sumtop = 44;
                    double right = 0;
                    for (int e = 0; e < 3; e++) {
                        top += sumtop;
                %>
                <p style= "position: relative;top:<%=top%>px;right:<%=right%>%;">
                    <%
                        right = 15.9 * y;
                        y++;
                        for (int i = 0; i < 6; i++) {
                            seat = seat + g;
                        g++;
                        if (i == 3) {%>  
                    <% }
                    %>
                    <input id="<%=seat%>" class="seat-select" type="checkbox" value="<%=g%>" name="seat[]" />
                    <label for="<%=seat%>" class="seat"></label> 

                    <% seat = "seat-";
                    } %>
                </p>
                <% } %>

            </section>

            <section id="seats1">
                <%
                    int top1 = 160;
                    int y1 = 1;
                    int sumtop1 = 44;
                    double right1 = 0;
                    for (int e = 0; e < 3; e++) {
                        top += sumtop1;
                %>
                <p style= "position: relative;top:<%=top%>px;right:<%=right1%>%;">
                    <%
                        right1 = 15.9 * y1;
                        y1++;
                        for (int i = 0; i < 6; i++) {
                            seat = seat + g;
                            g++;
                    %>
                    <input id="<%=seat%>" class="seat-select" type="checkbox" value="<%=g%>" name="seat[]" />
                    <label for="<%=seat%>" class="seat"></label> 

                    <% seat = "seat-";
                    } %>
                </p>
                <% }%>
                
            </section>
            <input type="submit"/>
        </form>
        
        <img src="style/Imagenes/avion.png" alt="" id="avion"/>
        
    </body>
</html>
