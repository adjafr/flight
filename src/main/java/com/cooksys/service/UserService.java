package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.SavedFlight;
import com.cooksys.entity.User;
import com.cooksys.entity.UserResponse;
import com.cooksys.entity.ValidateResponse;



public interface UserService
{
	
	// ------ Validate Response ---------
	
		List<ValidateResponse> indexValidate();
		
		ValidateResponse readValidate(String username);
		
		
		// ----- Get Current Flights --------
		
		
		List<SavedFlight> getAllFlights();
		
		
		
		// ------ User Response -----------
		
		UserResponse create(User user);

		List<UserResponse> index();
		
		UserResponse read(String username);
		
		UserResponse updateUser(Integer id, User userToUpdate);
		
		UserResponse delete(User user);

		

//		List<UserResponse> readFollowers(Integer id);
//		
//		UserResponse addFollowers(Integer id, User userFollower);
//
//		List<UserResponse> readFollowing(Integer id);
//		
//		UserResponse createFollowings(Integer id, User userToFollow);

//		List<UserProjection> usernameMatches(String replace);

}
