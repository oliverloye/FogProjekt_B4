<%-- 
    Document   : customerHome
    Created on : May 16, 2017, 2:38:49 PM
    Author     : Oliver
--%>

<%@page import="java.util.List"%>
<%@page import="business.entity.Order"%>
<%@page import="data.Interfaces.IorderFacade"%>
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
            
        Customer c = (Customer)request.getSession().getAttribute("customer");
        
        
        //c = session.getAttribute("customer")
        
        
        
        out.print("<h1>Hej " + c.getFirstName() + "\n" + c.getLastName() +".</h1>");
        out.print("<p>Dine ordrer:</p>");
        
        out.print("<table border=1>");
            out.print("<tr> "
                        + "<th>Ordre ID</th>"
                        + "<th>Kunde ID</th>"
                        + "<th>Højde</th>"
                        + "<th>Længde</th>"
                        + "<th>Bredde</th>"
                        + "<th>Pris i kr.</th>"
                    + "</tr>");

        IorderFacade orderm = new DataAccessFacade();
        int orderId;

        List<Order> allOrders = orderm.getOrders(c.getCid());

            for(Order order : allOrders) {
                out.print("<tr>");
                    out.print("<td>" + order.getOid()+ "</td>");
                    out.print("<td>" + order.getCid()+ "</td>");
                    out.print("<td>" + order.getHeight()+ "</td>");
                    out.print("<td>" + order.getLength()+ "</td>");
                    out.print("<td>" + order.getWidth()+ "</td>");
                    out.print("<td>" + order.getTotalPrice()+ "</td>");
                out.print("</tr>");
            }
        out.print("</table>");
        out.print("<br>");
        out.print("<form action=\"\" method=\"GET\">");
        out.print("<button type=\"submit\" formaction=\"login.html\" id=\"A3\" class=\"button button1\">Log ud</button>");
        out.print("</form>");
        %>
    </body>
</html>
