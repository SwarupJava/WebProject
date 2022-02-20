package com.ashokit.usermgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.usermgmt.model.StateModel;

public interface StateRepository extends JpaRepository<StateModel, Integer> {
   
	public List<StateModel> findByCountryId(Integer countryId);
}
