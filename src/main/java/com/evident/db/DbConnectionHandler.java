package com.evident.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DbConnectionHandler {

	private static Connection con;
	private static boolean hasData = false;
	
	public ResultSet diplayUsers() throws ClassNotFoundException, SQLException{
		if(con == null){
			getConnection();
		}
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT fname, lname FROM user");
		return res;
	}

	private void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:SQLiteEvidentClients.db");
		initialize();
	}

	private void initialize() throws SQLException {
		if(!hasData){
			hasData = true;
			
			Statement state = con.createStatement();
			// check it there is any table.
			ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='user'");
			
			if( !res.next() ){
				System.out.println(" Building table with populated values");
				// Create a table.
				Statement stateCreate = con.createStatement();
				stateCreate.execute("CREATE TABLE user(id integer, "
						+ "fName varchamr(60)," + "lName varchar (60), "
						+ "primary key(id));");
				
				// Insert some data for start.
				PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?);");
				prep.setString(2, "medonyo");
				prep.setString(3, "medival");
				prep.execute();
				
				PreparedStatement prep2 = con.prepareStatement("INSERT INTO user values(?,?,?);");
				prep2.setString(2, "kato");
				prep2.setString(3, "ancient");
				prep2.execute();
			}
			
		}
		
	}
	
	public void addUser(String firstName, String lastName) throws ClassNotFoundException, SQLException{
		if( con == null){
			getConnection();
		}
		
		PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?);");
		prep.setString(2, firstName);
		prep.setString(3, lastName);
		prep.execute();
	}
	
}
