/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fields;

/**
 *
 * @author danlevil
 */
public class RedSocial {
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
    
}
