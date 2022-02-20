// 
// Decompiled by Procyon v0.5.36
// 

package com.ashokit.sbms.usermgmt.repository;

import java.util.List;


import java.io.Serializable;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ashokit.sbms.usermgmt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

	
}
