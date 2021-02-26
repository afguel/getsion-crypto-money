package com.cda.cryptomoney.dao;

import java.util.List;

public interface Repository<U> {

	/**
	 * lists all u entities 
	 * 
	 */
	
	List<U> getAll();
	
	/**
	 * Create a new u.
	 * 
	 */
	
	 U save(U u);
	 
	 /**
	  * Finds and displays a u entity.
	  * 
	  */
	 
	 U getOneById(int id);
	 
	 /**
	  * edit an existing u entity
	  * 
	  */
	 
	 U setOneById(int id,U u);
	 
	 /**
	  * delete a u entity
	  * 
	  */
	
	 boolean deleteOneById(int id);
	 
	 
}
