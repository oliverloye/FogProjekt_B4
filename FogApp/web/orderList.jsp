<%-- 
    Document   : orderList
    Created on : Mar 30, 2017, 3:35:13 PM
    Author     : Oliver
--%>

<%@page import="data.DataAccessFacade"%>
<%@page import="data.Interfaces.IorderFacade"%>
<%@page import="java.util.List"%>
<%@page import="business.entity.Order"%>
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
                    
                    List<Order> allOrders = orderm.getOrders();
                    
                        for(Order order : allOrders) {
                            out.print("<tr>");
                                out.print("<td>" + order.getOid()+ "</td>");
                                out.print("<td>" + order.getCid()+ "</td>");
                                out.print("<td>" + order.getHeight()+ "</td>");
                                out.print("<td>" + order.getLength()+ "</td>");
                                out.print("<td>" + order.getWidth()+ "</td>");
                                out.print("<td>" + order.getTotalPrice()+ "</td>");
                                out.print("<td>"
                                        + "<form name=\"orderList\" action=\"editOrder.jsp\" method=\"POST\">"
                                        + "<input type=\"hidden\" name=\"orderId\" value=" + order.getOid() +">"
                                        + "<input type=\"hidden\" name=\"customerId\" value=" + order.getCid() +">"
                                        + "<input type=\"submit\" value=\"Se/Rediger\">"
                                        + "</form>"
                                        + "</td>");
                                out.print("<td>"
                                        + "<form name=\"deleteOrder\" action=\"DeleteController\" method=\"POST\">"
                                        + "<input type=\"hidden\" name=\"orderId\" value=" + order.getOid() +">"
                                        + "<input type=\"submit\" value=\"Slet\">"
                                        + "</form>"
                                        + "</td>");
                            out.print("</tr>");
                        
   
                        }
                    out.print("</table>");
                %>
            </p>
            <form name="backButton" action="adminPage.html"> 
                <button type="submit" id="A3" class="button button1">Tilbage</button>
            </form>
    </body>
</html>