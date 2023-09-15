package com.springmvc.domain;
import java.io.Serializable;
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 3636831123198280235L;
	private String customerId;         //고객ID 
	private String name;               //고객명
	private Address address;          //고객 주소 객체
	private String phone;             //고객 전화번호
	//↑ Customer 클래스의 customerId, name, address, phone 필드 등을 선언
	
	public Customer() {
		this.address= new Address();
	}
	//↑ 기본 생성자 Customer() 추가
	
	public Customer(String customerId, String name) {
		 this();
		this.customerId = customerId;
		this.name = name;
	}
	//↑ 일반 생성자 Customer() 추가
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//↑ 각 필드에 대한 Setter()와 Getter() 메서드 추가
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
	//↑  hashCode(), equals() 메서드를 추가함. 
	
	
	
}
