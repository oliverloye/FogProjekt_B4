/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Interfaces.IcustomerMapper;
import data.Interfaces.IorderMapper;
import domain.entity.Customer;
import domain.entity.Order;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oliver
 */
public class DataAccessFacade implements IcustomerMapper, IorderMapper {
    
    CustomerMapper cm = new CustomerMapper();
    OrderMapper om = new OrderMapper();

    @Override
    public boolean checkEmailExists(String email) {
        return cm.checkEmailExists(email);
    }

    @Override
    public Customer getCustomer(int id) {
        return cm.getCustomer(id);
    }

    @Override
    public Customer getCustomerId(String mail) {
        return cm.getCustomerId(mail);
    }

    @Override
    public void setCustomer(String firstName, String lastName, String address, String email, String phone) throws SQLException {
        cm.setCustomer(firstName, lastName, address, email, phone);
    }

    @Override
    public void updateCustomer(int cid, String firstName, String lastName, String address, String email, String phone) throws SQLException {
        cm.updateCustomer(cid, firstName, lastName, address, email, phone);
    }

    @Override
    public void deleteOrder(int id) {
        om.deleteOrder(id);
    }

    @Override
    public Order getOrder(int id) {
        return om.getOrder(id);
    }

    @Override
    public ArrayList<Order> getOrders() {
        return om.getOrders();
    }

    @Override
    public void setOrder(int customerId, double height, double length, double width) throws SQLException {
        om.setOrder(customerId, height, length, width);
    }

    @Override
    public void updateOrder(int oid, double height, double length, double width) throws SQLException {
        om.updateOrder(oid, height, length, width);
    }
    
}
