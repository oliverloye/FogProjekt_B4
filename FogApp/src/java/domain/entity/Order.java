/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

/**
 *
 * @author Oliver
 */
public class Order {
    
    private int oid;
    private int cid;
    private int pid;
    private int mid;
    private int status;
    private double height;
    private double length;
    private double width;
    
    
    
    
    public Order() {
        
    }

    public Order(int oid, int cid, int pid, int mid, int status, double height, double length, double width) {
        this.oid = oid;
        this.cid = cid;
        this.status = status;
        this.pid = pid;
        this.mid = mid;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getOid() {
        return oid;
    }


    public int getCid() {
        return cid;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPid() {
        return pid;
    }


    public int getMid() {
        return mid;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Order{" + "Order ID=" + oid + ", Customer ID=" + cid + ", pid=" + pid + ", mid=" + mid + ", status=" + status + ", heigth=" + height + ", length=" + length + ", width=" + width + '}';
    }

    

    

}
