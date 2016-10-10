package com.cooksys.service;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import com.cooksys.entity.response.UserResponse;
import com.cooksys.entity.response.ValidateResponse;
import com.cooksys.entity.Flight;

import java.util.List;


public interface UserService {

    List<ValidateResponse> indexValidate();

    ValidateResponse readValidate(String username);

    List<Flight> getAllFlights();

    UserResponse create(User user);

    List<UserResponse> index();

    UserResponse read(String username);

    UserResponse updateUser(Integer id, User userToUpdate);

    UserResponse delete(User user);

    Itinerary createItinerary(String username, Itinerary itinerary);

}
