package com.person.impl;

import com.person.entity.Person;
import com.person.exception.PersonNotSupportException;

public class PersonValidation 
{
	public void valideStringData(String details) throws PersonNotSupportException
	{
		if (details == null || details == "") 
		{
			throw new PersonNotSupportException("Person Name should not be null");
		}
	}
	
	public void valideIntegerData(Integer ID) throws PersonNotSupportException
	{
		if (ID == null || ID <= 0) 
		{
			throw new PersonNotSupportException("Person ID should not be null");
		}
	}
	
	public void validePersonData(Person PersonDetails) throws PersonNotSupportException
	{
		if (PersonDetails == null)  
		{
			throw new PersonNotSupportException("Details of Person should not be null");
		}
	}
}
