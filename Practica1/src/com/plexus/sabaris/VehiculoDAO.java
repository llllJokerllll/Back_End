package com.plexus.sabaris;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehiculoDAO {
    protected ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public ArrayList<Vehiculo> obtener() {
        return vehiculos;
    }

    public boolean insertar(Vehiculo vehiculo) {
        return vehiculos.add(vehiculo);
    }

    public Vehiculo buscarMatricula(String matricula) {
        return vehiculos.stream().filter(e -> e.getMatricula().equals(matricula)).collect(Collectors.toList()).get(0);
    }

    public List<Vehiculo> buscarMarMod(String marca, String modelo) {
        return vehiculos.stream().filter(e -> e.getMarca().equals(marca) && e.getModelo().equals(modelo)).collect(Collectors.toList());
    }

    public List<Vehiculo> buscarMarModAno(String marca, String modelo, int ano) {
        return vehiculos.stream().filter(e -> e.getMarca().equals(marca) && e.getModelo().equals(modelo) && e.getAno() == ano).collect(Collectors.toList());
    }

    public boolean modificar(Vehiculo vehiculo) {
        boolean modificado = false;
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getMatricula().equals(vehiculo.getMatricula())) {
                vehiculos.get(i).setMarca(vehiculo.getMarca());
                vehiculos.get(i).setModelo(vehiculo.getModelo());
                vehiculos.get(i).setAno(vehiculo.getAno());
                vehiculos.get(i).setColor(vehiculo.getColor());
                modificado = true;
                break;
            }
        }
        return modificado;
    }

    public boolean eliminar(String matricula) {
        return vehiculos.removeIf(e -> e.getMatricula().equals(matricula));
    }
}
