package com.ashokit.sbms.usermgmt.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.sbms.usermgmt.entity.Country;
import com.ashokit.sbms.usermgmt.entity.State;

public interface CountryRepository extends JpaRepository<Country, Serializable>
{
	Optional<State> findById(Long id);
}
