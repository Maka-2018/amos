package com.person.test;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Matchers;
import org.mockito.Mockito;
import com.person.dao.PersonService;
import com.person.entity.Address;
import com.person.entity.Gender;
import com.person.entity.Nationality;
import com.person.entity.Person;
import com.person.impl.PersonDaoImpl;

public class PersonDaoImplTest {

	private PersonDaoImpl personDaoImpl;
	private PersonService personDaoService;
	
	@Before
	public void setup() throws Exception
	{
		personDaoService = Mockito.mock(PersonService.class);
		personDaoImpl = Mockito.mock(PersonDaoImpl.class);
		personDaoImpl.setPersonService(personDaoService);
	}
	
	@Test
	public void createCollectionPersons() throws Exception
	{
		List<Person> expectedPerson = new LinkedList<Person>();
		
		expectedPerson.add(new Person(1000, "Anders Nilsson", "anders.nilsson@gmail.com", Gender.Male, 
				new Address("Häkkaringensvägen 9", "121 45", "Enskede", "Stockholm"), "Administratör", 
				new Nationality("Stockholm", "Dansk", true)));
		
		Mockito.when(personDaoImpl.createCollectionPersons()).thenReturn(expectedPerson);
		final List<Person> resultPerson = personDaoImpl.createCollectionPersons();
		
		assertEquals(1, resultPerson.size());
		assertEquals(Integer.valueOf(1000), resultPerson.get(0).getID());
	}
	
	@Test
	public void displayPersonData() throws Exception
	{
		final String expectedString = new String("Anders Nilsson");		
		Mockito.when(personDaoImpl.displayPersonData(Matchers.anyString())).thenReturn(expectedString);
		final String resultString = personDaoImpl.displayPersonData(expectedString);
		Mockito.verify(personDaoImpl).displayPersonData(Matchers.anyString());
		// Assert statement
		assertNotNull(resultString);
		assertEquals(expectedString, resultString);		
	}
	
	@Test
	public void getPerson() throws Exception
	{
		final Address Address = null; final Nationality Nationality = null;
		final Person expectedPerso = new Person(10, "Anders Nilsson", "anders.nilsson@gmail.com", 
				Gender.Unknown, Address, "Administratör", Nationality);		
		Mockito.when(personDaoImpl.getPerson(Matchers.anyInt())).thenReturn(expectedPerso);
		final Person resultPerso = personDaoImpl.getPerson(expectedPerso.getID());
		Mockito.verify(personDaoImpl).getPerson(Matchers.anyInt());		
		System.out.println("Print result: "+resultPerso);
		
	}
	
	@Test
	public void savePerson() throws Exception
	{
		final Person expectedPerson = PersonData.person;
		
		Mockito.doNothing().when(personDaoImpl).savePerson(expectedPerson);
        this.personDaoImpl.savePerson(expectedPerson);
        Mockito.verify(personDaoImpl).savePerson(expectedPerson);
	}
	
	@Test
	public void changePerson() throws Exception
	{
		final Person updatePerson = PersonData.person;
		if (updatePerson.getID() == 50) 
		{
			updatePerson.setName("Mamoudou Camara");
			Mockito.doNothing().when(personDaoImpl).changePerson(updatePerson);
	        this.personDaoImpl.changePerson(updatePerson);
	        Mockito.verify(personDaoImpl).changePerson(updatePerson);
		}
		System.out.println("Updated Person: "+updatePerson);		
	}
	
	@Test
	public void removePerson() throws Exception
	{
		final Person removePerson = PersonData.person;		
		Mockito.doNothing().when(personDaoImpl).removePerson(removePerson);
        this.personDaoImpl.removePerson(removePerson);
        Mockito.verify(personDaoImpl).removePerson(removePerson);
	}
	
	@After
	public void tearDown() throws Exception
	{
		personDaoImpl = null;
		personDaoService = null;
	}
	
	private static class PersonData
	{
		final static Person person = new Person(50, "Anders Nilsson", "anders.nilsson@gmail.com", Gender.Male, 
				new Address("Häkkaringensvägen 9", "121 45", "Enskede", "Stockholm"), "Administratör", 
				new Nationality("Stockholm", "Dansk", true));
		
	}
}
