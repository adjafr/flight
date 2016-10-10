package com.cooksys.entity.response;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.User;

public class UserResponse
{
	
private Integer id;
	
	private String name;
	
	private String username;
	
	public UserResponse(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getUsername());
	}
	
	public static List<UserResponse> getUsers(List<User> list) {
		ArrayList<UserResponse> result = new ArrayList<>();
		for (User user : list)
			result.add(new UserResponse(user));
		return result;
	}
	
	public static UserResponse getUser(User user) {
		return new UserResponse(user);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
