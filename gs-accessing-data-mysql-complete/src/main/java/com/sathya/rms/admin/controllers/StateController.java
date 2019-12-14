package com.sathya.rms.admin.controllers;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rms.admin.entities.State;
import com.sathya.rms.admin.services.StateService;

@RestController
@RequestMapping(path = "/states")
@CrossOrigin
public class StateController {
	private static final Logger logger = LogManager.getLogger(StateController.class);	
	@Autowired
	StateService stateService;

	@GetMapping(path = "/getAllStates")
	public	Iterable<State>	getAllStates(){
		logger.info("get All states method execution started");
		Iterable<State> result = null;
		try {
			result = stateService.getAllStates();
			logger.debug("result is {0}",result);
		}
		catch(Exception e) {
			logger.error("exception happens and exception info is {0} ",e);
		}
		logger.info("get All states method execution completed");
		
		return result;
	}
	
	@PostMapping(path = "/addState")
	public State insertState(@RequestBody State state) {
		logger.info("insertState method execution started");
		
		logger.debug("input data is {0}",state);
		
		State result= null;
		try {
			result=stateService.insertState(state);
			logger.debug("result is {0}",result);
		}
		catch(Exception e) {
			logger.error("input data is {0}",state);
		}
		logger.info("insertState method execution completed");
		return result;
	}
	
	@PutMapping(path="/updateState")
	public State updateState(@RequestBody State state) {
		return stateService.updateState(state);
	}
	
	@DeleteMapping(path="/deleteState/{id}")
	public void deleteState(@PathVariable("id") Integer id) {
		stateService.deleteState(id);
	}

}
