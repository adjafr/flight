package com.cooksys.service.impl;

import com.cooksys.entity.*;
import com.cooksys.entity.response.UserResponse;
import com.cooksys.entity.response.ValidateResponse;
import com.cooksys.repository.FlightRepository;
import com.cooksys.repository.UserRepository;
import com.cooksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepo;

    @Autowired
    private final FlightRepository flightRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, FlightRepository flightRepository) {
        super();
        this.userRepo = userRepo;
        this.flightRepository = flightRepository;
    }

    @Override
    public List<ValidateResponse> indexValidate() {
        return ValidateResponse.getUsers(this.userRepo.findAll());
    }

    @Override
    public ValidateResponse readValidate(String username) {
        List<ValidateResponse> tempList = ValidateResponse.getUsers(this.userRepo.findAll());

        for (ValidateResponse validateResponse : tempList) {
            if (validateResponse.getUsername().equals(username))
                return validateResponse;
        }
        return null;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public UserResponse create(User user) {
        this.userRepo.save(user);
        return UserResponse.getUser(user);
    }

    @Override
    public List<UserResponse> index() {
        return UserResponse.getUsers(this.userRepo.findAll());
    }

    @Override
    public UserResponse read(String username) {
        List<UserResponse> tempList = UserResponse.getUsers(this.userRepo.findAll());

        for (UserResponse userResponse : tempList) {
            if (userResponse.getUsername().equals(username))
                return userResponse;
        }
        return null;
    }

    @Override
    public UserResponse updateUser(Integer id, User userToUpdate) {
        userToUpdate.setId(id);
        this.userRepo.save(userToUpdate);
        return UserResponse.getUser(userToUpdate);
    }

    @Override
    public UserResponse delete(User user) {
        this.userRepo.delete(user);
        return UserResponse.getUser(user);
    }

    @Override
    public Itinerary createItinerary(String username, Itinerary itinerary) {
        List<User> users = this.userRepo.findAll();
        User tempUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                tempUser = user;
            }
        }
        tempUser.getItinerary().add(itinerary);

        this.userRepo.saveAndFlush(tempUser);
        return itinerary;
    }
}
