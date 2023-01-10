package com.red.social.clientes.repository;

import com.red.social.clientes.entity.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Personas, String> {
	  Optional<Personas> findById(String id);
}
