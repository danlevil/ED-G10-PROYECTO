/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Estructuras.LinkedCircularDE;
import Estructuras.List;

/**
 *
 * @author danlevil
 */
public class Agenda {
    
    
    public static List<ContactoPersona> contactosPersonas=new LinkedCircularDE<ContactoPersona>();
    public static List<ContactoEmpresa> contactosEmpresas=new LinkedCircularDE<ContactoEmpresa>();
    public static List<Contacto> contactosMaster= new LinkedCircularDE<Contacto>();
    
    public static void agregarGeneral(Contacto c){
        contactosMaster.add(c);
    }
    public static void agregarContactoEmpresa(ContactoEmpresa c){
        contactosEmpresas.add(c);
        
    }
    public static void agregarContactoPersona(ContactoPersona c){
        contactosPersonas.add(c);
        
    }
    
    public static void serializarGeneral(List<Contacto> listaGeneral){
        
    }
    public static void serializarContactosEmpresa(List<Contacto> listaEmpresas){
        
    }
    public static void serializarContactosPersona(List<Contacto> listaPersonas){
        
    }
    
    public void eliminarContacto(Contacto c){
        //contactos.remove(c, cmp);
    }
    
    public void editarContacto(){}
    
    public void mostrarAsociados(){}
    
    public void filtrarPorTipoContacto(){}
    
    public void filtrarFechaCumpleaños(){}
    
    
    
}
