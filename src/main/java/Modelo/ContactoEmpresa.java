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
    private static final long serialVersionUID=1L;

    String Titulo;
    String puestoTrabajo;
    private ArrayList<Telefono> telefonoPersonal;
    
    public ContactoEmpresa(String nombre,String Titulo,String puestoTrabajo, boolean favorito, ArrayList<Direccion> direcciones, ArrayList<Email> emails, ArrayList<Telefono> telefonos, ArrayList<Telefono> telefonoPersonal,LinkedCircularDE<Foto> fotos, ArrayList<RedSocial> redesSociales, ArrayList<String> etiquetas, LinkedCircularDE<Fecha> fechasImportantes){
        super(nombre, favorito, direcciones, emails, telefonos, fotos, redesSociales, etiquetas, fechasImportantes);
        this. Titulo= Titulo;
        this.telefonoPersonal = telefonoPersonal;
        this.puestoTrabajo=puestoTrabajo;
        this.nombre=nombre;
        this.isEmpresa=true;
    }

     @Override
    public String toString() {
        return super.toString() + ";" + isEmpresa +";"+ telefonoPersonal.get(0)+ ";" + Titulo + ";" +puestoTrabajo;
    }
    
    public Telefono getTelefonoPersonal(){
        return telefonoPersonal.get(0);
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
    

}
