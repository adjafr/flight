package com.cooksys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.response.ItineraryResponse;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.service.ItineraryService;

@Service
public class ItineraryServiceImpl implements ItineraryService
{
	
	@Autowired
	private final ItineraryRepository itineraryRepo;

	@Autowired
	public ItineraryServiceImpl(ItineraryRepository itineraryRepo)
	{
		super();
		this.itineraryRepo = itineraryRepo;
	}

	@Override
	public List<ItineraryResponse> index()
	{
		return ItineraryResponse.list(this.itineraryRepo.findAll());
	}
	
	
	
	
	

}
