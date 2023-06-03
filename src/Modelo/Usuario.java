package Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String contraseña;
    private String nombreCompleto;
    private String ID;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Usuario(String nombre, String contraseña, String nombreCompleto, String ID) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
}
