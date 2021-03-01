package com.plexus.sabaris;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Reparacion {

    private int id_reparacion;

    private Cliente cliente;

    private Vehiculo vehiculo;

    private String descripcion;

    private Date fecha;

    private double tiempo;

    private double totalReparacion;

    public SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Reparacion() {
        super();
    }

    public Reparacion(Cliente cliente, Vehiculo vehiculo, String descripcion, Date fecha, double tiempo, double totalReparacion) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.totalReparacion = totalReparacion;
    }

    public int getId_reparacion() {
        return id_reparacion;
    }

    public void setId_reparacion(int id_reparacion) {
        this.id_reparacion = id_reparacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getTotalReparacion() {
        return totalReparacion;
    }

    public void setTotalReparacion(double totalReparacion) {
        this.totalReparacion = totalReparacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reparacion)) return false;
        Reparacion that = (Reparacion) o;
        return getId_reparacion() == that.getId_reparacion() &&
                Double.compare(that.getTiempo(), getTiempo()) == 0 &&
                Double.compare(that.getTotalReparacion(), getTotalReparacion()) == 0 &&
                getCliente().equals(that.getCliente()) &&
                getVehiculo().equals(that.getVehiculo()) &&
                getDescripcion().equals(that.getDescripcion()) &&
                getFecha().equals(that.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_reparacion(), getCliente(), getVehiculo(), getDescripcion(), getFecha(), getTiempo(), getTotalReparacion());
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "id_reparacion=" + id_reparacion +
                ", cliente='" + cliente + '\'' +
                ", vehiculo='" + vehiculo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + formatter.format(fecha) +
                ", tiempo=" + tiempo +
                "h, totalReparacion=" + totalReparacion +
                "€}";
    }
}
