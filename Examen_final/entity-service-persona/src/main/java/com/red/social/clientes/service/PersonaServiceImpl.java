package com.red.social.clientes.service;

import com.red.social.clientes.entity.Personas;
import com.red.social.clientes.modelo.PersonasDto;
import com.red.social.clientes.modelo.UsuariosDto;
import com.red.social.clientes.repository.PersonaRepository;
import com.red.social.clientes.service.remote.AdministracionPersonasServiceRemote;

import com.red.social.clientes.service.remote.async.PersonasProducer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonaServiceImpl implements PersonaService {

@Autowired

	private PersonaRepository personaRepository;
	@Qualifier("altaUsuariosServiceClientFallback")
	@Autowired
	private AdministracionPersonasServiceRemote admServiceRemote;

	@Autowired
	private PersonasProducer personasProducer;
	private Logger log = Logger.getLogger(String.valueOf(PersonaServiceImpl.class));

	Gson json = new Gson();



	public PersonaServiceImpl(PersonaRepository personaRepository, @Qualifier("altaUsuariosServiceClientFallback") AdministracionPersonasServiceRemote admServiceRemoter,PersonasProducer personasProducer) {
		this.personaRepository = personaRepository;
		this.admServiceRemote = admServiceRemote;
		this.personasProducer=personasProducer;
	}




	@Transactional
	@Override
	public Personas guardar(PersonasDto personasDto) {
		UsuariosDto usuariosDto=new UsuariosDto();
		Personas personas=Personas.from(personasDto);
		 personas=personaRepository.saveAndFlush(personas);
		 usuariosDto.setIdPersona(personas.getId());
		 usuariosDto.setUsuario(personasDto.getUsuario());
		 usuariosDto.setContrasena(personasDto.getContrasena());
		log.info(">>>Enviando solicitud de alta de usuario");
		admServiceRemote.crea(usuariosDto);
		return personas;


	}

	@Override
	public Personas obtenerById(String id) {
		return personaRepository.findById(id)
				.orElseThrow(() -> PersonaNoEncontradoException.from("No se encontro la persona", id));
	}

	@Override
	public Personas modificar(String id, PersonasDto personasDto) {
		Personas personas = personaRepository.findById(id)
				.orElseThrow(() -> PersonaNoEncontradoException.from("No se encontro el usuario", id));
		personas = personas.from(personasDto);
		personas= personaRepository.save(personas);
		return personas;
	}

	@Override
	public List<Personas> obtenerTodo() {
		return personaRepository.findAll();
	}

	@Override
	public void remover(String id) {

	}
}