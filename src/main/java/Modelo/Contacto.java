/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author danlevil
 */
import Estructuras.List;
import java.time.LocalDate;
public abstract class Contacto {
    
    
    String direccion;
    boolean isEmpresa;
    List<String> emails;
    List<String> telefonos;
    List<Foto>  fotos;
    List<LocalDate> fechasImportantes;
    List<Contacto> contactosRelacionados;
    List<String> redesSociales;
    List<String> etiquetas;
    
    public abstract void editarMe();
    
}
