package com.ashokit.sbms.usermgmt.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.sbms.usermgmt.entity.City;

public interface CityRepository extends JpaRepository<City, Serializable>
{
	@Query("from City c where c.stateId =: stateId")
    List<City> findByStateId(final Long id);
}
