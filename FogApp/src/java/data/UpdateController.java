/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    
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
                    double dHeight = Double.parseDouble(height);
                    double dLength = Double.parseDouble(length);
                    double dWidth = Double.parseDouble(width);
                    
                    om.updateOrder(dHeight, dLength, dWidth);
                    cm.updateCustomer(firstName, lastName, address, email, phone);
                    
                    request.getRequestDispatcher("orderList.jsp").forward(request, response);

//                    if(cm.checkEmailExists(email) == false) {
//
//                        cm.setCustomer(firstName, lastName, address, email, phone);
//                        
//                        customerId = cm.getCustomerId(firstName, lastName, email).getCid();
//
//                        om.setOrder(customerId, dHeight, dLength, dWidth);
//
//                        request.getRequestDispatcher("index.html").forward(request, response);
//
//                    } else {
//
//                        customerId = cm.getCustomerId(firstName, lastName, email).getCid();
//
//                        om.setOrder(customerId, dHeight, dLength, dWidth);
//
//                        request.getRequestDispatcher("index.html").forward(request, response);
//
//
//                    } 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
