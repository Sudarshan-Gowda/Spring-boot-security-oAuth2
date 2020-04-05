/**
 * 
 */
package com.star.sud.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.user.model.TUser;

/**
 * @author Sudarshan
 *
 */
public interface UserDao extends JpaRepository<TUser, Long> {

	/**
	 * @param userId
	 * @return
	 */
	TUser findByUsername(String userId);

}
