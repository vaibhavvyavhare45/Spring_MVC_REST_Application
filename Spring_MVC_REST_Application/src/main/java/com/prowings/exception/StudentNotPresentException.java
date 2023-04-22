package com.prowings.exception;

public class StudentNotPresentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	String msg;

	public StudentNotPresentException(String msg) {
		super(msg);
	}
}
