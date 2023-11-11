/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author danlevil
 */
public class ContactoPersona extends Contacto {
    private String name;
    private LocalDate fechaCumpleaños;
    
    
    
    public ContactoPersona(){};
    public ContactoPersona(String name, String apellido, 
            LocalDate cumpleaños){
        super();
        this.nombre= name+" "+apellido;
        this.isEmpresa=false;
        
        
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    
}
