<%-- 
    Document   : editOrder
    Created on : Apr 20, 2017, 11:47:48 AM
    Author     : Oliver
--%>
<%@page import="data.Interfaces.IcustomerFacade"%>
<%@page import="data.DataAccessFacade"%>
<%@page import="data.Interfaces.IorderFacade"%>
<%@page import="business.entity.Customer"%>
<%@page import="business.entity.Order"%>
<%@page import="data.CustomerMapper"%>
<%@page import="data.OrderMapper"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            IcustomerFacade cm = new DataAccessFacade();
            IorderFacade orderm = new DataAccessFacade();
            
            Order order = null;
            Customer customer = null;
            
            String oid = request.getParameter("orderId");
            String cid = request.getParameter("customerId");
            
            int intOid = Integer.parseInt(oid);
            int intCid = Integer.parseInt(cid);
            
            order = orderm.getOrder(intOid);
            customer = cm.getCustomer(intCid);
           
        out.print("<center>");
            out.print("<h1>Indtast dine oplysninger!</h1>");
            out.print("<form action=\"UpdateController\" method=\"POST\">");
            out.print("<input type=\"hidden\" name=\"thisCustomer\" value=" + request.getParameter("customerId") +">");
            out.print("<input type=\"hidden\" name=\"thisOrder\" value=" + request.getParameter("orderId") +">");
                out.print("Fornavn: <br> <br>  <input type=\"text\" name=\"firstName\" value=" + customer.getFirstName() + "><br>");
              out.print("<br>   Efternavn: <br><br>  <input type=\"text\" name=\"lastName\" value=" + customer.getLastName() + "><br>");
              out.print("<br>   Tlf. Nr:   <br><br>  <input type=\"text\" name=\"phone\" value=" + customer.getPhone() + "><br>");
              out.print("<br>   Email:    <br><br>   <input type=\"text\" name=\"email\" value=" + customer.getEmail() + "><br>");
              out.print("<br>   Adresse: <br> <br>   <input type=\"text\" name=\"address\" value=" + customer.getAddress() + "><br>");
              out.print("<br>   Højde:    <br><br>   <input type=\"text\" name=\"height\" value=" + order.getHeight() + "><br>");
              out.print("<br>   Bredde: <br>  <br>   <input type=\"text\" name=\"width\" value=" + order.getWidth() + "><br>");
              out.print("<br>   Længde:  <br> <br>   <input type=\"text\" name=\"length\" value=" + order.getLength() + "><br>");
                out.print("<br>");
                out.print("<button type=\"submit\" formaction=\"orderList.jsp\" id=\"A3\" class=\"button button1\">Tilbage</button>");
                out.print("<input type=\"submit\" name=\"submit\" value=\"Gem ændringer\" class=\"button button1\">");
            out.print("</form>");
        out.print("</center>");
        %>
    </body>
</html>
