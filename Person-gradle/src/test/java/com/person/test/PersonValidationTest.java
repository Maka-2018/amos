package com.person.test;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import com.person.entity.Gender;
import com.person.entity.Person;
import com.person.entity.Address;
import com.person.entity.Nationality;
import com.person.impl.PersonValidation;
import com.person.exception.PersonNotSupportException;

public class PersonValidationTest {

	private PersonValidation pPersonValidation;

	@Before
	public void setup() throws Exception
	{			
		this.pPersonValidation = new PersonValidation();
	}
	
	@Test
	public void valideStringData() throws Exception
	{
		this.pPersonValidation.valideStringData(PersonData.STRING_VALUE);
	}
	
	@Test(expected=PersonNotSupportException.class)
	public void valideNullStringData() throws Exception
	{
		this.pPersonValidation.valideStringData(PersonData.NULL_STRING_VALUE);
	}
	
	@Test
	public void valideIntegerData() throws Exception
	{
		this.pPersonValidation.valideIntegerData(PersonData.INTEGER_VALUE);
	}
	
	@Test(expected=PersonNotSupportException.class)
	public void valideNullIntegerData() throws Exception
	{
		this.pPersonValidation.valideIntegerData(PersonData.NULL_INTEGER_VALUE);
	}
	
	@Test(expected=PersonNotSupportException.class)
	public void valideNegativIntegerData() throws Exception
	{
		this.pPersonValidation.valideIntegerData(PersonData.NEGATIV_INTEGER_VALUE);
	}
	
	@Test
	public void validePersonData() throws Exception
	{
		this.pPersonValidation.validePersonData(PersonData.PERSON_VALUE);
	}
	
	@Test(expected=PersonNotSupportException.class)
	public void valideNullPersonData() throws Exception
	{
		this.pPersonValidation.validePersonData(PersonData.NULL_PERSON_VALUE);
	}
	
	@After
	public void tearDown() throws Exception
	{
		pPersonValidation = null;
	}
	
	private static class PersonData
	{
		final static Integer INTEGER_VALUE = 10;
		final static String NULL_STRING_VALUE = null;
		final static Person NULL_PERSON_VALUE = null;
		final static Integer NULL_INTEGER_VALUE = null;
		final static String STRING_VALUE = "Any String";
		final static Integer NEGATIV_INTEGER_VALUE = -2;
		
		final static Person PERSON_VALUE = new Person(20, "Anders Nilsson", "anders.nilsson@gmail.com",
				Gender.Male, new Address("Häkkaringensvägen 9", "121 45", "Enskede", "Stockholm"), 
				"Administratör", new Nationality("Stockholm", "Dansk", true));
	}
}
