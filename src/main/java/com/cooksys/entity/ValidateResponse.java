package com.cooksys.entity;

import java.util.ArrayList;
import java.util.List;



public class ValidateResponse
{
	
	private Integer id;
	
	private String name;
	
	private String username;
	
	private String password;

	public ValidateResponse(User user)
	{
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		
	}
	
	public static List<ValidateResponse> getUsers(List<User> list) 
	{
		ArrayList<ValidateResponse> result = new ArrayList<>();
		for (User user : list)
			result.add(new ValidateResponse(user));
		return result;
	}
	
	public static ValidateResponse getUser(User user) 
	{
		return new ValidateResponse(user);
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	

}
