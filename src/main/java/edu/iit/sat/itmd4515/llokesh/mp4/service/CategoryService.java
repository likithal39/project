/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.service;


import edu.iit.sat.itmd4515.llokesh.mp4.domain.Category;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author likitha
 */
@Stateless
public class CategoryService extends AbstractService<Category> {

    public CategoryService() {
        super(Category.class);
    }

    @Override
    public List<Category> findAll() {
        return getEntityManager().createNamedQuery("Category.findAll").getResultList();
    }

}
