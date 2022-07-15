/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import static data.Conexion.close;
import static data.Conexion.getConexion;
import entity.Jugadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 *
 * @author vicky
 */
public class EquipoDAO {
    // atributos para hacer el CRUD
    private static final String SQL_CREATE = "INSERT INTO jugadores(nombre,puesto,edad,pais,cotizacion) VALUES(?,?,?,?,?)";//para la insercion
    private static final String SQL_READ = "SELECT * FROM jugadores";// es el SQL_SELECT
    // para modificar cualquier campo 
    private static final String SQL_UPDATE="UPDATE jugadores SET nombre=?,puesto=?,edad=?,pais=?,cotizacion = ? WHERE idjugadores = ?";
    //  para modificar la cotizacion del jugador
    private static final String SQL_UPDATE_COTIZACION = "UPDATE jugadores SET cotizacion=? WHERE idjugadores = ?";
    
    private static final String SQL_DELETE = "DELETE FROM jugadores WHERE idjugadores = ?";
    
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM jugadores WHERE idjugadores = ?";
    
    //=========================================================================
    // metodo seleccionar que le cambio el nombre a findAll
    public List<Jugadores> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jugadores  jugador = null;
        List<Jugadores> jugadores = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            // este execute Query responde con ResultSet y se usa para 
            // un SELECT
            while (rs.next()) {
                int idjugadores = rs.getInt(1);
                String nombre = rs.getString(2);
                String puesto = rs.getString(3);
                int edad=rs.getInt(4);
                String pais=rs.getString(5);
                double cotizacion=rs.getDouble(6);
                

                jugador = new Jugadores(idjugadores,nombre,puesto,edad,pais,cotizacion);

                jugadores.add(jugador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return jugadores;
    }
    //=========================================================================
    // metodo para recupera un solo id, lo uso para editarJugador
    public Jugadores findPlayerById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jugadores jugador = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idjugadores = rs.getInt(1);
                String nombre = rs.getString(2);
                String puesto = rs.getString(3);
                int edad = rs.getInt(4);
                String pais=rs.getString(5);
                double cotizacion = rs.getDouble(6);
                

                jugador = new Jugadores(idjugadores,nombre,puesto,edad,pais,cotizacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return jugador;
    }
    
    //==========================================================================
    // metodo insertar para recibir un jugador que no tiene id e insertarlo en la BD
    public int create(Jugadores jugador){
        Connection conn = null;
        PreparedStatement stmt = null;
        // como es una insercion no hace falta el ResultSet 
        int registros = 0;// aqui se almacena el resultado de haber ejecutado la insercion
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            // con insercion uso SET
            stmt.setString(1, jugador.getNombre());//responde al orden de los singos de preguntas ?
            stmt.setString(2, jugador.getPuesto());
            stmt.setInt(3,jugador.getEdad());
            stmt.setString (4,jugador.getPais());
            stmt.setDouble(5,jugador.getCotizacion());
            registros = stmt.executeUpdate();
            // el execute UPDATE responde con una cantidad de registros
            // insertados yo modificados
            // es un nro entero
          
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    //=========================================================================
    // metodo para actualizar cualquier campo
    public int update(Jugadores jugador){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            // necesito todos los elementos
            
            stmt.setString(1, jugador.getNombre());//responde al orden de los signos de preguntas ?
            stmt.setString(2, jugador.getPuesto());
            stmt.setInt(3,jugador.getEdad());
            stmt.setString (4,jugador.getPais());
            stmt.setDouble(5,jugador.getCotizacion());
            stmt.setInt(6, jugador.getIdjugadores());
            
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    //==========================================================================
    // metodo actualizar que hay cambio en la cotizacion del jugador
    public int updateCotizacion(Jugadores jugador){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_COTIZACION);
            // necesito precio y el Id
            
            stmt.setDouble(1, jugador.getCotizacion());
            stmt.setInt(2, jugador.getIdjugadores());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    //==========================================================================
    //  metodo eliminar un jugador
    public int delete(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
