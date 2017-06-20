package com.PluralSight.Repository;

import java.util.List;

import com.PluralSight.Model.User;

public interface UserRepository {

	List<User> findAllUsers();

	User findUser(String userId);

	void create(User user);
	
}