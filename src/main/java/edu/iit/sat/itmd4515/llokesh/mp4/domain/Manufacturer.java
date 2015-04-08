/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.security.User;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Likitha
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Manufacturer.findByName", query = "select c from Manufacturer c where c.man_name = :man_name"),
    @NamedQuery(name = "Manufacturer.findById", query = "select c from Manufacturer c where c.man_id = :man_id"),
    @NamedQuery(name = "Manufacturer.findAll", query = "select c from Manufacturer c"),
    @NamedQuery(name = "Manufacturer.findByUsername", query = "select d from Manufacturer d where d.user.userName = :username")})
@Table(name = "Manufacturer")
public class Manufacturer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int man_id;

    private String man_name;

    private String man_title;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
@ManyToMany
    private List<Category> categories = new ArrayList<>();

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

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

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

    public Manufacturer(String man_name, String man_title) {
        this.man_name = man_name;
        this.man_title = man_title;
    }

    public Manufacturer(String man_name, String man_title, User user) {
        this.man_name = man_name;
        this.man_title = man_title;
        this.user = user;
    }

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

    public Manufacturer() {
    }

    public Manufacturer(int man_id) {
        this.man_id = man_id;
    }

    /**
     * Get the value of man_title
     *
     * @return the value of man_title
     */
    public String getMan_title() {
        return man_title;
    }

    /**
     * Set the value of man_title
     *
     * @param man_title new value of man_title
     */
    public void setMan_title(String man_title) {
        this.man_title = man_title;
    }

    /**
     * Get the value of man_name
     *
     * @return the value of man_name
     */
    public String getMan_name() {
        return man_name;
    }

    /**
     * Set the value of man_name
     *
     * @param man_name new value of man_name
     */
    public void setMan_name(String man_name) {
        this.man_name = man_name;
    }

    /**
     * Get the value of man_id
     *
     * @return the value of man_id
     */
    public int getMan_id() {
        return man_id;
    }

    /**
     * Set the value of man_id
     *
     * @param man_id new value of man_id
     */
    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

}
