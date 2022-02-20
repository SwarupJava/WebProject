package com.ashokit.usermgmt.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.usermgmt.model.CountryModel;


public interface CountryRepository extends JpaRepository<CountryModel, Integer> {

	

}
