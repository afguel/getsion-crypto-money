package com.cda.cryptomoney.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class AbstractDAO {
	
	protected String request;
	protected PreparedStatement ps;
	protected ResultSet result;
	protected Connection connexion = Connexion.connect();
	protected Statement statement;
	
	public AbstractDAO() {
		 try {
			 statement = connexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 	

}
