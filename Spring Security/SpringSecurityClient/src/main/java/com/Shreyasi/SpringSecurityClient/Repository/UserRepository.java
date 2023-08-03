package com.Shreyasi.SpringSecurityClient.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shreyasi.SpringSecurityClient.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

}
