package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.repository.LocationRepository;


public interface LocationService {

    List<Location> getAll();

    Location get(long id);

    Location get(String name);
}
