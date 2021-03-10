package com.plexus.sabaris;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {
    protected ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public ArrayList<Cliente> obtener() {
        Cliente u3 = new Cliente();
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DNI, Nombre, Apellidos, Edad FROM cliente;");

            while (rs.next()) {
                u3.setDni(rs.getString(1));
                u3.setNombre(rs.getString(2));
                u3.setApellidos(rs.getString(3));
                u3.setEdad(Integer.parseInt(rs.getString(4)));
                clientes.add(u3);
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return clientes;
    }

    public Cliente buscarDni(String dni) {
        Cliente u1 = new Cliente();
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DNI, Nombre, Apellidos, Edad FROM cliente where DNI = '" + dni + "';");

            if (rs.next()) {
                u1.setDni(rs.getString(1));
                u1.setNombre(rs.getString(2));
                u1.setApellidos(rs.getString(3));
                u1.setEdad(Integer.parseInt(rs.getString(4)));
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return u1;
    }

    public ArrayList<Cliente> buscarNomApe(String nombre, String apellidos) {
        ArrayList<Cliente> clientes2 = new ArrayList<>();
        Cliente u2 = new Cliente();
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DNI, Nombre, Apellidos, Edad FROM cliente where Nombre = '" + nombre + "' AND Apellidos = '" + apellidos + "';");

            while (rs.next()) {
                u2.setDni(rs.getString(1));
                u2.setNombre(rs.getString(2));
                u2.setApellidos(rs.getString(3));
                u2.setEdad(Integer.parseInt(rs.getString(4)));
                clientes2.add(u2);
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return clientes2;
    }

    @Override
    public Cliente get(int id) {
        return null;
    }

    @Override
    public List<Cliente> getAll() {
        return null;
    }

    @Override
    public boolean insertar(Cliente cliente) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("INSERT INTO cliente (DNI, Nombre, Apellidos, Edad) VALUES ('" + cliente.getDni() + "', '" + cliente.getNombre() + "', '" + cliente.getApellidos() + "', '" + cliente.getEdad() + "');");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: ");e.printStackTrace();
        }
        return aceptado;
    }

    @Override
    public boolean modificar(Cliente cliente) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("UPDATE cliente SET DNI = '" + cliente.getDni() + "', Nombre = '" + cliente.getNombre() + "', Apellidos = '" + cliente.getApellidos() + "', Edad = '" + cliente.getEdad() + "' WHERE DNI = '" + cliente.getDni() + "';");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return aceptado;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("DELETE FROM cliente WHERE DNI = '" + cliente.getDni() + "';");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: ");e.printStackTrace();
        }
        return aceptado;
    }
}
