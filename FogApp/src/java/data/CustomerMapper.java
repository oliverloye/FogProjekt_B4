/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oliver
 */
public class CustomerMapper {
    
    public Customer getCustomer(int id) {
        Customer customer = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE customerId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int customerId = rs.getInt("customerId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("balance");
                customer = new Customer(customerId, firstName, lastName, address, email, phone);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
    
    public void setCustomer(String firstName, String lastName, String address, String email, String phone) throws SQLException {

        Connection conn = new DB().getConnection();
        try {
            String sql = "INSERT INTO customer(customerId, firstName, lastName, address, email, phone) VALUES (null, ?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, address);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            
            if(checkEmailExists(email)) {
                
                return;
            } else {
                System.out.println("User dosen't exsist");
            pstmt.execute();
            }
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
    }
    
    public boolean checkEmailExists(String email) {
        
        boolean userExists = false;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            String emailCounter;
            if(rs.next()) {
                emailCounter = rs.getString("email");
                if(emailCounter.equals(email)) {
                    System.out.println("User already exists");
                    userExists = true;
                   
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return userExists;
    }
    
}
