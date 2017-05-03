/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Oliver
 */
public class Material {
    
    private int mid;
    private String name;
    private double price;
    private int stock;
    
    public Material() {
        
    }

    public Material(int mid, String name, double price, int stock) {
        this.mid = mid;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getMid() {
        return mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Material{" + "mid=" + mid + ", name=" + name + ", price=" + price + ", stock=" + stock + '}';
    }
    
    
    
    
}
