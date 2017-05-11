/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data.Interfaces.IorderFacade;

/**
 *
 * @author Oliver
 */
public class OrderMapper implements IorderFacade {
    
    @Override
    public void deleteOrder(int id) {
        
        try {
            Connection conn = new DB().getConnection();
            String sql = "UPDATE `Order` SET Relevant = FALSE WHERE oid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
            pstmt.execute();
//            if(rs.next()) {
//                int orderId = rs.getInt("oid");
//            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public Order getOrder(int id) {
        
        Order order = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` WHERE oid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int orderId = rs.getInt("oid");
                int customerId = rs.getInt("cid");
                int status = rs.getInt("status");
                double height = rs.getDouble("height");
                double length = rs.getDouble("length");
                double width = rs.getDouble("width");
                order = new Order(orderId, customerId, status, height, length, width);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }
    
    @Override
    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        
        try {
            
            Connection conn = new DB().getConnection();
            
            String sql = "SELECT * FROM `Order` WHERE Relevant = TRUE";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int orderId = rs.getInt("oid");
                int customerId = rs.getInt("cid");
                int status = rs.getInt("status");
                double height = rs.getDouble("height");
                double length = rs.getDouble("length");
                double width = rs.getDouble("width");
                
                orders.add(new Order(orderId, customerId, status, height, length, width));
            }
            
            return orders;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return null;
        
    }
    

    @Override
        public void setOrder(int customerId, double height, double length, double width) throws SQLException {
        
        Connection conn = new DB().getConnection();
        try {
            String sql = "INSERT INTO `Order`(oid, cid, status, height, length, width) VALUES (null,?,null,?,?,?)";
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
    
    @Override
    public void updateOrder(int oid, double height, double length, double width) throws SQLException {
        
        Connection conn = new DB().getConnection();
        try {
            String sql = "UPDATE `Order` SET height = ?, length = ?, width = ? WHERE oid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, height);
            pstmt.setDouble(2, length);
            pstmt.setDouble(3, width);
            pstmt.setInt(4, oid);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }    
}
