/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import edu.iit.sat.itmd4515.llokesh.mp4.domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Likitha
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findByName", query = "select c from Customer c where c.cust_name = :cust_name"),
    @NamedQuery(name = "Customer.findById", query = "select c from Customer c where c.cust_id = :cust_id"),
    @NamedQuery(name = "Customer.findAll", query = "select c from Customer c"),
    @NamedQuery(name = "Customer.findByUsername", query = "select l from Customer l where l.user.userName = :username")})
@Table(name = "Customer")
public class Customer implements Serializable {

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;
    private String cust_name;
    private String cust_email;
    private String cust_address;
    @OneToMany(mappedBy = "Customer")
    private List<Ordered> Ordereds = new ArrayList<>();

    public Customer() {
    }

    /**
     * Get the value of Ordereds
     *
     * @return the value of Ordereds
     */
    public List<Ordered> getOrdereds() {
        return Ordereds;
    }

    /**
     * Set the value of Ordereds
     *
     * @param Ordereds new value of Ordereds
     */
    public void setOrdereds(List<Ordered> Ordereds) {
        this.Ordereds = Ordereds;
    }

    public Customer(Long cust_id) {
        this.cust_id = cust_id;
    }

    public Customer(String cust_name, String cust_email, String cust_address) {
        this.cust_name = cust_name;
        this.cust_email = cust_email;
        this.cust_address = cust_address;
    }

    public Customer(User user, String cust_name, String cust_email, String cust_address) {
        this.user = user;
        this.cust_name = cust_name;
        this.cust_email = cust_email;
        this.cust_address = cust_address;
    }

    /**
     * Get the value of cust_address
     *
     * @return the value of cust_address
     */
    public String getCust_address() {
        return cust_address;
    }

    /**
     * Set the value of cust_address
     *
     * @param cust_address new value of cust_address
     */
    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    /**
     * Get the value of cust_email
     *
     * @return the value of cust_email
     */
    public String getCust_email() {
        return cust_email;
    }

    /**
     * Set the value of cust_email
     *
     * @param cust_email new value of cust_email
     */
    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    /**
     * Get the value of cust_name
     *
     * @return the value of cust_name
     */
    public String getCust_name() {
        return cust_name;
    }

    /**
     * Set the value of cust_name
     *
     * @param cust_name new value of cust_name
     */
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    /**
     * Get the value of cust_id
     *
     * @return the value of cust_id
     */
    public Long getCust_id() {
        return cust_id;
    }

    /**
     * Set the value of cust_id
     *
     * @param cust_id new value of cust_id
     */
    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

}
