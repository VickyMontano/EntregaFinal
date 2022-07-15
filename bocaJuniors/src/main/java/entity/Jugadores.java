/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vicky
 */
public class Jugadores {
     //              atributos
    private int idjugadores;
    private String nombre;
    private String puesto;
    private int edad;
    private String pais;
    private double cotizacion;
    
    //========================================================================
    //              constructor con todos los atributos

    public Jugadores(int idjugadores, String nombre, String puesto, int edad, String pais, double cotizacion) {
        this.idjugadores = idjugadores;
        this.nombre = nombre;
        this.puesto = puesto;
        this.edad = edad;
        this.pais = pais;
        this.cotizacion = cotizacion;
    }

    
    //              constructor sin el Id

    public Jugadores(String nombre, String puesto, int edad, String pais, double cotizacion) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.edad = edad;
        this.pais = pais;
        this.cotizacion = cotizacion;
    }

    public int getIdjugadores() {
        return idjugadores;
    }

    public void setIdjugadores(int idjugadores) {
        this.idjugadores = idjugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getCotizacion() {
        return cotizacion;
    }

    //              setter y getter
    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }

    //              ToString sin el Id
    @Override
    public String toString() {
        return "Jugadores{" + "nombre=" + nombre + ", puesto=" + puesto + ", edad=" + edad + ", pais=" + pais + ", cotizacion=" + cotizacion + '}';
    }
    
    
}
