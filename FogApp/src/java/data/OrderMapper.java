/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oliver
 */
public class OrderMapper {
    
    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM order";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int orderId = rs.getInt("orderId");
                double height = rs.getDouble("height");
                double length = rs.getDouble("length");
                double width = rs.getDouble("width");
                int customerId = rs.getInt("customerId");
                int status = rs.getInt("status");
                orders.add(new Order(orderId, customerId, height, length, width, status));
            }
            
            return orders;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
        
    }
    
    public void setOrder(int orderId, double height, double length, double width, int customerId, int status) {
        
        Connection conn = new DB().getConnection();
        try {
            String sql = "INSERT INTO order(orderId, height, length, width, customerId, status) VALUES (null,?,?,?,null,null)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            
            pstmt.setDouble(1, height);
            pstmt.setDouble(2, length);
            pstmt.setDouble(3, width);
            
            pstmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
    }
    
//    public boolean checkOrderIdExists(int orderId) {
//        
//        boolean userExists = false;
//        try {
//            Connection conn = new DB().getConnection();
//            String sql = "SELECT * FROM order WHERE orderId = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, orderId);
//            ResultSet rs = pstmt.executeQuery();
//            int IdCounter;
//            if(rs.next()) {
//                IdCounter = rs.getInt("orderId");
//                if(IdCounter == orderId) {
//                    System.out.println("OrderId already exists");
//                    userExists = true;
//                   
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            
//        }
//        return userExists;
//    }
    
    
}
