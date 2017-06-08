/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.entity.Order;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oliver
 */
public class OrderMapperTest {
    
    public OrderMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deleteOrder method, of class OrderMapper.
     */
    @Test
    public void testDeleteOrder() {
        System.out.println("deleteOrder");
        int id = 0;
        OrderMapper instance = new OrderMapper();
        instance.deleteOrder(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class OrderMapper.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        int id = 0;
        OrderMapper instance = new OrderMapper();
        Order expResult = null;
        Order result = instance.getOrder(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrders method, of class OrderMapper.
     */
    @Test
    public void testGetOrders_0args() {
        System.out.println("getOrders");
        OrderMapper instance = new OrderMapper();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrders method, of class OrderMapper.
     */
    @Test
    public void testGetOrders_int() {
        System.out.println("getOrders");
        int id = 0;
        OrderMapper instance = new OrderMapper();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getOrders(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrder method, of class OrderMapper.
     */
    @Test
    public void testSetOrder() throws Exception {
        System.out.println("setOrder");
        int customerId = 0;
        double height = 0.0;
        double length = 0.0;
        double width = 0.0;
        double totalPrice = 0.0;
        OrderMapper instance = new OrderMapper();
        instance.setOrder(customerId, height, length, width, totalPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrder method, of class OrderMapper.
     */
    @Test
    public void testUpdateOrder() throws Exception {
        System.out.println("updateOrder");
        int oid = 0;
        double height = 0.0;
        double length = 0.0;
        double width = 0.0;
        OrderMapper instance = new OrderMapper();
        instance.updateOrder(oid, height, length, width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerOrders method, of class OrderMapper.
     */
    @Test
    public void testGetCustomerOrders() {
        System.out.println("getCustomerOrders");
        int cid = 0;
        OrderMapper instance = new OrderMapper();
        Order expResult = null;
        Order result = instance.getCustomerOrders(cid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
