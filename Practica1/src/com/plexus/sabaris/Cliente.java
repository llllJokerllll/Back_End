package com.plexus.sabaris;

import java.util.Objects;

public class Cliente {

    private String dni;

    private String nombre;

    private String apellidos;

    private int edad;

    public Cliente() {
        super();
    }

    public Cliente(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getEdad() == cliente.getEdad() &&
                getDni().equals(cliente.getDni()) &&
                getNombre().equals(cliente.getNombre()) &&
                getApellidos().equals(cliente.getApellidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getNombre(), getApellidos(), getEdad());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }
}
