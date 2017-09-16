package com.main.EvidentApp;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ClientData")
public class ClientData {

	private int id;
	private String name;
	private String surname;
	private int no_visits;
	
	private String mobile;
	private String email;

	@Id
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public int getNoVisits() {
		return no_visits;
	}
	public String getMobile() {
		return mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	ClientData(int id, String name, String surname, int no_visits, String mobile, String email){
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.no_visits=no_visits;
		this.mobile=mobile;
		this.email = email;
	}



}
