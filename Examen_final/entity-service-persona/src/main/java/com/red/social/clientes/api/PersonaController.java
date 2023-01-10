package com.red.social.clientes.api;

import com.red.social.clientes.entity.Personas;
import com.red.social.clientes.modelo.PersonasDto;
import com.red.social.clientes.modelo.TemplateResponse;
import com.red.social.clientes.service.PersonaServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("personas/v1")
public class PersonaController {

	private static final Logger log = Logger.getLogger(PersonaController.class);
	@Autowired
	PersonaServiceImpl personaServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public TemplateResponse crear(@RequestBody PersonasDto personasDto) {
		log.info(">>> personas/v1 creando persona, wuju nueva persona!!");
		Personas personas=personaServiceImpl.guardar(personasDto);
		TemplateResponse response = new TemplateResponse("La persona se ha creado exitosamente", "201", personas);
		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Personas consultarPersonasById(@PathVariable("id") String id) {
		log.info(">>> personas/v1 consultarPersonasById ");
		return personaServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Personas> obtenerTodosLasPersonas() {
		log.info(">>> personas/v1 obtenerTodosLasPersonas ");
		return personaServiceImpl.obtenerTodo();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse modificarPersonas(@PathVariable("id") String id, @RequestBody PersonasDto personasDto) {
		log.info(">>> usuarios/v1 modificarClientes ");
		Personas personas=personaServiceImpl.modificar(id, personasDto);
		TemplateResponse response = new TemplateResponse("Las persona se han actualizado exitosamente", "200", personas);
		return response;
	}
}
