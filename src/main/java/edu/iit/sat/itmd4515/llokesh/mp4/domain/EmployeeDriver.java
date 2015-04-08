/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Likitha
 */
public class EmployeeDriver {

    private static final Logger LOG = Logger.getLogger(EmployeeDriver.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         Employee emp;
         emp = new Employee(
         1L,
         "Likitha",
         "Lokesh",
         new GregorianCalendar(1991, 11, 23).getTime());
         LOG.info("Before validation: " + emp.toString());
        
         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         Validator validator = factory.getValidator();

         Set<ConstraintViolation<Employee>> violations = validator.validate(emp);
        
         LOG.info("Violations isEmpty: " + violations.isEmpty());
         LOG.info("Violations size: " + violations.size());
        
         for (ConstraintViolation<Employee> violation : violations) {
         System.out.println("Class name: " + violation.getRootBeanClass().getSimpleName() +
         " Property name: " + violation.getPropertyPath() + " Invalid Value:" +
         violation.getInvalidValue() + " Message:" + violation.getMessage());

         }
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("llokeshPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        tx.commit();

    }
}
