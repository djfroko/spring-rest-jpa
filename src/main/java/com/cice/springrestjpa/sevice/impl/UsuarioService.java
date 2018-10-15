package com.cice.springrestjpa.sevice.impl;

import com.cice.springrestjpa.data.entity.UsuarioEntity;
import com.cice.springrestjpa.data.repository.UsuarioRepository;
import com.cice.springrestjpa.sevice.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public String login(String user, String pass) {
        String respuesta = null;

        UsuarioEntity usuarioEntity = usuarioRepository.findByUserAndPass(user, pass);

        if (usuarioEntity != null) {

            respuesta = "todo a ido bien";

        } else {
            respuesta = "Usuario o contraseña no coinciden";
        }

        return respuesta;
    }
}
