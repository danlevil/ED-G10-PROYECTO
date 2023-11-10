/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.ArrayList;

/**
 *
 * @author danlevil
 */
public class ContactoEmpresa extends Contacto{
    String Departamento;
    String puestoTrabajo;
    
   
    public ContactoEmpresa(String name){
        this.isEmpresa= true;
        this.nombre=name;
    }
    @Override
    public void editarMe() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<String> mostrarInformacionAdicional() {
        ArrayList<String> datosExtra= new ArrayList<String>();
        datosExtra.add(this.Departamento);
        datosExtra.add(this.puestoTrabajo);
        
        return datosExtra;
        

    }
    
}
