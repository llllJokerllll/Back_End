package com.plexus.sabaris;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReparacionesDAO {
    protected ArrayList<Reparacion> reparaciones = new ArrayList<>();

    public ArrayList<Reparacion> obtener() {
        return reparaciones;
    }

    public boolean insertar(Reparacion reparacion) {
        reparacion.setId_reparacion(reparaciones.size());
        return reparaciones.add(reparacion);
    }

    public boolean modificar(Reparacion reparacion) {
        boolean modificado = false;
        for (int i = 0; i < reparaciones.size(); i++) {
            if (reparaciones.get(i).getId_reparacion() == reparacion.getId_reparacion()) {
                reparaciones.get(i).setCliente(reparacion.getCliente() == null ? reparaciones.get(i).getCliente() : reparacion.getCliente());
                reparaciones.get(i).setVehiculo(reparacion.getVehiculo() == null ? reparaciones.get(i).getVehiculo() : reparacion.getVehiculo());
                reparaciones.get(i).setDescripcion(reparacion.getDescripcion().equals("") ? reparaciones.get(i).getDescripcion() : reparacion.getDescripcion());
                reparaciones.get(i).setFecha(reparacion.getFecha().equals("") ? reparaciones.get(i).getFecha() : reparacion.getFecha());
                reparaciones.get(i).setTiempo(reparacion.getTiempo() == 0.0d ? reparaciones.get(i).getTiempo() : reparacion.getTiempo());
                reparaciones.get(i).setTotalReparacion(reparacion.getTotalReparacion() == 0.0d ? reparaciones.get(i).getTotalReparacion() : reparacion.getTotalReparacion());
                modificado = true;
                break;
            }
        }
        return modificado;
    }

    public List<Reparacion> buscarCliente(String dni) {
        return reparaciones.stream().filter(e -> e.getCliente().getDni().equals(dni)).collect(Collectors.toList());
    }

    public List<Reparacion> buscarVehiculo(String matricula) {
        return reparaciones.stream().filter(e -> e.getVehiculo().getMatricula().equals(matricula)).collect(Collectors.toList());
    }

    public List<Reparacion> buscarFecha(Date fecha) {
        return reparaciones.stream().filter(e -> e.getFecha().equals(fecha)).collect(Collectors.toList());
    }

}
