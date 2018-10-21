package com.cice.springrestjpa.rest;

import com.cice.springrestjpa.sevice.IUsuarioService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController

public class UsuarioResource {

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.POST,path = "/login")
    public String LoginUsuario(@RequestParam (name = "user") String user, @RequestParam (name = "pass")String pass){

        try {
            return usuarioService.login(user,pass);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }


    }

    @RequestMapping(method = RequestMethod.POST,path = "/crear")
    public String CrearUsuario(@RequestParam (name = "user") String user, @RequestParam (name = "pass")String pass,  @RequestParam (name = "email")String email,
                               @RequestParam (name = "telefono")int telefono, @RequestParam (name = "ciudad")String ciudad){

        try {
            return usuarioService.crear(user,pass,email,telefono,ciudad);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }


    }

    @RequestMapping(method = RequestMethod.POST,path = "/leer")
    public String Buscar(@RequestParam (name = "user") String user){

        return usuarioService.buscarUsuario(user);



    }

}
