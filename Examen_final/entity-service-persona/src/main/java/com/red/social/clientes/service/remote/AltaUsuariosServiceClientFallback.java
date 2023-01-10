package com.red.social.clientes.service.remote;


import com.red.social.clientes.modelo.TemplateResponse;
import com.red.social.clientes.modelo.UsuariosDto;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AltaUsuariosServiceClientFallback implements AdministracionPersonasServiceRemote{
    private static final Logger log = Logger.getLogger(String.valueOf(AltaUsuariosServiceClientFallback.class));


    @Override
    public TemplateResponse crea(UsuariosDto usuariosDto) {

        return null;
    }
}
