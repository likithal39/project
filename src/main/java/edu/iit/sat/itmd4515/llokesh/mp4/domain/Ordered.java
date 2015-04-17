/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Likitha
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Ordered.findById", query = "select c from Ordered c where c.order_id = :order_id"),
    @NamedQuery(name = "Ordered.findAll", query = "select c from Ordered c")})
@Table(name = "Ordered")
public class Ordered implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    @Column(name = "ORDER_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date order_date;

    private String status;

    @ManyToOne()
    //@JoinColumn(name = "cust_id")
    private Customer Customer;

    /**
     * Get the value of Customer
     *
     * @return the value of Customer
     */
    public Customer getCustomer() {
        return Customer;
    }

    /**
     * Set the value of Customer
     *
     * @param Customer new value of Customer
     */
    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    /**
     * Get the value of status
     *
     */
    public Ordered() {
    }

    public Ordered(int order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the value of order_date
     *
     * @return the value of order_date
     */
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * Set the value of order_date
     *
     * @param order_date new value of order_date
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    /**
     * Get the value of order_id
     *
     * @return the value of order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * Set the value of order_id
     *
     * @param order_id new value of order_id
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

}
