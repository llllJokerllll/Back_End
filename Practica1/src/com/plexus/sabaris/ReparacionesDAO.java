package com.plexus.sabaris;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReparacionesDAO {
    protected ArrayList<Reparacion> reparaciones = new ArrayList<>();

    static ClienteDAO c = new ClienteDAO();
    static VehiculoDAO v = new VehiculoDAO();

    public ArrayList<Reparacion> obtener() {
        Reparacion r2 = new Reparacion();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_reparacion, cliente, vehiculo, descripcion, fecha, tiempo, totalReparacion FROM reparacion;");

            while (rs.next()) {
                r2.setId_reparacion(rs.getInt(1));
                r2.setCliente(c.buscarDni(rs.getString(2)));
                r2.setVehiculo(v.buscarMatricula(rs.getString(3)));
                r2.setDescripcion(rs.getString(4));
                r2.setFecha(formatoDelTexto.parse(rs.getString(5)));
                r2.setTiempo(rs.getDouble(6));
                r2.setTotalReparacion(rs.getDouble(7));
                reparaciones.add(r2);
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException | ParseException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return reparaciones;
    }

    public List<Reparacion> buscarCliente(String dni) {
        List<Reparacion> reparaciones1 = new ArrayList<>();
        Reparacion r1 = new Reparacion();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_reparacion, cliente, vehiculo, descripcion, fecha, tiempo, totalReparacion FROM reparacion where cliente = '" + dni + "';");

            while (rs.next()) {
                r1.setId_reparacion(rs.getInt(1));
                r1.setCliente(c.buscarDni(rs.getString(2)));
                r1.setVehiculo(v.buscarMatricula(rs.getString(3)));
                r1.setDescripcion(rs.getString(4));
                r1.setFecha(formatoDelTexto.parse(rs.getString(5)));
                r1.setTiempo(rs.getDouble(6));
                r1.setTotalReparacion(rs.getDouble(7));
                reparaciones1.add(r1);
            }
            ConexionBD.devolverConexion(con);

        } catch (SQLException | ParseException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return reparaciones1;
    }

    public List<Reparacion> buscarVehiculo(String matricula) {
        return reparaciones.stream().filter(e -> e.getVehiculo().getMatricula().equals(matricula)).collect(Collectors.toList());
    }

    public List<Reparacion> buscarFecha(Date fecha) {
        return reparaciones.stream().filter(e -> e.getFecha().equals(fecha)).collect(Collectors.toList());
    }

    public boolean insertar(Reparacion reparacion) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("INSERT INTO reparacion (cliente, vehiculo, descripcion, fecha, tiempo, totalReparacion) VALUES ('" + reparacion.getCliente() + "', '" + reparacion.getVehiculo() + "', '" + reparacion.getDescripcion() + "', " + reparacion.getFecha() + ", " + reparacion.getTiempo() + ", " + reparacion.getTotalReparacion() + ");");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: ");e.printStackTrace();
        }
        return aceptado;
    }

    public boolean modificar(Reparacion reparacion) {
        boolean aceptado = true;
        try {
            Connection con = ConexionBD.obterConexion();
            Statement st = con.createStatement();
            aceptado = st.execute("UPDATE reparacion SET vehiculo = '" + reparacion.getVehiculo() + "', descripcion = '" + reparacion.getDescripcion() + "', fecha = " + reparacion.getFecha() + ", tiempo = " + reparacion.getTiempo() + ", totalReparacion = " + reparacion.getTotalReparacion() + " where id_reparacion = " + reparacion.getId_reparacion() + ";");

            ConexionBD.devolverConexion(con);
            return aceptado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        }
        return aceptado;
    }

}
