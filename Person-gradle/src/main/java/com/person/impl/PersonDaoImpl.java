package com.person.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import com.person.entity.Person;
import com.person.dao.PersonDao;
import com.person.dao.PersonService;
import com.person.data.PersonDaoData;
import com.person.exception.PersonNotSupportException;


public class PersonDaoImpl implements PersonDao{

	private PersonDaoData data;
	private List<Person> allPersons;	
	private PersonService nPersonService;
	private PersonValidation valide = new PersonValidation();
	
	
	public PersonDaoImpl() 
	{
		this.data = new PersonDaoData();
		this.allPersons = new ArrayList<Person>();
		this.allPersons.addAll(this.data.getPersonWithAddressAndNationality());
	}
	
	@Override
	public List<Person> createCollectionPersons() throws PersonNotSupportException {
		LinkedList<Person> resultPerson = new LinkedList<>();	
		for (Person person : this.allPersons) 
		{
			valide.validePersonData(person);
			resultPerson.add(person);
		}
		return resultPerson;
	}

	@Override
	public Person getPerson(Integer Id) throws PersonNotSupportException {
		valide.valideIntegerData(Id);
		return this.allPersons.get(Id);
	}

	@Override
	public void savePerson(Person savePerson) throws PersonNotSupportException {
		this.save(savePerson);
		displayPersonData(savePerson.getID()+ " are added in database.");		
	}

	@Override
	public void changePerson(Person changePerson) throws PersonNotSupportException {
		valide.validePersonData(changePerson);
		this.allPersons.get(changePerson.getID()).setName(changePerson.getName());
		displayPersonData(changePerson.getID()+ " are updated in database.");		
	}

	@Override
	public void removePerson(Person removePerson) throws PersonNotSupportException {
		valide.validePersonData(removePerson);
		this.allPersons.remove(removePerson);
		displayPersonData(removePerson.getID()+ " are deleted from database.");		
	}

	@Override
	public String displayPersonData(String details) throws PersonNotSupportException {
		valide.valideStringData(details);
		return String.format("Person ID: ", details);
	}

	public void save(Person savePerson) throws PersonNotSupportException{
		valide.validePersonData(savePerson);
		this.allPersons.add(savePerson);
	}
	
	public void setPersonService(PersonService newPersonService){
		setnPersonService(newPersonService);
	}

	public PersonService getnPersonService() {
		return nPersonService;
	}

	public void setnPersonService(PersonService nPersonService) {
		this.nPersonService = nPersonService;
	}
}
