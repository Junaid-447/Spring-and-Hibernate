package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test_JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String password="hbstudent";
		
		try {
			System.out.println("Connecting to Database");
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection is Successful");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
