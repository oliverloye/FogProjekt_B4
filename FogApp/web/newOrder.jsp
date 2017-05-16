<%-- 
    Document   : newOrder
    Created on : 03-04-2017, 11:16:30
    Author     : Alexander
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
            <h1>Indtast dine oplysninger!</h1>
            <form action="CalculateAdminController" method="POST">
                Fornavn: <br> <br>  <input type="text" name="firstName"><br>
              <br>   Efternavn: <br><br>  <input type="text" name="lastName"><br>
              <br>   Tlf. Nr:   <br><br>  <input type="text" name="phone"><br>
              <br>   Email:    <br><br>   <input type="text" name="email"><br>
              <br>   Adresse: <br> <br>   <input type="text" name="address"><br>
              <br>   Højde:    <br><br>   <input type="text" name="height"><br>
              <br>   Bredde: <br>  <br>   <input type="text" name="width"><br>
              <br>   Længde:  <br> <br>   <input type="text" name="length"><br>
                <br>
                <button type="submit" formaction="adminPage.html" id="A3" class="button button1">Tilbage</button>
                <input type="submit" name="submit" value="Opret" class="button button1">
            </form>
        </center>
    </body>
</html>
