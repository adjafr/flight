package com.cooksys.entity;

import java.util.ArrayList;
import java.util.List;

public class UserResponse
{
	
private Integer id;
	
	private String name;
	
	private String username;
	
//	private List<UserResponse> following;
//	
//	private List<UserResponse> followers;
	
	public UserResponse(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getUsername());
//		this.setFollowing(UserResponse.getUsers(user.getFollowing()));
//		this.setFollowers(UserResponse.getUsers(user.getFollowers()));
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
