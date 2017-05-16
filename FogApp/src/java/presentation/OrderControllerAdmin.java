/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataAccessFacade;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.Interfaces.IcustomerFacade;
import data.Interfaces.IorderFacade;


/**
 *
 * @author Oliver
 */
@WebServlet(name = "OrderControllerAdmin", urlPatterns = {"/OrderControllerAdmin"})
public class OrderControllerAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                IcustomerFacade cm = new DataAccessFacade();
                IorderFacade om = new DataAccessFacade();
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

                    //Der bør være en tjek-funktion, som tjekker om input fra jsp er korrekt type input, før vi arbejder videre med data.
                    //Laver carports mål om til double
                    double dHeight = Double.parseDouble(height);
                    double dLength = Double.parseDouble(length);
                    double dWidth = Double.parseDouble(width);

                    if(cm.checkEmailExists(email) == false) {

                        cm.setCustomer(firstName, lastName, address, email, phone);
                        
                        customerId = cm.getCustomerId(email).getCid();

                        om.setOrder(customerId, dHeight, dLength, dWidth);

                        request.getRequestDispatcher("adminPage.html").forward(request, response);

                    } else {

                        customerId = cm.getCustomerId(email).getCid();

                        om.setOrder(customerId, dHeight, dLength, dWidth);

                        request.getRequestDispatcher("adminPage.html").forward(request, response);


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
