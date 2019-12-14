package com.sathya.rms.admin.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.rms.admin.data.CityRepository;
import com.sathya.rms.admin.entities.City;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	public Iterable<City> getAllCities(){
		// call data layer-> get data
		return cityRepository.findAll();
	}

	@Transactional
	public City insertCity(City city) {
		return cityRepository.save(city);
	}

	public Optional<City> getCityById(int id) {
		return cityRepository.findById(id);
	}
	
	@Transactional
	public City updateCity(City city) {
		return cityRepository.save(city);
	}
	
	@Transactional
	public void deleteCity(Integer id) {
		cityRepository.deleteById(id);
	}

}