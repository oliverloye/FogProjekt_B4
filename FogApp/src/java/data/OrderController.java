/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Oliver
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                CustomerMapper cm = new CustomerMapper();
                OrderMapper om = new OrderMapper();
                int customerId;
                
                try {
                    response.setContentType("text/html; charset=UTF-8");

                    //Henter data fra newOrder.jsp
                    //Customer data
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String address = request.getParameter("address");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    //Order data
                    String height = request.getParameter("height");
                    String length = request.getParameter("length");
                    String width = request.getParameter("width");

                    //Der skal være en tjek-funktion, som tjekker om input fra jsp er korrekt input, før vi arbejder videre med data.
                    //Laver carports mål om til double
                    Double.parseDouble(height);
                    Double.parseDouble(length);
                    Double.parseDouble(width);

                    if(cm.checkEmailExists(email) == false) {

                        cm.setCustomer(firstName, lastName, address, email, phone);

                        customerId = cm.getCustomerId(firstName, lastName, email).getCustomerId();

                        om.setOrder(height, length, width, customerId);

                        request.getRequestDispatcher("index.html").forward(request, response);

                    } else {

                        customerId = cm.getCustomerId(firstName, lastName, email).getCustomerId();

                        om.setOrder(height, length, width, customerId);

                        request.getRequestDispatcher("index.html").forward(request, response);


                    } 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                
        }
    

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
