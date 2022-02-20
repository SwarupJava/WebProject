package com.ashokit.usermgmt.repositories;






import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashokit.usermgmt.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	public UserModel findUserByEmail(String email);
	
	public UserModel findUserByEmailAndPassword(String email, String password);
	
	@Modifying
	@Query("UPDATE UserModel u SET u.status = ?1 WHERE u.email = ?2")
	public int updateAccountStatus(String status, String email);

	@Modifying
	@Query("UPDATE UserModel u SET u.password = ?1 WHERE u.email = ?2")
	public int updatePassword(String password, String email);
}
