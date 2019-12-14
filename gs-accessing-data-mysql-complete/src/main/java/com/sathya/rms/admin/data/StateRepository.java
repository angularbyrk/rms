package com.sathya.rms.admin.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sathya.rms.admin.entities.State;

public interface StateRepository extends CrudRepository<State, Integer> {
	public Optional<State> findByStId(String stId);
}
