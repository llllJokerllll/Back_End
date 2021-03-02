package com.plexus.sabaris;

import java.io.Serializable;
import java.util.Objects;

public class Vehiculo implements Serializable {

    private String matricula;

    private String marca;

    private String modelo;

    private int ano;

    private String color;

    public Vehiculo() {
        super();
    }

    public Vehiculo(String matricula, String marca, String modelo, int ano, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return getAno() == vehiculo.getAno() &&
                getMatricula().equals(vehiculo.getMatricula()) &&
                getMarca().equals(vehiculo.getMarca()) &&
                getModelo().equals(vehiculo.getModelo()) &&
                getColor().equals(vehiculo.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula(), getMarca(), getModelo(), getAno(), getColor());
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", color='" + color + '\'' +
                '}';
    }
}
