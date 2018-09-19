package com.person.groovy

import spock.lang.Specification
import groovy.util.logging.Slf4j
import com.person.impl.PersonValidation
import com.person.entity.Address
import com.person.entity.Gender
import com.person.entity.Nationality
import com.person.entity.Person
import com.person.exception.PersonNotSupportException

@Slf4j
class PersonValidationSpecification extends Specification{

	def setupSpec(){
		log.debug("SetupSpec - Runs once each Specification")
	}
	def setup(){
		log.debug("Setup - Runs before every Method")		
	}
	
	def "Validate if String is not null"(){
		log.debug("valideStringData - Validate if String is not null - start")
		given:
			def String details = new String("Elina Laitinen")
			def personValidation = new PersonValidation()
		when:
			personValidation.valideStringData(details)
		then:
			log.debug("valideStringData - Validate if String is not null - end")
	}
	def "Validate if String is null"(){
		log.debug("valideStringData - Validate if String is null - start")
		given:
			 def personValidation = new PersonValidation()
		when:
			personValidation.valideStringData(null)
		then:
			thrown(PersonNotSupportException)
			log.debug("valideStringData - Validate if String is null - end")
	}		
	def "Validate if Integer is not null"(){
		log.debug("valideIntegerData - Validate if Integer is not null - start")
		given:
			def personValidation = new PersonValidation()
		when:
			personValidation.valideIntegerData(Integer.valueOf(10))
		then:
			log.debug("valideIntegerData - Validate if Integer is not null - end")
	}
	def "Validate if Integer is null"(){
		log.debug("valideIntegerData - Validate if Integer is null - start")
		given:
			 def personValidation = new PersonValidation()
		when:
			personValidation.valideIntegerData(null)
		then:
			thrown(PersonNotSupportException)
			log.debug("valideIntegerData - Validate if Integer is null - end")
	}
	
	def "Validate if Integer is less than zero"(){
		log.debug("valideIntegerData - Validate if Integer is less than zero - start")
		given:
			 def personValidation = new PersonValidation()
		when:
			personValidation.valideIntegerData(-5)
		then:
			thrown(PersonNotSupportException)
			log.debug("valideIntegerData - Validate if Integer less than zero - end")
	}	
	def "Validate if Person is not null"(){
		log.debug("valideIntegerData - Validate if Person is not null - start")
		given:
			 def personValidation = new PersonValidation()
			 
			 def person = new Person(10, "Anders Nilsson", "anders.nilsson@gmail.com", Gender.Male, 
				new Address("Häkkaringensvägen 9", "121 45", "Enskede", "Stockholm"), "Administratör", 
				new Nationality("Stockholm", "Dansk", true))
		when:
			personValidation.validePersonData(person)
		then:
			log.debug("valideIntegerData - Validate if Person is not null - end")
	}
	def "Validate if Person is null"(){
		log.debug("valideIntegerData - Validate if Person is null - start")
		given:
			 def personValidation = new PersonValidation()
		when:
			personValidation.validePersonData(null)
		then:
			thrown(PersonNotSupportException)
			log.debug("valideIntegerData - Validate if Person is null - end")
	}
		
	def cleanup(){
		log.debug ("Cleanup validation - Runs after every validate method.");
	}
	def cleanupSpec(){
		log.debug ("cleanupSpec validation - Runs only once specification.");
	}
	
}
