package com.red.social.clientes.service.remote;

import com.red.social.clientes.modelo.TemplateResponse;
import com.red.social.clientes.modelo.UsuariosDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "api-users")
public interface AdministracionPersonasServiceRemote {

    @RequestMapping(method = POST, value = "users/v1", produces = "application/json")
    TemplateResponse crea(@RequestBody UsuariosDto usuariosDto);

}
