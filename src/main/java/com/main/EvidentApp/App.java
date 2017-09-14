package com.main.EvidentApp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.evident.db.*;

public class App { 

	public static void main(String[] args) {
		
		DbConnectionHandler handler = new DbConnectionHandler();
		ResultSet res;
		
		
		try {
			res = handler.diplayUsers();
			while(res.next()){
				System.out.println(res.getString("fname") + " " + res.getString("lname"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		


	}

}
