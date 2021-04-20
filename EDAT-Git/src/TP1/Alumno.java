/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

/**
 *
 * @author ximeh
 */
public class Alumno {
    private String legajo;
    private String nombre;
    private String tipoDni;
    private int numDni;
    private String calle;
    private int num; //numero de casa
    private String ciudad;
    private int telefono;
    private String clave;
    
    private boolean valido = false;
    
    //-----------Constructores--------------
    public Alumno(String leg) {
        legajo = leg;
        nombre = "";
        tipoDni = "";
        numDni = 0;
        calle = "";
        num = 0;
        ciudad = "";
        telefono = 0;
        clave = "";
    }
    
    public Alumno(String leg, String nom, String tipoDni, int numDni, String calle, int num, String ciud, int tel, String clave) {
        legajo = leg;
        nombre = nom;
        this.tipoDni = tipoDni;
        this.numDni = numDni;
        this.calle = calle;
        this.num = num;
        ciudad = ciud;
        telefono = tel;
        this.clave = clave;
    }
    
    //------------Observadores-------------

    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public int getNumDni() {
        return numDni;
    }

    public String getCalle() {
        return calle;
    }

    public int getNum() {
        return num;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTelefono() {
        return telefono;
    }
    
    @Override
    public String toString() {
        return "Nombre: " +nombre+ "\nLegajo: " +legajo+ "\nDocumento: " +tipoDni+ " " +numDni+ "\nDireccion: " +calle+ " " +num+ "\nCiudad: " +ciudad+ "\nTelefono: " +telefono;
    }
    
    //--------------Modificadores----------------

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int num) {
        this.num = num;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setClave(boolean valido, String clave) {
        if (valido) {
            this.clave = clave;
        } else {
            System.out.println("Clave no verificada");
        }
    }
    
    //------------------OTROS----------------------
    public boolean verificaClave(String clave) {
        if (this.clave.equals(clave)) {
           valido = true;
        }
        return valido;
    }
    
}
