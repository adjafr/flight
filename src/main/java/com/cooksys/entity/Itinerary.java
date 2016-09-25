package com.cooksys.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Itinerary
{
	
	@Id
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="user_id_seq")
	@Column(updatable=false)
	
	private Integer id;
	
	@Column//(nullable=false)
	@ElementCollection(targetClass = SavedFlight.class)
	private List<SavedFlight> savedFlight;
	

	
	
	@ManyToOne(fetch=FetchType.EAGER)  //, cascade = CascadeType.REMOVE
	@JoinColumn
	private User user;




	public Itinerary()
	{
		super();
		
	}




	public Itinerary(Integer id, List<SavedFlight> savedFlight, User user)
	{
		super();
		this.id = id;
		this.savedFlight = savedFlight;
		this.user = user;
	}




	public Integer getId()
	{
		return id;
	}




	public void setId(Integer id)
	{
		this.id = id;
	}




	public List<SavedFlight> getSavedFlight()
	{
		return savedFlight;
	}




	public void setSavedFlight(List<SavedFlight> savedFlight)
	{
		this.savedFlight = savedFlight;
	}




	public User getUser()
	{
		return user;
	}




	public void setUser(User user)
	{
		this.user = user;
	}
	
	
	
	
	
	

}
