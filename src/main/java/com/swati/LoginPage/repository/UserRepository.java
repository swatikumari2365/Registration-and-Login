package com.swati.LoginPage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swati.LoginPage.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail(String email);

}
