package com.person.impl;

import java.util.List;

import com.person.dao.PersonDao;
import com.person.dao.PersonService;
import com.person.entity.Person;
import com.person.exception.PersonNotSupportException;

public class PersonServiceImpl implements PersonService{

	private PersonDao dao;
	private PersonValidation valide = new PersonValidation();
	
	@Override
	public List<Person> createListPersons() throws PersonNotSupportException 
	{		
		return this.dao.createCollectionPersons();
	}

	@Override
	public Person getPersonName(Integer PersonId) throws PersonNotSupportException 
	{
		valide.valideIntegerData(PersonId);
		return this.dao.getPerson(PersonId);
	}

	@Override
	public void addPerson(Person addPerson) throws PersonNotSupportException 
	{
		valide.validePersonData(addPerson);
		this.dao.savePerson(addPerson);		
	}

	@Override
	public void updatePerson(Person updatePerson) throws PersonNotSupportException 
	{
		valide.validePersonData(updatePerson);
		this.dao.changePerson(updatePerson);	
	}

	@Override
	public void deletePerson(Person deletePerson) throws PersonNotSupportException 
	{
		valide.validePersonData(deletePerson);
		this.dao.removePerson(deletePerson);		
	}

	@Override
	public String displayPersonData(String details) throws PersonNotSupportException 
	{
		valide.valideStringData(details);
		return this.dao.displayPersonData(details);
	}

	public void setPersonDao(PersonDao personDao) {
		dao = personDao;
		
	}

}
