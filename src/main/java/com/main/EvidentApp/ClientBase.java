package com.main.EvidentApp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ClientBase {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String birthDate;
    @Column
    private String address;
    @Column
    private String pesel;
    @Column
    private int no_visits;
    @Column
    private String mobile;
    @Column
    private String email;

    @Column
    private DiseaseCard diseaseCard;

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

    ClientBase(int id, String name, String surname, String birthDate, String address, String pesel,
            int no_visits, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.pesel = pesel;
        this.no_visits = no_visits;
        this.mobile = mobile;
        this.email = email;
    }

    ClientBase() {
    }

}
