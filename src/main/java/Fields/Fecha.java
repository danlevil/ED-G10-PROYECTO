/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fields;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author danlevil
 */
public class Fecha implements Serializable {
    String descripcion;
    LocalDate fecha;

    public Fecha(String descripcion, LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return descripcion +": "+fecha;
    }
    
}
