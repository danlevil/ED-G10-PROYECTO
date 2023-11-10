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
    
    List<Contacto> contactos=new LinkedCircularDE<Contacto>();
    
    
    public void agregarContacto(Contacto c){
        contactos.add(c);
        
    }
    
    public void eliminarContacto(Contacto c){
        //contactos.remove(c, cmp);
    }
    
    public void editarContacto(){}
    
    public void mostrarAsociados(){}
    
    public void filtrarPorTipoContacto(){}
    
    public void filtrarFechaCumpleaños(){}
    
    
    
}
