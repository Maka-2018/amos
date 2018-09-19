package com.person.entity;

public class Address {

	private String Street;
	private String ZipCode;
	private String CityName;
	private String CountyName;
	
	public Address()
	{}
	
	public Address(String newStreet, String newCode, String newCounty, String newCountry)
	{
		Street = newStreet; ZipCode = newCode;
		CountyName = newCounty; CityName = newCountry;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getCountyName() {
		return CountyName;
	}

	public void setCountyName(String countyName) {
		CountyName = countyName;
	}

	public String getCountryName() {
		return CityName;
	}

	public void setCountryName(String countryName) {
		CityName = countryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CityName == null) ? 0 : CityName.hashCode());
		result = prime * result + ((CountyName == null) ? 0 : CountyName.hashCode());
		result = prime * result + ((Street == null) ? 0 : Street.hashCode());
		result = prime * result + ((ZipCode == null) ? 0 : ZipCode.hashCode());
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
		Address other = (Address) obj;
		if (CityName == null) {
			if (other.CityName != null)
				return false;
		} else if (!CityName.equals(other.CityName))
			return false;
		if (CountyName == null) {
			if (other.CountyName != null)
				return false;
		} else if (!CountyName.equals(other.CountyName))
			return false;
		if (Street == null) {
			if (other.Street != null)
				return false;
		} else if (!Street.equals(other.Street))
			return false;
		if (ZipCode == null) {
			if (other.ZipCode != null)
				return false;
		} else if (!ZipCode.equals(other.ZipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Street: " + Street + ", Zip Code: " + ZipCode + ", County" + CountyName + ", City: "
				+ CityName;
	}
	
}
