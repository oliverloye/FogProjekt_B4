/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.Calculator;
import data.DataAccessFacade;
import data.Interfaces.ImaterialFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oliver
 */
@WebServlet(name = "CalculateAdminController", urlPatterns = {"/CalculateAdminController"})
public class CalculateAdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ImaterialFacade mm = new DataAccessFacade();
        
        Calculator cal = new Calculator();
        
        response.setContentType("text/html;charset=UTF-8");
        
        //Henter data fra newOrder.jsp
        //Customer data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        

        //Dimensioner divideres med 100 da kundens input er i cm og prisen
        //for træet er kr/meter.
        double h = Double.parseDouble(request.getParameter("height")) / 100;
        double l = Double.parseDouble(request.getParameter("length")) / 100;
        double w = Double.parseDouble(request.getParameter("width")) / 100;
        
        //Udregning af pris for carport
        double testTotal = cal.totalPrice(h, l, w);
        
        String stringTotal = String.valueOf(testTotal);
        String height = request.getParameter("height");
        String length = request.getParameter("length");
        String width = request.getParameter("width");

        //Sender Customer videre
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("address", address);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        //Sender Order videre
        request.setAttribute("height", height);
        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("stringTotal", stringTotal);

        request.getRequestDispatcher("OrderAdminController").forward(request, response);

        
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
    }// </editor-fold>

}
