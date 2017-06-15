/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Interfaces;

import business.entity.Customer;
import java.sql.SQLException;

//This is a github comment!

/**
 *This is an interface of the CustomerMapper which contains all the methods that connects to the database.
 * @author Oliver
 */
public interface IcustomerFacade {

    /**
     * This method checks if a Customer already exists in the database by it's email.
     * @param email
     * @return 
     * 
     */
    boolean checkEmailExists(String email);

    /**
     * This method has "Customer ID" as the input parameter and returns a Customer.
     * @param id
     * @return 
     */
    Customer getCustomer(int id);
    
    /**
     * This method has "email" as the input parameter and returns a Customer.
     * @param mail
     * @return 
     */
    Customer getCustomerId(String mail);

    /**
     * This method creates a new Customer with the following parameters:
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     * @param phone
     * @throws SQLException 
     */
    void setCustomer(String firstName, String lastName, String address, String email, String phone) throws SQLException;
    
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
    void updateCustomer(int cid, String firstName, String lastName, String address, String email, String phone) throws SQLException;
    
    /**
     * This methods checks if the email address is stored in the database and returns an object of a Customer.
     * @param username
     * @param password
     * @return 
     */
    public Customer validateCustomer(String mail);
    
    public boolean isValidInput(String input);
    
}
