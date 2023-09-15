package com.springmvc.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
public class Shipping implements Serializable{
	
	 private static final long serialVersionUID = 8121814661110003493L;
	 
	 
	private String name;        //배송 고객명
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	//↑ @DateTimeFormat 애너테이션은 date 속성의 제약 사항으로 날짜 표현형식으로 다음과 같은 패턴을 가진다
	//↑ 여기서 date 속성은 패턴과 일치해야 하고 유효성 검사를 할 때 패턴과 불일치하면 동작하지 않음. 
	private Date date;          //배송일
	private Address address;   //배송 주소 객체
	//↑ Shipping 클래스의 name, date, address, 필드 등을 추가함
	
	public Shipping() {
		this.address = new Address();
	}
	//↑ 기본 생성자 Shipping() 생성
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	//↑ 각 필드에 필요한 Setter(), Getter() 메서드 추가. 
	
}
