<%-- 
    Document   : CustomerNewOrder2
    Created on : May 9, 2017, 1:38:35 PM
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="newcss.css" type="text/css" rel="stylesheet"/>
        <title>Opret Odrer</title>
    </head>
    <body>
        <center>
            <h1>Estimeret pris og tegning</h1>
            <%
                String height = (String)request.getAttribute("height");
                String length = (String)request.getAttribute("length");
                String width = (String)request.getAttribute("width");
                String total = (String)request.getAttribute("stringTotal");
            %>
            <img src="/img/carport.jpg" alt="Carport" style="width:304px;height:228px;"/>
            <br>
            <br>
            <br>
            <br>
            <%
                out.print("<p>Pris: " + total + " kr.</p>");
            %>
            <br>
            <br>
            <br>
            <br>
            
            <form action="OrderController" method="POST">
                Fornavn: <br> <br>  <input type="text" name="firstName"><br>
             <br>   Efternavn: <br><br>  <input type="text" name="lastName"><br>
              <br>   Tlf. Nr:   <br><br>  <input type="text" name="phone"><br>
              <br>   Email:    <br><br>   <input type="text" name="email"><br>
              <br>   Adresse: <br> <br>   <input type="text" name="address"><br>
              <br>
              <br>
              <%
                  out.print("<input type=\"hidden\" name=\"height\" value=\""+ height +"\">");
                  out.print("<input type=\"hidden\" name=\"length\" value=\""+ length +"\">");
                  out.print("<input type=\"hidden\" name=\"width\" value=\""+ width +"\">");
              %>
                <button type="submit" formaction="customerNewOrderPageOne.jsp" id="A3" class="button button1">Tilbage</button>
                <input type="submit" name="submit" value="Ja tak, bestil" class="button button1">
            </form>
        </center>
    </body>
</html>
