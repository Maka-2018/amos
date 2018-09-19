package com.person.groovy

import com.person.dao.PersonDao
import com.person.dao.PersonService
import com.person.entity.Address
import com.person.entity.Gender
import com.person.entity.Nationality
import com.person.entity.Person
import com.person.exception.PersonNotSupportException
import com.person.impl.PersonDaoImpl
import com.person.impl.PersonServiceImpl
import groovy.util.logging.Slf4j
import spock.lang.Specification

@Slf4j
class PersonServiceSpecification extends Specification{

	private PersonDao pPersonDao
	private PersonService pPersonService
	
	def setupSpec(){
		log.debug("SetupSpec - Runs once each Specification")
	}	
	def setup(){
		log.debug("Setup - Runs before every Method")
		pPersonService = new PersonServiceImpl();
		pPersonDao = Stub(PersonDao);
		pPersonService.setPersonDao(pPersonDao)
		
		// Get/return a Person 
		pPersonDao.getPerson(_) >> { Integer id ->			
			if (id == 1){
				Person person1 = new Person(1, "Elina Laitinen", "elnia.laitinen@gmail.com", Gender.Female,
					new Address("Björksundsslingan 139", "124 34", "Bandhagen", "Stockholm"), "Norse",
					new Nationality("Stockholm", "Helsinki", false));				
				log.debug(person1.toString());
				return person1;
			}
			else if (id == 2){
				Person person2 = new Person(2, "Amos Camara", "amos.camara@gmail.com", Gender.Male,
					new Address("Trollesundsvägen 95", "131 24", "Bandhagen", "Stockholm"), "Doctor",
					new Nationality("Stockholm", "Stockholm", false));
				
				log.debug(person2.toString());
				return person2;
			}	
			else if (id == 3){
				Person person3 = new Person(3, "Stig Andersson", "stig.andersson@gmail.com", Gender.Male,
					new Address("Ringsvägen 19", "121 25", "Stockholm", "Stockholm"), "System Developer",
					new Nationality("Stockholm", "Norge", true));				
				log.debug(person3.toString());
				return person3;
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
		pPersonDao.displayPersonData(_) >> { String details ->
			if (details != null){
				String str1 = new String("Elina Laitinen");
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
	def "Retrieved if Person Id is not null"(){
		log.debug("getPersonName - Retrieved if Person obejct is not null - start")
		expect:
			pPersonService.getPersonName(id) != null		
		where:
			id << [1,2,3]
	}
	def "Retrieved if Person Id is null"(){
		log.debug("getPersonName - Retrieved if Person obejct is null - start")
		expect:
			pPersonService.getPersonName(id) == null		
		where:
			id << 20000
	}
	def "Retrieved if Person Id is less than zero"(){
		log.debug("getPersonName - Retrieved if Person object is less than zero - start")
		given:
		 	// Undefined
		when:
			pPersonService.getPersonName(-2)		
		then:
			thrown(PersonNotSupportException)
	}	
	// DisplayPersonData test
	def "Retrieved if Details of Person is not null"(){
		log.debug("displayPersonData - Retrieved if Details of Person is not null - start")
		expect:
			pPersonService.displayPersonData(details) != null
		where:
			details << ["Elina Laitinen", " "]
	}
	def "Retrieved if Details of Person is null"(){
		log.debug("displayPersonData - Retrieved if Details of Person is null - start")
		given:
			 // Undefined
		when:
			pPersonService.displayPersonData(null)
		then:
			thrown(PersonNotSupportException)
	}
	// Clean up methods
	def cleanup(){
		log.debug ("Cleanup getPersonName - Runs after every getPersonName method.");
	}	
	def cleanupSpec(){
		log.debug ("cleanupSpec getPersonName - Runs only once specification.");
	}
}
