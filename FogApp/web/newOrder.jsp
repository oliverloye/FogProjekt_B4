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
        <h1>Indtast dine oplysninger!</h1>
        <form action="/action_page.php">
        Fornavn:   <input type="text" name="fname"><br>
        Efternavn: <input type="text" name="lname"><br>
        Tlf. Nr:   <input type="text" name="phone"><br>
        Email:     <input type="text" name="mail"><br>
        Adresse:   <input type="text" name="adress"><br>
        Højde:     <input type="text" name="height"><br>
        Bredde:    <input type="text" name="width"><br>
        Længde:    <input type="text" name="length"><br>
        <input type="submit" value="Submit">
        </form>
    </body>
</html>
