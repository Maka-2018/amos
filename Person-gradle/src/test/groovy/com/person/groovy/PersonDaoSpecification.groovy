package com.person.groovy

import com.person.dao.PersonDao
import com.person.dao.PersonService
import com.person.entity.Address
import com.person.entity.Gender
import com.person.entity.Nationality
import com.person.entity.Person
import com.person.exception.PersonNotSupportException
import com.person.impl.PersonDaoImpl
import groovy.util.logging.Slf4j
import spock.lang.Specification

@Slf4j
class PersonDaoSpecification extends Specification{

	private PersonDao pPersonDao
	private PersonService pPersonService
	
	def setupSpec(){
		log.debug("SetupSpec - Runs once each Specification")
	}	
	def setup(){
		log.debug("Setup - Runs before every Method")
		pPersonDao = new PersonDaoImpl();
		pPersonService = Stub(PersonService);
		pPersonDao.setPersonService(pPersonService)
		
		// Get/return a Person 
		pPersonService.getPersonName(_) >> { Integer id ->			
			if (id == 1){
				Person perso1 = new Person(1, "Elina Laitinen", "elnia.laitinen@gmail.com", Gender.Female,
					new Address("Björksundsslingan 139", "124 34", "Bandhagen", "Stockholm"), "Norse",
					new Nationality("Stockholm", "Helsinki", false));				
				log.debug(perso1.toString());
				return perso1;
			}
			else if (id == 2){
				Person perso2 = new Person(2, "Amos Camara", "amos.camara@gmail.com", Gender.Male,
					new Address("Trollesundsvägen 95", "131 24", "Bandhagen", "Stockholm"), "Doctor",
					new Nationality("Stockholm", "Stockholm", false));
				
				log.debug(perso2.toString());
				return perso2;
			}	
			else if (id == 20000){
				log.debug("Person not exist with this ID = 20000");
				return null;
			}
			else if (id <= 0){
				throw new PersonNotSupportException("Invalide Person ID");
			}
			
		}
		// Display Details of Person
		pPersonService.displayPersonData(_) >> { String details ->
			if (details != null){
				String str1 = new String(details);
				log.debug(str1);
				return str1;
			}
			else if (details == " "){
				log.debug("Details of Person should not empty");
				return null;
			}
			else if (details == null){
				throw new PersonNotSupportException("Details of Person should occur an error");
			}
		}
		
	}	
	// GetPersonName test
	def "Retrieved if PersonId is not null"(){
		log.debug("getPersonName - Retrieved if Person Id is not null - start")
		expect:
			pPersonDao.getPerson(id) != null		
		where:
			id << [1,2]
	}
	def "Retrieved if PersonId is null"(){
		log.debug("getPersonName - Retrieved if Person Id is null - start")
		given:
			def nullStringValue = null
		when:
			pPersonDao.getPerson(nullStringValue)
	    then:
			thrown(PersonNotSupportException)	
		where:
			id << 20000
	}
	def "Retrieved if PersonId is less than zero"(){
		log.debug("getPersonName - Retrieved if Person Id is less than zero - start")
		given:
		 	def expectId = -2
		when:
			pPersonDao.getPerson(expectId)		
		then:
			thrown(PersonNotSupportException)
	}		
	// DisplayPersonData test
	def "Retrieved if Details of Person is not null"(){
		log.debug("displayPersonData - Retrieved if Details of Person is not null - start")
		expect:
			pPersonDao.displayPersonData(details) != null
		where:
			details << ["Per Lindström", " "]
	}
	def "Retrieved if Details of Person is null"(){
		log.debug("displayPersonData - Retrieved if Details of Person is null - start")
		given:
			 // Undefined
		when:
			pPersonDao.displayPersonData(null)
		then:
			thrown(PersonNotSupportException)
	}
	def "Add if Person is not null"(){
		log.debug("addPerson - Add if Person is not null - start")
		given:
			def perso1 = new Person()	
			Gender gender = Gender.Female 
			String email = "elnia.laitinen@gmail.com"		
		when:
			perso1.getID() >> 1
			perso1.getName() >> "Elina Laitinen"
			perso1.getEmail() >> "elnia.laitinen@gmail.com"
			perso1.getGender() >> gender
			perso1.getAddress() >>	new Address("Björksundsslingan 139", "124 34", "Bandhagen", "Stockholm")
			perso1.getProfession() >> "Norse"
			perso1.getNationality() >>	new Nationality("Stockholm", "Helsinki", false)
			
			pPersonDao.savePerson(perso1) != null
		then:
			pPersonDao.savePerson(perso1) 
	}
	def "Add if Person is null"(){
		log.debug("addPerson - Add if Person is null - start")
		given:
			def perso = null
		when:
			pPersonDao.savePerson(perso)
		then:
			thrown(PersonNotSupportException)
			log.debug("addPerson - Add if Person is null - end")
	}	
	def "Retrieved if Person Id is not null"(){
		log.debug("getPersonName - Retrieved if Person Id is not null - start")
		expect:
			pPersonDao.getPerson(id) != null
		where:
			id << [1,2]
	}
	def "Retrieved if Person Id is null"(){
		log.debug("getPersonName - Retrieved if Person Id is null - start")
		given:
			def nullStringValue = null
		when:
			pPersonDao.getPerson(nullStringValue)
		then:
			thrown(PersonNotSupportException)
		where:
			id << 20000
	}
	// Clean up methods
	def cleanup(){
		log.debug ("Cleanup getPersonName - Runs after every getPersonName method.");
	}	
	def cleanupSpec(){
		log.debug ("cleanupSpec getPersonName - Runs only once specification.");
	}

}
