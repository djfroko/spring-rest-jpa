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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UsuarioEntity(Long idUsuario) {
        this.idUsuario = idUsuario;

    }

    public UsuarioEntity(Long idUsuario, String user, String pass) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.pass = pass;
    }
}
