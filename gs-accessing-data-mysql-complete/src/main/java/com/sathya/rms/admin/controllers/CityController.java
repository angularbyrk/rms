package com.sathya.rms.admin.controllers;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rms.admin.entities.City;
import com.sathya.rms.admin.entities.State;
import com.sathya.rms.admin.services.CityService;
import com.sathya.rms.admin.services.StateService;

@RestController
@RequestMapping(path = "/city")
public class CityController {
	private static final Logger logger = LogManager.getLogger(CityController.class);	
	@Autowired
	CityService cityService;
	
	@Autowired
	StateService stateService;

	@GetMapping(path = "/getAllCities")
	public	Iterable<City>	getAllCities(){
		logger.info("get All cities method execution started");
		Iterable<City> result = null;
		try {
			result = cityService.getAllCities();
			logger.debug("result is {0}",result);
		}
		catch(Exception e) {
			logger.error("exception happens and exception info is {0} ",e);
		}
		logger.info("get All cities method execution completed");
		
		return result;
	}
	
	@PostMapping(path = "/addCity")
	public City insertCity(@RequestBody City city) {
		logger.info("insertCity method execution started");
		
		logger.debug("input data is {0}",city);
		
		City result= null;
		try {
			Optional<State> oState = stateService.getStateByStId(city.getStId());
			if(oState.get()==null)
				throw new Exception("invalid state id");
			city.setState(oState.get());
			result=cityService.insertCity(city);
			logger.debug("result is {0}",result);
		}
		catch(Exception e) {
			logger.error("input data is {0}",city);
		}
		logger.info("insertCity method execution completed");
		return result;
	}
	
	@PutMapping(path="/updateCity")
	public City updateCity(@RequestBody City city) {
		return cityService.updateCity(city);
	}
	
	@DeleteMapping(path="/deleteCity/{id}")
	public void deleteCity(@PathVariable("id") Integer id) {
		cityService.deleteCity(id);
	}

}
