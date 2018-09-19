package com.person.dao;

import java.util.List;

import com.person.entity.Person;
import com.person.exception.PersonNotSupportException;

public interface PersonService {

	public List<Person> createListPersons() throws PersonNotSupportException;
	public Person getPersonName(Integer PersonId) throws PersonNotSupportException;
	public void addPerson(Person addPerson) throws PersonNotSupportException;
	public void updatePerson(Person updatePerson) throws PersonNotSupportException;
	public void deletePerson(Person deletePerson) throws PersonNotSupportException;
	public String displayPersonData(String details) throws PersonNotSupportException;
}
