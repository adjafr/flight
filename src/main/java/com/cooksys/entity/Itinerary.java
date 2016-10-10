package com.cooksys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Itinerary implements Serializable {

    @Id
    @SequenceGenerator(name = "itinerary_id_seq", sequenceName = "itinerary_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "itinerary_id_seq")
    @Column(updatable = false)
    private Integer id;

    @Column
    @OneToMany(mappedBy = "itinerary", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Flight> savedFlight = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)  //, cascade = CascadeType.REMOVE
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column
    private int layOver;
    
    @Column
    private int totalTripTime;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Flight> getSavedFlight() {
		return savedFlight;
	}

	public void setSavedFlight(List<Flight> savedFlight) {
		this.savedFlight = savedFlight;
	}

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public int getLayOver() {
		return layOver;
	}

	public void setLayOver(int layOver) {
		this.layOver = layOver;
	}

	public int getTotalTripTime() {
		return totalTripTime;
	}

	public void setTotalTripTime(int totalTripTime) {
		this.totalTripTime = totalTripTime;
	}
    
    
}
