package com.banco.red.social.api;

import com.banco.red.social.entity.Users;
import com.banco.red.social.modelo.TemplateResponse;
import com.banco.red.social.modelo.UsersDto;
import com.banco.red.social.service.LoginServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("users/v1")
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	LoginServiceImpl loginServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public TemplateResponse crear(@RequestBody UsersDto usersDto) {
		log.info(">>> users/v1 creando usuario, wuju nuevo usuario!!");
		Users usuarios=loginServiceImpl.guardar(usersDto);
		TemplateResponse response = new TemplateResponse("El Usuario se ha creado exitosamente", "201", usuarios);
		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Users consultarUsuarioById(@PathVariable("id") String id) {
		log.info(">>> usuarios/v1 consultarUsuariosById ");
		return loginServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Users> obtenerTodosLosUsuarios() {
		log.info(">>> usuarios/v1 obtenerTodosLosClientes ");
		return loginServiceImpl.obtenerTodo();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse modificarUsuarios(@PathVariable("id") String id, @RequestBody UsersDto usersDto) {
		log.info(">>> usuarios/v1 modificarClientes ");
		Users usuarios = loginServiceImpl.modificar(id, usersDto);
		TemplateResponse response = new TemplateResponse("El Cliente se ha actualizado exitosamente", "200", usuarios);
		return response;
	}
}
