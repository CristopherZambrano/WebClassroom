/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Crisito
 */
public class Tutor {
    int id;
    String apellido;
    String email;
    String nombre;
    String telefono;
    String tipoUser;

    public Tutor() {
    }

    public Tutor(int id, String apellido, String email, String nombre, String telefono, String tipoUser) {
        this.id = id;
        this.apellido = apellido;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoUser = tipoUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
    
}
