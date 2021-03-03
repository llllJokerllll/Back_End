package com.plexus.sabaris;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO implements DAO<Vehiculo> {
    protected ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public ArrayList<Vehiculo> obtener() {
        return vehiculos;
    }

    public Vehiculo buscarMatricula(String matricula) {
        Vehiculo v1 = new Vehiculo();
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Matricula, Marca, Modelo, Ano, Color FROM vehiculo where Matricula = '" + matricula + "';");

            while (rs.next()) {
                v1.setMatricula(rs.getString(1));
                v1.setMarca(rs.getString(2));
                v1.setModelo(rs.getString(3));
                v1.setAno(Integer.parseInt(rs.getString(4)));
                v1.setColor(rs.getString(5));
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return v1;
    }

    public ArrayList<Vehiculo> buscarMarMod(String marca, String modelo) {
        ArrayList<Vehiculo> vehiculos2 = new ArrayList<>();
        Vehiculo v2 = new Vehiculo();
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Matricula, Marca, Modelo, Ano, Color FROM vehiculo where Marca = '" + marca + "' AND Modelo = '" + modelo + "';");

            while (rs.next()) {
                v2.setMatricula(rs.getString(1));
                v2.setMarca(rs.getString(2));
                v2.setModelo(rs.getString(3));
                v2.setAno(Integer.parseInt(rs.getString(4)));
                v2.setColor(rs.getString(5));
                vehiculos2.add(v2);
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return vehiculos2;
    }

    public ArrayList<Vehiculo> buscarMarModAno(String marca, String modelo, int ano) {
        ArrayList<Vehiculo> vehiculos3 = new ArrayList<>();
        Vehiculo v3 = new Vehiculo();
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Matricula, Marca, Modelo, Ano, Color FROM vehiculo where Marca = '" + marca + "' AND Modelo = '" + modelo + "' AND Ano = " + ano + ";");

            while (rs.next()) {
                v3.setMatricula(rs.getString(1));
                v3.setMarca(rs.getString(2));
                v3.setModelo(rs.getString(3));
                v3.setAno(rs.getInt(4));
                v3.setColor(rs.getString(5));
                vehiculos3.add(v3);
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return vehiculos3;
    }

    @Override
    public Vehiculo get(int id) {
        return null;
    }

    @Override
    public List<Vehiculo> getAll() {
        return null;
    }

    @Override
    public boolean eliminar(Vehiculo vehiculo) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("DELETE FROM vehiculo WHERE Matricula = '" + vehiculo.getMatricula() + "';");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: ");e.printStackTrace();
        }
        return aceptado;
    }

    @Override
    public boolean insertar(Vehiculo vehiculo) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("INSERT INTO vehiculo (Matricula, Marca, Modelo, Ano, Color) VALUES ('" + vehiculo.getMatricula() + "', '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', " + vehiculo.getAno() + ", '" + vehiculo.getColor() + "');");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: ");e.printStackTrace();
        }
        return aceptado;
    }

    @Override
    public boolean modificar(Vehiculo vehiculo) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("UPDATE vehiculo SET Matricula = '" + vehiculo.getMatricula() + "', Marca = '" + vehiculo.getMarca() + "', Modelo = '" + vehiculo.getModelo() + "', Ano = " + vehiculo.getAno() + ", Color = '" + vehiculo.getColor() + "' where Matricula = '" + vehiculo.getMatricula() + "';");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return aceptado;
    }

}
