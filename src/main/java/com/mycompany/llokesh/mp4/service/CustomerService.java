/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llokesh.mp4.service;

import edu.iit.sat.itmd4515.llokesh.mp4.domain.Customer;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author spyrisos
 */
@Stateless
public class CustomerService {

    @PersistenceContext(unitName = "llokeshPU")
    private EntityManager em;

    public CustomerService() {
    }

    public void create(Customer l) {
        em.persist(l);
    }

    public void update(Customer l) {
        em.merge(l);
    }

    public void remove(Customer l) {
        em.remove(l);
    }

    public Customer find(long id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAll",
                Customer.class).getResultList();
    }

    public Customer findByUsername(String userName) {
        return em.createNamedQuery("Customer.findByUsername",
                Customer.class)
                .setParameter("username", userName)
                .getSingleResult();
    }

}
