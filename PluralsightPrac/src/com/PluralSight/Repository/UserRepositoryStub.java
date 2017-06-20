package com.PluralSight.Repository;
import java.util.ArrayList;
import java.util.List;

import com.PluralSight.Model.User;
public class UserRepositoryStub implements UserRepository  {
	
	
	
/* (non-Javadoc)
 * @see com.PluralSight.Repository.UserRepository#findAllUsers()
 */
@Override
public List<User> findAllUsers(){
	List<User> usersList=new ArrayList<User>();
	User users = new User();
	users.setUserName("Nidhi@Purohith.com");
	users.setPassword("abc@123");
	users.setRetypePassword("abc@123");
	users.setPhoneNumber("1234567890");
	usersList.add(users);
	return usersList;
}

@Override
public User findUser(String userId) {
	// TODO Auto-generated method stub
	User users = new User();
	users.setId("1234");
	users.setUserName("Nidhi@Purohith.com");
	users.setPassword("abc@123");
	users.setRetypePassword("abc@123");
	users.setPhoneNumber("1234567890");
	return users;
}

@Override
public void create(User user) {
	// TODO Auto-generated method stub
	
}
	
	
}
