package com.soebes.scms.bo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;


/**
 * Basis für alle BO Klassen.
 *
 * @author Karl Heinz Marbaise
 *
 */
@MappedSuperclass
public abstract class BaseBO {
    private Long Id;

    @RevisionNumber
    private Long revisionNumber;
    
    @RevisionTimestamp
    private long timestamp;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(Long revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    
}
