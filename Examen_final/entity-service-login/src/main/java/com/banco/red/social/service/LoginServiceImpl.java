package com.banco.red.social.service;

import com.banco.red.social.entity.Users;
import com.banco.red.social.modelo.UsersDto;
import com.banco.red.social.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

@Autowired
	private LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}


	@Override
	public Users guardar(UsersDto usersDto) {
		Users user=Users.from(usersDto);
		return loginRepository.save(user);
	}



	@Override
	public Users obtenerById(String id) {
		return loginRepository.findById(id)
				.orElseThrow(() -> UserNoEncontradoException.from("No se encontro el usuario", id));
	}

	@Override
	public Users modificar(String id, UsersDto usersDto) {
		Users users = loginRepository.findById(id)
				.orElseThrow(() -> UserNoEncontradoException.from("No se encontro el usuario", id));
		users = users.from(usersDto);
		users = loginRepository.save(users);
		return users;

	}
	@Override
	public List<Users> obtenerTodo() {
		return loginRepository.findAll();
	}

	@Override
	public void remover(String id) {

	}
}