    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.entity.Customer;
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
public class CustomerMapperTest {
    
    public CustomerMapperTest() {
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
     * Test of getCustomer method, of class CustomerMapper.
     */
    @Test
    public void testGetCustomer1() {
        System.out.println("getCustomer");
        int id = 0;
        CustomerMapper instance = new CustomerMapper();
        Customer expResult = null;
        Customer result = instance.getCustomer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    /**
     * Test of getCustomer method, of class CustomerMapper.
     */
    @Test
    public void testGetCustomer2() {
        System.out.println("getCustomer");
        int id = -1;
        CustomerMapper instance = new CustomerMapper();
        Customer expResult = null;
        Customer result = instance.getCustomer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    /**
     * Test of getCustomer method, of class CustomerMapper.
     */
    @Test
    public void testGetCustomer3() {
        System.out.println("getCustomer");
        int id = 11;
        CustomerMapper instance = new CustomerMapper();
        String expResult = "<Customer{cid=11, firstName=Oliver, lastName=LÃ?Â¸ye, address=Ordrupvej, email=oliver@loye.dk, phone=11111111}>";
        Customer result = instance.getCustomer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkEmailExists method, of class CustomerMapper.
     */
    @Test
    public void testCheckEmailExists1() {
        System.out.println("checkEmailExists");
        String email = "oliver@loye.dk";
        CustomerMapper instance = new CustomerMapper();
        boolean expResult = true;
        boolean result = instance.checkEmailExists(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }  
    
    /**
     * Test of checkEmailExists method, of class CustomerMapper.
     */
    @Test
    public void testCheckEmailExists2() {
        System.out.println("checkEmailExists");
        String email = "test@test.test";
        CustomerMapper instance = new CustomerMapper();
        boolean expResult = false;
        boolean result = instance.checkEmailExists(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }  
}
