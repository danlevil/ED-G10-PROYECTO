/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.ArrayList;
import Estructuras.LinkedCircularDE;
import Fields.Direccion;
import Fields.Email;
import Fields.Fecha;
import Fields.Foto;
import Fields.RedSocial;
import Fields.Telefono;

import java.time.LocalDate;

/**
 *
 * @author danlevil
 */
public class ContactoPersona extends Contacto {
    
    private static final long serialVersionUID=1L;

    //private String name;
//    private LocalDate fechaCumpleaños;
//    private ArrayList<Direccion> direccionPersonal;
//    private ArrayList<Telefono> telefonoPersonal;
//    
    
    
    //public ContactoPersona(){};
    public ContactoPersona(String nombre, String idContactoPadre, String idcontactoEnListaDePadre){
        super(nombre, idContactoPadre, idcontactoEnListaDePadre);
//        this.telefonoPersonal = telefonoPersonal;
//        this.fechaCumpleaños = fechaCumpleaños;
//        this.direccionPersonal = direccionPersonal;
        this.isEmpresa=false;
    }
    
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    
    


    
}
