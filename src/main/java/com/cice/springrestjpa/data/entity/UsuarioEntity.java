package com.cice.springrestjpa.data.entity;


import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long idUsuario;
    
    @Column(name = "username")
    private String user;

    @Column(name="password")
    private String pass;


}
