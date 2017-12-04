package com.main.EvidentApp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTDATA")
public class ClientData extends ClientBase {

    ClientData(int id, String name, String surname, String birthDate, String address, String pesel,
            int no_visits, String mobile, String email) {
        super(id, name, surname, birthDate, address, pesel, no_visits, mobile, email);
    }

    ClientData() {
    }

}
