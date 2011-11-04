package com.soebes.scms.bo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Basis für alle BO Klassen.
 *
 * @author Karl Heinz Marbaise
 *
 */
@MappedSuperclass
public abstract class BaseBO {
    private Long Id;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
