/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.domain;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Likitha
 */
@MappedSuperclass
public class BaseEntity {

    
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastUpdated;

    public BaseEntity() {
    }

    /**
     * Set the value of LastUpdated
     *
     */
    @PreUpdate
    @PrePersist
    public void setLastUpdated() {
        LastUpdated = GregorianCalendar.getInstance().getTime();
    }

    /**
     * Get the value of LastUpdated
     *
     * @return the value of LastUpdated
     */
    public Date getLastUpdated() {
        return LastUpdated;
    }

    @Override
    public String toString() {
        return "BaseEntity{" + "LastUpdated=" + LastUpdated + '}';
    }

}
