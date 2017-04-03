<%-- 
    Document   : orderList
    Created on : Mar 30, 2017, 3:35:13 PM
    Author     : Oliver
--%>

<%@page import="java.util.List"%>
<%@page import="domain.entity.Order"%>
<%@page import="data.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fog Application</title>
    </head>
    <body>
        <h1>Bestillinger</h1>
        <br>
        <p>
            <%
                OrderMapper orderm = new OrderMapper();
                List<Order> allOrders = orderm.getOrders();
            %>
        </p>
    </body>
</html>
