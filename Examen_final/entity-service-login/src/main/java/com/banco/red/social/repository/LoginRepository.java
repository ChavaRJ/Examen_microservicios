package com.banco.red.social.repository;

import com.banco.red.social.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Users, String> {
	  Optional<Users> findById(String id);
}
