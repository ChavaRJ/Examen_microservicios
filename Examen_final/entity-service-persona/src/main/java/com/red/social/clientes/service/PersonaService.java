package com.red.social.clientes.service;

import com.red.social.clientes.entity.Personas;
import com.red.social.clientes.modelo.PersonasDto;

import java.util.List;

public interface PersonaService {
	Personas guardar(PersonasDto personasDto);

	Personas obtenerById(String id);

	Personas modificar(String id, PersonasDto personasDto);

	List<Personas> obtenerTodo();
	
	void remover(String id);
}
