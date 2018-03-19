package com.demo.system.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.system.entity.UserAccount;


@Repository
public interface UserAccountDao extends CrudRepository<UserAccount, Long>{
	UserAccount findByUsernameAndPassword(String username,String password);
	UserAccount findByUsername(String username); 
}
