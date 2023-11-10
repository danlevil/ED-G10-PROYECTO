/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author danlevil
 */
import Estructuras.ArrayList;
import Estructuras.List;
import Fields.*;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Contacto implements Serializable {
    
    
    String nombre;
    boolean isEmpresa;
    boolean favorito;
    List<Direccion> direcciones;
    List<Email> emails;
    List<Telefono> telefonos;
    List<Foto>  fotos;
    List<LocalDate> fechasImportantes;
    List<Contacto> contactosRelacionados;
    List<String> redesSociales;
    List<String> etiquetas;

    public String getNombre() {
        return nombre;
    }
    
    public abstract void editarMe();
    
    public abstract ArrayList<String> mostrarInformacionAdicional();
    
    
    
}
