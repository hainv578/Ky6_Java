package com.poly.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Categories")
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String id;
	String name;
	@JsonIgnore
	@OneToMany(mappedBy = "category" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Collection<Product> products = new LinkedHashSet<Product>();
//	@OneToMany(mappedBy = "category")
//	List<Product> products;
}