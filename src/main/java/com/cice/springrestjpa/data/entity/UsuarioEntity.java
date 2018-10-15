package com.cice.springrestjpa.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long idUsuario;

    @Column(name = "user")
    private String user;

    @Column(name="pass")
    private String pass;


}
