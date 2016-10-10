package com.cooksys.repository;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    List<Itinerary> findByUser(User user);
}
