package com.banco.red.social.service;

import com.banco.red.social.entity.Users;
import com.banco.red.social.modelo.UsersDto;

import java.util.List;

public interface LoginService {
	Users guardar(UsersDto usersDto);

	Users obtenerById(String id);

	Users modificar(String id,UsersDto usersDto);

	List<Users> obtenerTodo();
	
	void remover(String id);
}
