package com.banco.red.social.entity;

import com.banco.red.social.modelo.UsersDto;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@NotBlank
	private String usuario;
	@NotBlank
	private String contrasena;
	@NotBlank
	private String idPersona;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public static Users from(UsersDto usersDto) {
		Users users = new Users();
		users.setId(usersDto.getId());
		users.setUsuario(usersDto.getUsuario());
		users.setContrasena(usersDto.getContrasena());
		users.setIdPersona(usersDto.getIdPersona());
		return users;
	}

	public UsersDto to() {
		UsersDto users=new UsersDto();
		users.setId(getId());
		users.setUsuario(getUsuario());
		users.setContrasena(getContrasena());
		users.setIdPersona(getIdPersona());
		return users;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

}
