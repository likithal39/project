/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Product.findByName", query = "select c from Product c where c.prod_name = :prod_name"),
    @NamedQuery(name = "Product.findById", query = "select c from Product c where c.prod_id = :prod_id"),
    @NamedQuery(name = "Product.findAll", query = "select c from Product c")})

@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", nullable = false, length = 25)
    private int prod_id;
    @Column(name = "PRODUCT_NAME", nullable = false, length = 25)

    private String prod_name;

    public Product(String prod_name) {
        this.prod_name = prod_name;
    }
    @Column(name = "PRODUCT_PRICE")
    private String prod_price;

    @OneToMany
    private List<Manufacturer> manufacturers = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<Category> categories = new ArrayList<>();

    public Product(int prod_id) {
        this.prod_id = prod_id;
    }

    public Product(String prod_name, String prod_price) {
        this.prod_name = prod_name;
        this.prod_price = prod_price;
    }

    
    public Product(int prod_id, String prod_name, String prod_price) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_price = prod_price;

    }

    /**
     * Get the value of prod_name
     *
     * @return the value of prod_name
     */
    public String getProd_name() {
        return prod_name;
    }

    /**
     * Set the value of prod_name
     *
     * @param prod_name new value of prod_name
     */
    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    

    public Product() {
    }

    public Product(int prod_id, String prod_price) {
        this.prod_id = prod_id;
        this.prod_price = prod_price;

    }

    public void addCategory(Category c) {
        if (!categories.contains(c)) {
            categories.add(c);
        }
    }

    /**
     * Get the value of categories
     *
     * @return the value of categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Set the value of categories
     *
     * @param categories new value of categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * Get the value of manufacturers
     *
     * @return the value of manufacturers
     */
    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    /**
     * Set the value of manufacturers
     *
     * @param manufacturers new value of manufacturers
     */
    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    /**
     * Get the value of prod_price
     *
     * @return the value of prod_price
     */
    public String getProd_price() {
        return prod_price;
    }

    /**
     * Set the value of prod_price
     *
     * @param prod_price new value of prod_price
     */
    public void setProd_price(String prod_price) {
        this.prod_price = prod_price;
    }

    /**
     * Get the value of prod_id
     *
     * @return the value of prod_id
     */
    public int getProd_id() {
        return prod_id;
    }

    /**
     * Set the value of prod_id
     *
     * @param prod_id new value of prod_id
     */
    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

}
