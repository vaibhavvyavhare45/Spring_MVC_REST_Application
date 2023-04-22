package com.prowings.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int cid;
	@Column
	private int pin;
	@Column
	private String city;
	@OneToOne(targetEntity = Student.class, mappedBy = "address")
	@JsonBackReference
	private Student student;

	public Address() {
		super();
	}

	public Address(int cid, int pin, String city, Student student) {
		super();
		this.cid = cid;
		this.pin = pin;
		this.city = city;
		this.student = student;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [cid=" + cid + ", pin=" + pin + ", city=" + city + ", student=" + student + "]";
	}

}
