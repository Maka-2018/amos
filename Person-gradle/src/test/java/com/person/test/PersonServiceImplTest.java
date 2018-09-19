package com.person.test;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.person.dao.PersonDao;
import com.person.entity.Address;
import com.person.entity.Gender;
import com.person.entity.Nationality;
import com.person.entity.Person;
import com.person.impl.PersonServiceImpl;


public class PersonServiceImplTest {

	private PersonDao personDao;
	private PersonServiceImpl personServiceImpl;
	
	@Before
	public void setup() throws Exception
	{
		personDao = Mockito.mock(PersonDao.class);
		personServiceImpl = Mockito.mock(PersonServiceImpl.class);
		personServiceImpl.setPersonDao(personDao);
	}
	
	@Test
	public void createCollectionPersons() throws Exception
	{
		List<Person> expectedPerson = new LinkedList<Person>();				
		Mockito.when(personServiceImpl.createListPersons()).thenReturn(expectedPerson);
		final List<Person> resultPerson = personServiceImpl.createListPersons();	
		assertEquals(expectedPerson.size(), resultPerson.size());
	}
	
	@Test
	public void savePerson() throws Exception
	{
		final Person expectedPerson = new Person(1000, "Anders Nilsson", "anders.nilsson@gmail.com", Gender.Male, 
				new Address("Häkkaringensvägen 9", "121 45", "Enskede", "Stockholm"), "Administratör", 
				new Nationality("Stockholm", "Dansk", true));
		
		Mockito.doNothing().when(personServiceImpl).addPerson(expectedPerson);
        this.personServiceImpl.addPerson(expectedPerson);
        Mockito.verify(personServiceImpl).addPerson(expectedPerson);
	}
	
	@Test
	public void changePerson() throws Exception
	{
		final Person updatePerson = new Person(1000, "Anders Nilsson", "anders.nilsson@gmail.com", Gender.Male, 
				new Address("Häkkaringensvägen 9", "121 45", "Enskede", "Stockholm"), "Administratör", new Nationality("Stockholm", "Dansk", true));
		updatePerson.setID(500000);
		Mockito.doNothing().when(personServiceImpl).updatePerson(updatePerson);
        this.personServiceImpl.updatePerson(updatePerson);
        Mockito.verify(personServiceImpl).updatePerson(updatePerson);
	}
	
	@Test
	public void removePerson() throws Exception
	{
		final Person removePerson = new Person(1000, "Anders Nilsson", "anders.nilsson@gmail.com", Gender.Male, 
				new Address("Häkkaringensvägen 9", "121 45", "Enskede", "Stockholm"), "Administratör", 
				new Nationality("Stockholm", "Dansk", true));
		Mockito.doNothing().when(personServiceImpl).deletePerson(removePerson);
        this.personServiceImpl.deletePerson(removePerson);
        Mockito.verify(personServiceImpl).deletePerson(removePerson);
	}
	
	@Test
	public void displayPersonData() throws Exception
	{
		final String expectedString = new String("Anders Nilsson");		
		Mockito.when(personServiceImpl.displayPersonData(Matchers.anyString())).thenReturn(expectedString);
		final String resultString = personServiceImpl.displayPersonData(expectedString);
		Mockito.verify(personServiceImpl).displayPersonData(Matchers.anyString());		
		assertEquals("ANDERS NILSSON", resultString.toUpperCase());
		
	}
	
	@Test
	public void getPerson() throws Exception
	{
		final Address Address = null; final Nationality Nationality = null;
		final Person expectedPerso = new Person(10, "Anders Nilsson", "anders.nilsson@gmail.com", Gender.Unknown, 
				Address, "Administratör", Nationality);		
		Mockito.when(personServiceImpl.getPersonName(Matchers.anyInt())).thenReturn(expectedPerso);
		final Person resultPerso = personServiceImpl.getPersonName(expectedPerso.getID());
		Mockito.verify(personServiceImpl).getPersonName(Matchers.anyInt());		
		assertEquals(expectedPerso.getEmail(), resultPerso.getEmail());
		
	}
	
	@After
	public void tearDown() throws Exception
	{
		personDao = null;
		personServiceImpl = null;
	}
	
}
