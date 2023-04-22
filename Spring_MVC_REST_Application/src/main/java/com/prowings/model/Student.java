package com.prowings.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String branch;
	
	@OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	@JsonManagedReference
	private Address address;
	public Student() {
		super();
	}
	public Student(int id, String name, String branch, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", address=" + address + "]";
	}
	
	
	
	
}
