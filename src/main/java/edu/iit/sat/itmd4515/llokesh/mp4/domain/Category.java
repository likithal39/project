/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Table;

/**
 *
 * @author Likitha
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Category.findByName", query = "select c from Category c where c.category_name = :category_name"),
    @NamedQuery(name = "Category.findById", query = "select c from Category c where c.category_id = :category_id"),
    @NamedQuery(name = "Category.findAll", query = "select c from Category c")})

@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID", nullable = false, length = 25)
    private int category_id;
    @Column(name = "CATEGORY_NAME", nullable = false, length = 25)
    private String category_name;
    @ManyToOne
    private Product product;
@ManyToMany
    private List<Manufacturer> manufacturers = new ArrayList<>();

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

    public Category(String category_name) {
        this.category_name = category_name;
    }

    public Category() {
    }

    public Category(int category_id) {
        this.category_id = category_id;
    }

    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Get the value of category_name
     *
     * @return the value of category_name
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     * Set the value of category_name
     *
     * @param category_name new value of category_name
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    /**
     * Get the value of category_id
     *
     * @return the value of category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * Set the value of category_id
     *
     * @param category_id new value of category_id
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

}
