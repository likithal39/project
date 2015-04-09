/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.service;


import edu.iit.sat.itmd4515.llokesh.mp4.domain.Manufacturer;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author spyrisos
 */
@Stateless
public class ManufacturerService extends AbstractService<Manufacturer> {

    public ManufacturerService() {
        super(Manufacturer.class);
    }

    @Override
    public List<Manufacturer> findAll() {
        return getEntityManager().createNamedQuery("Manufacturer.findAll",Manufacturer.class).getResultList();
    }

    public Manufacturer findByUsername(String username) {
        return getEntityManager().createNamedQuery("Manufacturer.findByUsername",Manufacturer.class).setParameter("username", username).getSingleResult();
    }

}
