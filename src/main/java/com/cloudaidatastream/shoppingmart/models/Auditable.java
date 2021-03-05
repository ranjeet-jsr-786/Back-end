package com.cloudaidatastream.shoppingmart.models;



import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	@LastModifiedBy
	protected U updated_by; 
	@LastModifiedDate
	//@Temporal(TemporalType.TIMESTAMP)
	protected Timestamp update_date; 
    @CreatedBy
    protected U created_by; 	
    public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	@CreatedDate
    //@Temporal(TemporalType.TIMESTAMP)
    protected Timestamp create_date; 
    
    protected int  version; 
}
