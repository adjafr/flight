package com.cooksys.entity;

import java.util.List;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User
{
	
	@Id
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="user_id_seq")
	@Column(updatable=false)
	private Integer id;
	
	@Column(updatable=false)
	private String name;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER)  //, cascade = CascadeType.REMOVE
//	@JoinColumn
	private List<Itinerary> itinerary;
	
	

	public User()
	{
		super();
	}

	public User(Integer id, String name, String username, String password, List<Itinerary> itinerary)
	{
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.itinerary = itinerary;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<Itinerary> getItinerary()
	{
		return itinerary;
	}

	public void setItinerary(List<Itinerary> itinerary)
	{
		this.itinerary = itinerary;
	}

	
	
	

}
