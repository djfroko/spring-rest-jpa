package com.cice.springrestjpa.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioResource {

    @RequestMapping(method = RequestMethod.POST,path = "/login")
    public String LoginUsuario(@RequestParam (name = "user") String user, @RequestParam (name = "pass")String pass){
        return null;
    }

}
