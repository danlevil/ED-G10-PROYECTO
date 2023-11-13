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
public class ContactoEmpresa extends Contacto{
    String Titulo;
    String puestoTrabajo;
    
    //public ContactoEmpresa(){}
    public ContactoEmpresa(String nombre,String Titulo,String puestoTrabajo, boolean favorito, ArrayList<Direccion> direcciones, ArrayList<Email> emails, ArrayList<Telefono> telefonos, LinkedCircularDE<Foto> fotos, ArrayList<RedSocial> redesSociales, ArrayList<String> etiquetas, LinkedCircularDE<Fecha> fechasImportantes){
        super(nombre, favorito, direcciones, emails, telefonos, fotos, redesSociales, etiquetas, fechasImportantes);
        this. Titulo= Titulo;
        this.puestoTrabajo=puestoTrabajo;
        this.nombre=nombre;
        this.isEmpresa=true;
    }

     @Override
    public String toString() {
        return super.toString() + ";" + isEmpresa;
    }
    
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }
    
    
    /*@Override
    public void editarMe() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

}
