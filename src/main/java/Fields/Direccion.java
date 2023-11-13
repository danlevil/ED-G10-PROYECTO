/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fields;

import java.io.Serializable;

/**
 *
 * @author danlevil
 */
public class Direccion implements Serializable {
    private static final long serialVersionUID=1L;

    
    String nombreDireccion;
    String ubicacion;

    public Direccion(String nombreDireccion, String ubicacion) {
        this.nombreDireccion = nombreDireccion;
        this.ubicacion = ubicacion;
    }
    
    
    @Override
    public String toString() {
        return nombreDireccion +": "+ubicacion;
    }
}
