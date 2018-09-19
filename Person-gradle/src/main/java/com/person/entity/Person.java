package com.person.entity;

public class Person {

	private Integer ID;
	private String Name;
	private String Email;
	private Gender Gender;
	private Address Address;
	private String Profession;
	private Nationality Nationality;
	
	public Person()
	{}
	
	public Person(Integer newId, String newName, String newEmail, Gender newGender, 
			Address newAddres, String newProfession, Nationality newNationality){
		ID = newId; 
		Name = newName; 
		Email = newEmail; 
		setGender(newGender); 
		Address = newAddres; 
		Profession = newProfession; 
		Nationality = newNationality;
	}
	
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer Id) {
		ID = Id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public Gender getGender() {
		return Gender;
	}
	
	public void setGender(Gender gender) {
		Gender = gender;
	}
	
	public Address getAddress() {
		return Address;
	}
	
	public void setAddress(Address address) {
		Address = address;
	}
	
	public String getProfession() {
		return Profession;
	}
	
	public void setProfession(String profession) {
		Profession = profession;
	}
	
	public Nationality getNationality() {
		return Nationality;
	}
	
	public void setNationality(Nationality nationality) {
		Nationality = nationality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Nationality == null) ? 0 : Nationality.hashCode());
		result = prime * result + ((Profession == null) ? 0 : Profession.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Gender != other.Gender)
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Nationality == null) {
			if (other.Nationality != null)
				return false;
		} else if (!Nationality.equals(other.Nationality))
			return false;
		if (Profession == null) {
			if (other.Profession != null)
				return false;
		} else if (!Profession.equals(other.Profession))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person \n[ID: " + ID + ", Name: " + Name + ", Email: " + Email + ", Gender: " + Gender + ", Address:"
				+ Address + ", Profession: " + Profession + ", Nationality:" + Nationality + "]";
	}
	
}
