package com.red.social.clientes.entity;

import com.red.social.clientes.modelo.PersonasDto;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personas")
public class Personas implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@NotBlank
	private String nombre;
	@Column(name = "apellido_paterno")
	@NotBlank
	private String apellidoPaterno;
	@Column(name = "apellido_materno")
	@NotBlank
	private String apellidoMaterno;
	private Integer edad;
	@NotBlank
	private String rfc;
	@NotBlank
	private String email;
	@NotBlank
	private String direccion;
	@Column(name = "codigo_postal")
	private String codigoPostal;
	private String referencias;
	@NotBlank
	private String genero;


	public static Personas from(PersonasDto personasDto) {
		Personas personas=new Personas();
		personas.setNombre(personasDto.getNombre());
		personas.setApellidoMaterno(personasDto.getApellidoMaterno());
		personas.setApellidoPaterno(personasDto.getApellidoPaterno());
		personas.setCodigoPostal(personasDto.getCodigoPostal());
		personas.setDireccion(personasDto.getDireccion());
		personas.setEdad(personasDto.getEdad());
		personas.setEmail(personasDto.getEmail());
		personas.setGenero(personasDto.getGenero());
		personas.setNombre(personasDto.getNombre());
		personas.setReferencias(personasDto.getReferencias());
		personas.setRfc(personasDto.getRfc());
		return personas;
	}

	public PersonasDto to() {
		PersonasDto personas = new PersonasDto();
		personas.setId(getId());
		personas.setNombre(getNombre());
		personas.setApellidoPaterno(getApellidoPaterno());
		personas.setApellidoMaterno(getApellidoMaterno());
		personas.setCodigoPostal(getCodigoPostal());
		personas.setDireccion(getDireccion());
		personas.setEdad(getEdad());
		personas.setEmail(getEmail());
		personas.setGenero(getGenero());
		personas.setReferencias(getReferencias());
		personas.setRfc(getRfc());
		return personas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
