package com.person.exception;

public class PersonNotSupportException extends Exception{

	private static final long serialVersionUID = 1L;

	public PersonNotSupportException()
	{
		super();
	}
	
	public PersonNotSupportException(String message)
	{
		super(message);
	}
	
	public PersonNotSupportException(Throwable causes)
	{
		super(causes);
	}
	
	public PersonNotSupportException(String input, Throwable others)
	{
		super(input, others);
	}
}
