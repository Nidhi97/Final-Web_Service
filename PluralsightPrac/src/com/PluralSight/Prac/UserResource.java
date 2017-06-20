package com.PluralSight.Prac; 

import java.sql.Connection; 

import java.sql.DriverManager; 

import java.sql.ResultSet; 

import java.sql.SQLException; 

import java.sql.Statement; 

import java.util.ArrayList; 

import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes; 

import javax.ws.rs.GET; 

import javax.ws.rs.POST; 

import javax.ws.rs.Path; 

import javax.ws.rs.PathParam; 

import javax.ws.rs.Produces; 

import javax.ws.rs.core.MediaType; 

 
 

import com.PluralSight.Model.User; 

import com.PluralSight.Repository.UserRepository; 

import com.PluralSight.Repository.UserRepositoryStub; 

@Path("users") 

public class UserResource { 

private UserRepository users=new UserRepositoryStub(); 

@POST 

@Path("user") 

@Consumes(MediaType.APPLICATION_JSON) 

@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 

public User createUser(User user) throws SQLException,ClassNotFoundException 

{ 
	/*System.out.println(user);
	String uname=inputJsonObj.getString("userName"); 
	String pwd=inputJsonObj.getString("password"); 
	String rpwd=inputJsonObj.getString("retypePassword"); 
	int phoneno=inputJsonObj.getInt("phoneNumber"); */
	
	String uname=user.getUserName();
	String pwd=user.getPassword(); 

	String rpwd=user.getRetypePassword(); 

	String phoneno=user.getPhoneNumber(); 
	user.setUserName(uname);
	user.setPassword(pwd);
	user.setRetypePassword(rpwd);
	user.setPhoneNumber(phoneno);
Class.forName("com.mysql.jdbc.Driver"); 

String jdbcUrl = "jdbc:mysql://localhost:3306/mysampledb"; 

       String username = "root"; 

       String password = "Nidhi@97";  

    Connection connection = null;    

    connection = DriverManager.getConnection(jdbcUrl, username, password); 

    Statement statement = connection.createStatement(); 
    
    String sql = "insert into user values ('','"+uname +"','"+pwd+"','"+rpwd+"',"+phoneno+")"; 

    statement.executeUpdate(sql);
    users.create(user);
return user; 

} 

@GET 

@Path("getallusers") 

@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 

public List<User> getAllUsers() throws SQLException, ClassNotFoundException  

{ 

List<User> userlist=new ArrayList<User>(); 

Class.forName("com.mysql.jdbc.Driver"); 

String jdbcUrl = "jdbc:mysql://localhost:3306/mysampledb"; 

       String username = "root"; 

       String password = "Nidhi@97";  

    Connection connection = null;    

    connection = DriverManager.getConnection(jdbcUrl, username, password); 

    Statement statement = connection.createStatement(); 

    String sql = "select * from user"; 

    ResultSet rs = statement.executeQuery(sql); 

    while(rs.next()){ 

    User users = new User(); 

    users.setId(rs.getString("id")); 

    users.setUserName(rs.getString("username")); 

    users.setPassword(rs.getString("password")); 

    users.setRetypePassword(rs.getString("rpwd")); 

    users.setPhoneNumber(rs.getString("phoneno")); 

    userlist.add(users); 

    } 

    return userlist; 

} 

@GET 

@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 

@Path("{userId}") 

public User getUser(@PathParam("userId") String userId) throws SQLException, ClassNotFoundException 

{ 

Class.forName("com.mysql.jdbc.Driver"); 

String jdbcUrl = "jdbc:mysql://localhost:3306/mysampledb"; 

       String username = "root"; 

       String password = "Nidhi@97";  

    Connection connection = null;    

    connection = DriverManager.getConnection(jdbcUrl, username, password); 

    Statement statement = connection.createStatement(); 

    String sql = "select * from user where id='"+userId+"'"; 

    ResultSet rs = statement.executeQuery(sql); 

    User users = new User(); 

    while(rs.next()){ 

     

    users.setId(rs.getString("id")); 

    users.setUserName(rs.getString("username")); 

    users.setPassword(rs.getString("password")); 

    users.setRetypePassword(rs.getString("rpwd")); 

    users.setPhoneNumber(rs.getString("phoneno")); 

    } 

    return users; 

} 

} 

 
 

 