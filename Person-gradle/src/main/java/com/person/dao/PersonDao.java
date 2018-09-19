package com.person.dao;

import java.util.List;

import com.person.entity.Person;
import com.person.exception.PersonNotSupportException;

public interface PersonDao {

	public List<Person> createCollectionPersons() throws PersonNotSupportException;
	public Person getPerson(Integer Id) throws PersonNotSupportException;
	public void savePerson(Person savePerson) throws PersonNotSupportException;
	public void changePerson(Person changePerson) throws PersonNotSupportException;
	public void removePerson(Person removePerson) throws PersonNotSupportException;
	public String displayPersonData(String details) throws PersonNotSupportException;
	
}
