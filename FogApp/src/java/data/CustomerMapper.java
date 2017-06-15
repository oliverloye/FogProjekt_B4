/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.Interfaces.IcustomerFacade;

/**
 *
 * @author Oliver
 * This is a CustomerMapper which contains all the methods that connects to the database.
 */
public class CustomerMapper implements IcustomerFacade {
    
    /**
     * This method has "Customer ID" as the input parameter and returns a Customer.
     * @param id
     * @return 
     */
    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE cid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int customerId = rs.getInt("cid");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                customer = new Customer(customerId, firstName, lastName, address, email, phone);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
    
    /**
     * This method has "email" as the input parameter and returns a Customer.
     * @param mail
     * @return 
     */
    @Override
    public Customer getCustomerId (String mail) {
        Customer customer = null;
        try {  
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `customer` WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int customerId = rs.getInt("cid");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                customer = new Customer(customerId, firstName, lastName, address, email, phone);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
    
    @Override
    public void setCustomer(String firstName, String lastName, String address, String email, String phone) throws SQLException {

        Connection conn = new DB().getConnection();
        try {
            String sql = "INSERT INTO `customer`(cid, firstName, lastName, address, email, phone) VALUES (null, ?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, address);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            
            pstmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    /**
     * This method updates a Customer in the database by its input parameters.
     * @param cid
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     * @param phone
     * @throws SQLException 
     */
    @Override
    public void updateCustomer(int cid, String firstName, String lastName, String address, String email, String phone) throws SQLException {
        
        Connection conn = new DB().getConnection();
        try {
            String sql = "UPDATE `customer` SET firstName = ?, lastName = ?, address = ?, email = ?, phone = ? WHERE cid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, address);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.setInt(6, cid);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method checks if a Customer already exists in the database by it's email.
     * @param email
     * @return 
     */
    @Override
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

    @Override
    public Customer validateCustomer(String mail) {
        try
        {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next())
            {
                int cid = rs.getInt("cid");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                return new Customer(cid, firstname, lastname, address, email, phone);
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public boolean isValidInput(String input) {
        if(input.isEmpty()) {
            return false;
        } return true;
    }
}