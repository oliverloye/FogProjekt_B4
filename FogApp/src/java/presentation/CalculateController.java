/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.MaterialMapper;
import data.DataAccessFacade;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.Interfaces.IorderFacade;

/**
 *
 * @author Oliver
 */
@WebServlet(name = "CalculateController", urlPatterns = {"/CalculateController"})
public class CalculateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        IorderFacade om = new DataAccessFacade();
        MaterialMapper mm = new MaterialMapper();

        
        response.setContentType("text/html;charset=UTF-8");


        double h = Double.parseDouble(request.getParameter("height")) / 100;
        double l = Double.parseDouble(request.getParameter("length")) / 100;
        double w = Double.parseDouble(request.getParameter("width")) / 100;

        double buckle = (l * 2) + 1;

        double roofPrice = ((w * l) * mm.getMaterial(3).getPrice());
        double beamPrice = ((h * 4) + (l * 2)) * mm.getMaterial(2).getPrice();
        double bucklePrice = (buckle * w * mm.getMaterial(4).getPrice());
        double nailPrice = ((buckle * 3) + 4) * mm.getMaterial(1).getPrice();
        
        double fee = 10000;

        double total = roofPrice + beamPrice + bucklePrice + nailPrice + fee;
        String stringTotal = String.valueOf(total);
        String height = request.getParameter("height");
        String length = request.getParameter("length");
        String width = request.getParameter("width");

        request.setAttribute("height", height);
        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("stringTotal", stringTotal);

        request.getRequestDispatcher("CustomerNewOrder2.jsp").forward(request, response);

        
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
