/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Likitha
 */
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "Order_Details.findByName", query = "select c from Order_Details c where c.order_price = :order_price"),
    @NamedQuery(name = "Order_Details.findById", query = "select c from Order_Details c where c.Ordered = :Ordered"),
    @NamedQuery(name = "Order_Details.findAll", query = "select c from Order_Details c")})

@Table(name = "Order_Details")
public class Order_Details extends BaseEntity implements Serializable {

    @Id
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @OneToOne()
    private Ordered Ordered;
    
    private String order_price;
    private String order_quantity;
    
    public Order_Details() {
    }

    public Order_Details(Ordered Ordered, String order_price, String order_quantity) {
        this.Ordered = Ordered;
        this.order_price = order_price;
        this.order_quantity = order_quantity;
    }

    /**
     * Get the value of Order
     *
     * @return the value of Order
     */
    public Ordered getOrder() {
        return Ordered;
    }

    /**
     * Set the value of Order
     *
     * @param Order1 new value of Order
     */
    public void setOrder(Ordered Order1) {
        this.Ordered = Order1;
    }

    

    /**
     * Get the value of order_quantity
     *
     * @return the value of order_quantity
     */
    public String getOrder_quantity() {
        return order_quantity;
    }

    /**
     * Set the value of order_quantity
     *
     * @param order_quantity new value of order_quantity
     */
    public void setOrder_quantity(String order_quantity) {
        this.order_quantity = order_quantity;
    }

    /**
     * Get the value of order_price
     *
     * @return the value of order_price
     */
    public String getOrder_price() {
        return order_price;
    }

    /**
     * Set the value of order_price
     *
     * @param order_price new value of order_price
     */
    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

}
