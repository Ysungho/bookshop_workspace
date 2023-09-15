package com.springmvc.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
public class Shipping implements Serializable{
	
	 private static final long serialVersionUID = 8121814661110003493L;
	 
	 
	private String name;        //��� ����
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	//�� @DateTimeFormat �ֳ����̼��� date �Ӽ��� ���� �������� ��¥ ǥ���������� ������ ���� ������ ������
	//�� ���⼭ date �Ӽ��� ���ϰ� ��ġ�ؾ� �ϰ� ��ȿ�� �˻縦 �� �� ���ϰ� ����ġ�ϸ� �������� ����. 
	private Date date;          //�����
	private Address address;   //��� �ּ� ��ü
	//�� Shipping Ŭ������ name, date, address, �ʵ� ���� �߰���
	
	public Shipping() {
		this.address = new Address();
	}
	//�� �⺻ ������ Shipping() ����
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
	//�� �� �ʵ忡 �ʿ��� Setter(), Getter() �޼��� �߰�. 
	
}
