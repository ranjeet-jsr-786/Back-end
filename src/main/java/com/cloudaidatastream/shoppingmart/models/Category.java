package com.cloudaidatastream.shoppingmart.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Entity
@Table(name="PRODUCT_CATEGORY")
@EntityListeners(AuditingEntityListener.class)
public class Category extends Auditable<String>  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long  id; 			
	private String  name;     
	private boolean  active;   
	private String  detail;    
	private String  other_info;
	private byte[]  image;     
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<Product>();
}
