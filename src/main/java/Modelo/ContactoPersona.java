/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author danlevil
 */
public class ContactoPersona extends Contacto {
    private String name;
    private String apellido;
    private LocalDate fechaCumpleaños;
    
    
    
    public ContactoPersona(){};
    public ContactoPersona(String name, String apellido, 
            LocalDate cumpleaños){
        this.nombre= name+" "+apellido;
        this.isEmpresa=false;
        
        
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaCumpleaños() {
        return fechaCumpleaños;
    }

    public void setFechaCumpleaños(LocalDate fechaCumpleaños) {
        this.fechaCumpleaños = fechaCumpleaños;
    }

    
    
    @Override
    public void editarMe() {
       
    }

    @Override
    public ArrayList<String> mostrarInformacionAdicional() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
