/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llokesh.mp4.service;

import edu.iit.sat.itmd4515.llokesh.mp4.domain.Category;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.Customer;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.Manufacturer;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.Product;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.security.Group;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.security.User;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Likitha
 */
@Singleton
@Startup

public class DatabasePopulator {
    @EJB
    private ProductService productService;

    @EJB
    private UserService userService;

    @EJB
    private GroupService groupService;

    @EJB
    private CustomerService customerService;
    
    @EJB
    private ManufacturerService manufacturerService;
    @EJB
    private CategoryService categoryService;
    
    public DatabasePopulator() {
    }

    @PostConstruct
    private void seedDatabase() {
//groups
        Group customer = new Group("Customer", "Customers Group");
        Group manufacturer = new Group("Manufacturer", "Manufacturers Group");
//users
        User liki = new User("liki", "abc123","yes");
        User jee = new User("jee", "abc123","yes");
       User fan = new User("fan", "abc123","yes");
       //adding users to group manufacturer
        liki.addGroup(manufacturer);
        jee.addGroup(manufacturer);
        //adding users to group customer
        fan.addGroup(customer);
        //product entries
                Product wiit = new Product("WIIT","40.60");
        Product wnur = new Product("WNUR","70.40");
        Product wbez = new Product("WBRZ","600");
        Product kcrw = new Product("KCRW","1000");
        
         Category javaEEShow = new Category("Leather products");
        Category jazzShow = new Category("Accessories");
        javaEEShow.setProduct(wiit);
        wiit.getCategories().add(javaEEShow);
        jazzShow.setProduct(wnur);
        wnur.getCategories().add(jazzShow);
        
        
//customer entries
        Customer l1 = new Customer("likitha","liki@gmail.com","Chicago");
        l1.setUser(fan);
//manufacturer entries
        Manufacturer man1 = new Manufacturer("Meghana","Gucci");
        man1.setUser(liki);
        man1.setProduct(wiit);
        wiit.getManufacturers().add(man1);
         man1.getCategories().add(javaEEShow);
        javaEEShow.getManufacturers().add(man1);
        
        Manufacturer man2 = new Manufacturer("Disha","Prada");
        man2.setUser(jee);
        man2.setProduct(wnur);
        wnur.getManufacturers().add(man2);
// add jee to javaEE show, and javaEEShow to jee
       
        man2.getCategories().add(javaEEShow);
      
        javaEEShow.getManufacturers().add(man2);
        // add jee to jazzShow, and jazzShow to jee
      
        man2.getCategories().add(jazzShow);
      
        jazzShow.getManufacturers().add(man2);
        

        groupService.create(manufacturer);
        groupService.create(customer);
        
        productService.create(wiit);
        productService.create(wnur);
        productService.create(wbez);
        productService.create(kcrw);
        
        categoryService.create(jazzShow);
        categoryService.create(javaEEShow);
        
        userService.create(liki);
        userService.create(jee);
        userService.create(fan);
        
        customerService.create(l1);
        manufacturerService.create(man1);
        manufacturerService.create(man2);
        
    }
        }
  

