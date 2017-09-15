package com.main.EvidentApp;




@Entity
@Table(name = "ClientData")
public class ClientData {

	private int id;
	private String name;
	private String surname;
	private int no_visits;
	
	private String mobile;

	@Id
	public int getId() {
		return id;
	}

	public int getName() {
		return id;
	}
	public int getSurname() {
		return id;
	}
	public int getNoVisits() {
		return id;
	}
	public int getMobile() {
		return id;
	}
	
	
	ClientData(int id, String name, String surname, int no_visits, String mobile){
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.no_visits=no_visits;
		this.mobile=mobile;
	}
}
