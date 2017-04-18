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
            
            String sql = "SELECT * FROM `Order`";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int orderId = rs.getInt("oid");
                int customerId = rs.getInt("cid");
                int status = rs.getInt("status");
                int productId = rs.getInt("pid");
                int materialId = rs.getInt("mid");
                double height = rs.getDouble("height");
                double length = rs.getDouble("length");
                double width = rs.getDouble("width");
                
                orders.add(new Order(orderId, customerId, status, productId, materialId, height, length, width));
            }
            
            return orders;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return null;
        
    }
    

    public void setOrder(int customerId, double height, double length, double width) throws SQLException {
        
        Connection conn = new DB().getConnection();
        try {
            String sql = "INSERT INTO `Order`(oid, cid, status, pid, mid, height, length, width) VALUES (null,?,null,null,null,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            
            pstmt.setInt(1, customerId);
            pstmt.setDouble(2, height);
            pstmt.setDouble(3, length);
            pstmt.setDouble(4, width);
            
            
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
