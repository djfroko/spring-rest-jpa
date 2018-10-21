package com.cice.springrestjpa.sevice;

import java.io.UnsupportedEncodingException;

public interface IUsuarioService {

    String login(String user, String pass) throws UnsupportedEncodingException;

    String crear(String user, String pass, String email, int telefono, String ciudad) throws UnsupportedEncodingException;

    String buscarUsuario(String user);


}
