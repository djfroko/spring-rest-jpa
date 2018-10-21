package com.cice.springrestjpa.sevice.impl;

import com.cice.springrestjpa.data.entity.UsuarioEntity;
import com.cice.springrestjpa.data.repository.UsuarioRepository;
import com.cice.springrestjpa.sevice.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioService implements IUsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public String login(String user, String pass) throws UnsupportedEncodingException {
        String respuesta = null;


        UsuarioEntity usuarioEntity = usuarioRepository.findByUserAndPass(user, pass);

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pass.getBytes("UTF-8"));
        System.out.println(md);
        pass = md.toString();


        if (usuarioEntity != null) {

            respuesta = "todo a ido bien";

        } else {
            respuesta = "Usuario o contraseña no coinciden";
        }

        return respuesta;
    }

    @Override
    public String crear(String user, String pass, String email, int telefono, String ciudad) throws UnsupportedEncodingException {
        String respuesta = null;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pass.getBytes("UTF-8"));
        System.out.println(md);
        pass = md.toString();

        UsuarioEntity usuario = usuarioRepository.crearUsuario(user, pass, email, telefono, ciudad);

        if (usuario != null) {

            respuesta = "usuario creado";

        } else {
            respuesta = "Usuario no creado";
        }

        return respuesta;
    }

    @Override
    public String buscarUsuario(String user) {
        String respuesta = null;

        UsuarioEntity usuario = usuarioRepository.buscarUsuario(user);

        if (usuario != null) {

            System.out.println(usuario);
            respuesta = "usuario entcontrado";

        } else {
            System.out.println("Usuario no encontrado");
            respuesta = "usuario no encontrado";
        }

        return respuesta;

    }
}
