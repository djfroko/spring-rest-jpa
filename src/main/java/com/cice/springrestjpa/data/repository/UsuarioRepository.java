package com.cice.springrestjpa.data.repository;

import com.cice.springrestjpa.data.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long>{

    UsuarioEntity findByUserAndPass(String user,String pass);

    UsuarioEntity crearUsuario(String user, String pass, String email, int telefono, String ciudad);

    UsuarioEntity buscarUsuario(String user);


}
