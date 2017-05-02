/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Interfaces;

import domain.entity.Order;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oliver
 */
public interface IorderMapper {

    void deleteOrder(int id);

    Order getOrder(int id);

    ArrayList<Order> getOrders();

    void setOrder(int customerId, double height, double length, double width) throws SQLException;

    void updateOrder(int oid, double height, double length, double width) throws SQLException;
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
