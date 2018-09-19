package com.person.entity;

public class Nationality {

	private String Citizen;
	private String CountryName;
	private boolean isOrginalOfCountry;
	
	public Nationality()
	{}
	
	public Nationality(String newCitizen, String newCountry, boolean newIsOriginal)
	{
		Citizen = newCitizen; 
		CountryName = newCountry; 
		isOrginalOfCountry = newIsOriginal;
	}

	public String getCitizen() {
		return Citizen;
	}

	public void setCitizen(String citizen) {
		Citizen = citizen;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public boolean isOrginalOfCountry() {
		return isOrginalOfCountry;
	}

	public void setOrginalOfCountry(boolean isOrginalOfCountry) {
		this.isOrginalOfCountry = isOrginalOfCountry;
	}
	
	public String getIOrginalOfCountry(boolean isOriginal)
	{
		return isOriginal ? "Yes" : "No";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Citizen == null) ? 0 : Citizen.hashCode());
		result = prime * result + ((CountryName == null) ? 0 : CountryName.hashCode());
		result = prime * result + (isOrginalOfCountry ? 1231 : 1237);
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
		Nationality other = (Nationality) obj;
		if (Citizen == null) {
			if (other.Citizen != null)
				return false;
		} else if (!Citizen.equals(other.Citizen))
			return false;
		if (CountryName == null) {
			if (other.CountryName != null)
				return false;
		} else if (!CountryName.equals(other.CountryName))
			return false;
		if (isOrginalOfCountry != other.isOrginalOfCountry)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Citizen: " + Citizen + ", Country: " + CountryName + ", "
				+ "Is he/she born in country: " + getIOrginalOfCountry(isOrginalOfCountry);
	}
	
}
