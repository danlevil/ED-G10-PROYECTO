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
public class RedSocial implements Serializable{
    private static final long serialVersionUID=1L;
    String descripcion;
    String cuenta;

    public RedSocial(String descripcion, String cuenta) {
        this.descripcion = descripcion;
        this.cuenta = cuenta;
    }
    
     @Override
    public String toString() {
        return descripcion +": "+cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    
}
