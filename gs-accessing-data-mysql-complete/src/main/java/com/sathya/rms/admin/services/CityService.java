package com.sathya.rms.admin.services;

import java.util.Optional;

import com.sathya.rms.admin.entities.City;

public interface CityService {
	
	public Iterable<City> getAllCities();
	
	public Optional<City> getCityById(int id);

	public City insertCity(City city);
	
	public City updateCity(City city);
	
	public void deleteCity(Integer id);
	
}
