<%-- 
    Document   : CustomerNewOrder
    Created on : May 9, 2017, 1:35:45 PM
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="newcss.css" type="text/css" rel="stylesheet"/>
        <title>Bestil carport!</title>
    </head>
    <body>
        <center>
            <h1>Indtast de ønskede mål til din carport!</h1>
            <form action="CalculateController" method="POST">
                <br>   Højde:    <br><br>   <input type="text" name="height" placeholder="Højde i cm"><br>
                <br>   Bredde: <br>  <br>   <input type="text" name="width" placeholder="Bredde i cm"><br>
                <br>   Længde:  <br> <br>   <input type="text" name="length" placeholder="Længde i cm"><br>
                <br>
                <button type="submit" formaction="index.html" id="A3" class="button button1">Tilbage</button>
                <input type="submit" name="submit" value="Næste" class="button button1">
            </form>
        </center>
    </body>
</html>
