/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fields;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author danlevil
 */
public class Fecha implements Serializable {
    private static final long serialVersionUID=1L;
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
    
    public String getFecha(){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convertir LocalDate a String usando el formato
        String fechaComoString = fecha.format(formatter);
        
        return fechaComoString;
    }
    public String getFechaDescripcion(){
        return descripcion;
    }
        
}
