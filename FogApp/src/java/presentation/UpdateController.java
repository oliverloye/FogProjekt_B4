/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataAccessFacade;
import business.entity.Customer;
import business.entity.Order;
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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                IcustomerFacade cm = new DataAccessFacade();
                IorderFacade om = new DataAccessFacade();
                int customerId;
                
                Order order = null;
                Customer customer = null;
            
                
                
                
                try {
                    response.setContentType("text/html; charset=UTF-8");

                    //Henter data fra editOrder.jsp
                    String oid = request.getParameter("thisOrder");
                    String cid = request.getParameter("thisCustomer");
                    
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
                    //Order ID og Customer ID
                    int iOid = Integer.parseInt(oid);
                    int iCid = Integer.parseInt(cid);
                    //Laver carports mål om til double
                    double dHeight = Double.parseDouble(height);
                    double dLength = Double.parseDouble(length);
                    double dWidth = Double.parseDouble(width);
                    
                    om.updateOrder(iOid, dHeight, dLength, dWidth);
                    cm.updateCustomer(iCid, firstName, lastName, address, email, phone);
                    request.getRequestDispatcher("orderList.jsp").forward(request, response);

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
