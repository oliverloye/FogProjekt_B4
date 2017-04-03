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
    
    private int orderId;
    private int customerId;
    private int height;
    private int length;
    private int width;
    private int status;
    
    
    public Order() {
        
    }

    public Order(int orderId, int customerId, int height, int length, int width, int status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.height = height;
        this.length = length;
        this.width = width;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", height=" + height + ", length=" + length + ", width=" + width + ", status=" + status + '}';
    }

}
