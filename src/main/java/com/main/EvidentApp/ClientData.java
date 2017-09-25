package com.main.EvidentApp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CLIENTDATA")
public class ClientData {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private int no_visits;
	@Column
	private String mobile;
	@Column
	private String email;

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
	
	ClientData(){}



}
