package com.cda.cryptomoney.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion implements AutoCloseable{

	
	private static Connection connexion = null;
	
	
	private Connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties appProps = new Properties();
			appProps.load(Connexion.class.getResourceAsStream("/projet.properties"));
			System.out.println(appProps.getProperty("url"));
			connexion = DriverManager.getConnection(
					appProps.getProperty("url"), 
					appProps.getProperty("username"),
					appProps.getProperty("password"));
			System.out.println("connecté ");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static Connection connect() {
		if(connexion==null) {
			new Connexion();
		}		
		return connexion;
	}


	@Override
	public void close() {
		if (connexion != null)
			try {
				connexion.close();
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}		
	}

}
