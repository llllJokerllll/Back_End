package com.plexus.sabaris;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDAO {
    protected ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public ArrayList<Cliente> obtener() {
        return clientes;
    }

    public boolean insertar(Cliente cliente) {
        return clientes.add(cliente);
    }

    public Cliente buscarDni(String dni) {
        return clientes.stream().filter(e -> e.getDni().equals(dni)).collect(Collectors.toList()).get(0);
    }

    public List<Cliente> buscarNomApe(String nombre, String apellidos) {
        return clientes.stream().filter(e -> e.getNombre().equals(nombre) && e.getApellidos().equals(apellidos)).collect(Collectors.toList());
    }

    public boolean modificar(Cliente cliente) {
        boolean modificado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(cliente.getDni())) {
                clientes.get(i).setNombre(cliente.getNombre().equals("") ? clientes.get(i).getNombre() : cliente.getNombre());
                clientes.get(i).setApellidos(cliente.getApellidos().equals("") ? clientes.get(i).getApellidos() : cliente.getApellidos());
                clientes.get(i).setEdad(cliente.getEdad() == 0 ? clientes.get(i).getEdad() : cliente.getEdad());
                modificado = true;
                break;
            }
        }
        return modificado;
    }

    public boolean eliminar(String dni) {
        return clientes.removeIf(e -> e.getDni().equals(dni));
    }
}
