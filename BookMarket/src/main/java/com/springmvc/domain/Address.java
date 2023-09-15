package com.springmvc.domain;
import java.io.Serializable;
public class Address implements Serializable{
	
	private static final long serialVersionUID = 613846598817670033L;
	private String detailName;     //세부주소  
	private String addressName;   //주소 
	private String country;        //국가명
	private String zipCode;        //우편번호
	//↑ 위에서 부터 전부
	//↑ Address 클래스의 detailName, addressName, country, zipCode 필드 등을 선언합니다. 
	
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	//↑ getDetailName() 부터 setZipCode 까지
	//↑ 각 필드에 대한 Setter()와 Getter()  메서드를 추가함
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressName == null) ? 0 : addressName.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((detailName == null) ? 0 : detailName.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		if (addressName == null) {
			if (other.addressName != null)
				return false;
		} else if (!addressName.equals(other.addressName))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (detailName == null) {
			if (other.detailName != null)
				return false;
		} else if (!detailName.equals(other.detailName))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	//↑ hashcode(), equals() 메서드추가. 
	
	
}
