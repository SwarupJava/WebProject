package com.ashokit.sbms.usermgmt.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQuery;

import java.io.Serializable;
import com.ashokit.sbms.usermgmt.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StateRepository extends JpaRepository<State, Long>
{
	  //@Query("select s.id, s.stateName from State s where s.countryId =: countryId") 
	  Optional<State> findById(Long countryId);
}
