<%-- 
    Document   : editOrder
    Created on : Apr 20, 2017, 11:47:48 AM
    Author     : Oliver
--%>
<%@page import="data.OrderMapper"%>
<% OrderMapper om = new OrderMapper(); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Order:</p>
        <%= out.print(request.getParameter("orderId"))%>
    </body>
</html>
