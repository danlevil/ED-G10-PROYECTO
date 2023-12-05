/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fields;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author danlevil
 */
public class Foto implements Serializable{
    private static final long serialVersionUID=1L;
    String archivo;
    LocalDate creacion;

    public Foto(String archivo) {
        this.archivo = archivo;
        creacion=LocalDate.now();
    }
    
    @Override
    public String toString() {
        return archivo +": "+creacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Foto other = (Foto) obj;
        if(this.getArchivo().equals(other.getArchivo())){
            return true;
        }
        return false;
    }
    
    
}
