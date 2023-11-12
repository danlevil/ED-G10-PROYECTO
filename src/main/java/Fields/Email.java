/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fields;

import Modelo.Contacto;
import Modelo.ContactoEmpresa;

/**
 *
 * @author danlevil
 */
public class Email {
    String descripcion;
    String direccionCorreo;

    public Email(String descripcion, String direccionCorreo) {
        this.descripcion = descripcion;
        this.direccionCorreo = direccionCorreo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }
    
    @Override
    public String toString() {
        return descripcion +": "+direccionCorreo;
    }
    
    
}
