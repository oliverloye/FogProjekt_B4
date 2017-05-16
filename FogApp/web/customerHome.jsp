<%-- 
    Document   : customerHome
    Created on : May 16, 2017, 2:38:49 PM
    Author     : Oliver
--%>

<%@page import="data.DataAccessFacade"%>
<%@page import="data.Interfaces.IcustomerFacade"%>
<%@page import="business.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Velkommen!</title>
    </head>
    <body>
        <%
            
        Customer c = new Customer();
        session.getAttribute("customer");
        
        //c = session.getAttribute("customer")
        out.print(session.getAttribute("customer"));
        
        out.print("<h1>Hej " + c.getFirstName() + ".");
        
        %>
    </body>
</html>
