package com.ashokit.usermgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.usermgmt.model.CityModel;

public interface CityRepository extends JpaRepository<CityModel, Integer> {

	List<CityModel> findByStateId(Integer stateId);
}
