/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Interfaces;

import business.entity.Order;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oliver
 */
public interface IorderFacade {

    void deleteOrder(int id);

    Order getOrder(int id);

    ArrayList<Order> getOrders();
    
    ArrayList<Order> getOrders(int id);

    void setOrder(int customerId, double height, double length, double width, double totalPrice) throws SQLException;

    void updateOrder(int oid, double height, double length, double width) throws SQLException;
    
    Order getCustomerOrders(int cid);
    
}
