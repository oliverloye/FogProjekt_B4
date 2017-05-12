/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.DataAccessFacade;
import data.Interfaces.ImaterialFacade;

/**
 *
 * @author Oliver
 */
public class Calculator {
    
    ImaterialFacade mm = new DataAccessFacade();
    
    private double buckle;
    private double roofPrice;
    private double beamPrice;
    private double bucklePrice;
    private double nailPrice;
    
    private final double fee = 10000;
    
    public double numbersOfBuckles(double length) {
        return buckle = (length * 2) + 1;
    }

    public double roofPrice(double width, double length, int id) {
        return roofPrice = ((width * length) * mm.getMaterial(id).getPrice());
    }
    
    public double beamPrice(double height, double length, int id) {
        return beamPrice = ((height * 4) + (length * 2)) * mm.getMaterial(id).getPrice();
    }
    
    public double bucklePrice(double width, int id) {
        return bucklePrice = (buckle * width * mm.getMaterial(id).getPrice());
    }
    
    public double nailPrice(int id) {
        return nailPrice = ((buckle * 3) + 4) * mm.getMaterial(id).getPrice();
    }
    
    public double totalPrice(double height, double length, double width) {
        buckle = (length * 2) + 1;
        roofPrice = ((width * length) * mm.getMaterial(3).getPrice());
        beamPrice = ((height * 4) + (length * 2)) * mm.getMaterial(2).getPrice();
        bucklePrice = (buckle * width * mm.getMaterial(4).getPrice());
        nailPrice = ((buckle * 3) + 4) * mm.getMaterial(1).getPrice();
        
        double totalPrice = buckle + roofPrice + beamPrice + bucklePrice + nailPrice + fee;
        
        return totalPrice;
    }
    
}
