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
public class Telefono implements Serializable {
    private static final long serialVersionUID=1L;
    String descripcion;
    String numero;

    public Telefono(String descripcion, String numero) {
        this.descripcion = descripcion;
        this.numero = numero;
    }
    
    
     @Override
    public String toString() {
        return descripcion +": "+numero;
    }
    
}
