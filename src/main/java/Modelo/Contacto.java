/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author danlevil
 */
import Estructuras.*;
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
    List<RedSocial> redesSociales;
    List<String> etiquetas;
    
    
    public Contacto(){
        direcciones=new ArrayList<Direccion>();
        emails=new ArrayList<Email>();
        telefonos=new ArrayList<Telefono>();
        fotos=new LinkedCircularDE<Foto>();
        redesSociales=new ArrayList<RedSocial>();
        etiquetas=new ArrayList<String>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public abstract void editarMe();
    
    public abstract ArrayList<String> mostrarInformacionAdicional();
    
    
    
    
    
}
