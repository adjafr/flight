package com.cooksys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.repository.LocationRepository;
import com.cooksys.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository repo;

    public List<Location> getAll() {
        return repo.findAll();
    }

    public Location get(long id) {
        return repo.findById(id);
    }

    public Location get(String name) {
        return repo.findByCity(name);
    }

}
