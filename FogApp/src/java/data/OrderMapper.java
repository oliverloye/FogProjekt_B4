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
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int customerId = rs.getInt("customerId");
                int status = rs.getInt("status");
                orders.add(new Order(orderId, height, length, width, customerId, status));
            }
            
            return orders;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
        
    }
}
