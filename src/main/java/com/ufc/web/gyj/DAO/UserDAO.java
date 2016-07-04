package com.ufc.web.gyj.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.ufc.web.gyj.model.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Long>{
	
	/**
	   * Return the user having the passed email or null if no user is found.
	   * 
	   * @param email the user email.
	   */
	
	 User save(User usr);

}
