package com.person.data;

import java.util.LinkedList;
import java.util.List;

import com.person.entity.Address;
import com.person.entity.Gender;
import com.person.entity.Nationality;
import com.person.entity.Person;

public class PersonDaoData {

	public List<Person> getPersonWithAddressAndNationality()
	{
		List<Person> allPersons = new LinkedList<Person>();
		
		allPersons.add(new Person(1, "Elina Laitinen", "elnia.laitinen@gmail.com", Gender.Female, 
				new Address("Björksundsslingan 139", "124 34", "Bandhagen", "Stockholm"), "Norse", 
				new Nationality("Stockholm", "Helsinki", false)));
		
		allPersons.add(new Person(2, "Amos Camara", "amos.camara@gmail.com", Gender.Male, 
				new Address("Trollesundsvägen 95", "131 24", "Bandhagen", "Stockholm"), "Doctor", 
				new Nationality("Stockholm", "Stockholm", false)));
		
		allPersons.add(new Person(3, "Stig Andersson", "stig.andersson@gmail.com", Gender.Male, 
				new Address("Ringsvägen 19", "121 25", "Stockholm", "Stockholm"), "System Developer", 
				new Nationality("Stockholm", "Norge", true)));
		
		List<Person> resultPersons = new LinkedList<Person>();		
		for (Person person : allPersons) 
		{
			resultPersons.add(person);
		};		 
		return resultPersons;
	}
}
