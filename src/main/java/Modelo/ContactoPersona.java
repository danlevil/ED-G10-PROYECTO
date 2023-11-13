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
    private LocalDate fechaCumpleaños;
    private ArrayList<Direccion> direccionPersonal;
    private ArrayList<Telefono> telefonoPersonal;
    
    
    
    //public ContactoPersona(){};
    public ContactoPersona(String nombre,  boolean favorito, ArrayList<Direccion> direcciones,ArrayList<Direccion> direccionPersonal, ArrayList<Email> emails, ArrayList<Telefono> telefonos, ArrayList<Telefono> telefonoPersonal, LinkedCircularDE<Foto> fotos, ArrayList<RedSocial> redesSociales, ArrayList<String> etiquetas, LinkedCircularDE<Fecha> fechasImportantes, LocalDate fechaCumpleaños){
        super(nombre,  favorito, direcciones, emails, telefonos, fotos, redesSociales, etiquetas, fechasImportantes);
        this.nombre= nombre;
        this.telefonoPersonal = telefonoPersonal;
        this.fechaCumpleaños = fechaCumpleaños;
        this.direccionPersonal = direccionPersonal;
        this.isEmpresa=false;
    }
    
    
     @Override
    public String toString() {
        return super.toString() + ";" + fechaCumpleaños + ";"+direccionPersonal.get(0)+";"+ telefonoPersonal.get(0) ;
    }
    
    public String getEstadoFavorito(){
        if(favorito){
            return "S";
        }else{
            return "N";
        }
    }
    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }


    public LocalDate getFechaCumpleaños() {
        return fechaCumpleaños;
    }

    public void setFechaCumpleaños(LocalDate fechaCumpleaños) {
        this.fechaCumpleaños = fechaCumpleaños;
    }

    
    
   /* @Override
    public void editarMe() {
       
    }*/


    
}
