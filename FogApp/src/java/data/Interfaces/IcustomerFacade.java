/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Interfaces;

import business.entity.Customer;
import java.sql.SQLException;

/**
 *
 * @author Oliver
 */
public interface IcustomerFacade {

    boolean checkEmailExists(String email);

    Customer getCustomer(int id);

    Customer getCustomerId(String mail);

    void setCustomer(String firstName, String lastName, String address, String email, String phone) throws SQLException;

    void updateCustomer(int cid, String firstName, String lastName, String address, String email, String phone) throws SQLException;
    
}
