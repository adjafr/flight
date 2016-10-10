package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.response.ItineraryResponse;
import com.cooksys.entity.response.UserResponse;
import com.cooksys.service.ItineraryService;

@RestController
@CrossOrigin//(origins = "http://localhost:8000")   // @CrossOrigin(origins = "*")
@RequestMapping("/itineraries")
public class ItineraryController
{
	
	private final ItineraryService itineraryService;

	@Autowired
	public ItineraryController(ItineraryService itineraryService)
	{
		super();
		this.itineraryService = itineraryService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ItineraryResponse> index() {
		return this.itineraryService.index();
	}
	

}
