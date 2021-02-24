package com.plexus.sabaris;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReparacionesDAO {
    protected ArrayList<Reparacion> reparaciones = new ArrayList<Reparacion>();

    public ArrayList<Reparacion> obtener() {
        return reparaciones;
    }

    public boolean insertar(Reparacion reparacion) {
        reparacion.setId_reparacion(reparaciones.size());
        return reparaciones.add(reparacion);
    }

    public boolean modificar(Reparacion vehiculo) {
        boolean modificado = false;
        for (int i = 0; i < reparaciones.size(); i++) {
            if (reparaciones.get(i).getId_reparacion() == vehiculo.getId_reparacion()) {
                reparaciones.get(i).setDescripcion(vehiculo.getDescripcion());
                reparaciones.get(i).setFecha(vehiculo.getFecha());
                reparaciones.get(i).setTiempo(vehiculo.getTiempo());
                reparaciones.get(i).setTotalReparacion(vehiculo.getTotalReparacion());
                modificado = true;
                break;
            }
        }
        return modificado;
    }

    public List<Reparacion> buscarCliente(String dni) {
        return reparaciones.stream().filter(e -> e.getCliente().equals(dni)).collect(Collectors.toList());
    }

    public List<Reparacion> buscarVehiculo(String matricula) {
        return reparaciones.stream().filter(e -> e.getVehiculo().equals(matricula)).collect(Collectors.toList());
    }

    public List<Reparacion> buscarFecha(Date fecha) {
        return reparaciones.stream().filter(e -> e.getFecha().equals(fecha)).collect(Collectors.toList());
    }

}
