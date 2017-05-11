/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.entity;

/**
 *
 * @author Oliver
 * This class creates a Customer object with attributes which can be stored in the database.
 */
public class Customer {
    
    /**
     * This is the Customer ID which is auto-generated in the database.
     */
    private int cid;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    
    /**
     * This is an empty Customer constructor.
     */
    public Customer() {
        
    }
    
    /**
     * This is a Customer constructor containing all the parameters.
     * @param cid
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     * @param phone 
     */
    public Customer(int cid, String firstName, String lastName, String address, String email, String phone) {
        this.cid = cid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public int getCid() {
        return cid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "cid=" + cid + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email=" + email + ", phone=" + phone + '}';
    }

}