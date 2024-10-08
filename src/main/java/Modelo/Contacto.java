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

public class Contacto implements Serializable {
    private static final long serialVersionUID=1L;
    private int id;

    String nombre;
    
    boolean isEmpresa;
    boolean favorito;
    
    
    List<Direccion> direcciones;
    List<Email> emails;
    List<Telefono> telefonos;
    List<Foto>  fotos;
    List<Fecha> fechasImportantes;
    List<Contacto> contactosRelacionados;
    List<RedSocial> redesSociales;
    List<String> etiquetas;
    
    
    public Contacto(String nombre, boolean favorito, ArrayList<Direccion> direcciones, ArrayList<Email> emails, ArrayList<Telefono> telefonos, LinkedCircularDE<Foto> fotos, ArrayList<RedSocial> redesSociales, ArrayList<String> etiquetas, LinkedCircularDE<Fecha> fechasImportantes){
        
        this.nombre = nombre;
        this.isEmpresa = isEmpresa;
        this.favorito = favorito;
        this.direcciones= direcciones;
        this.emails=emails;
        this.telefonos= telefonos;
        this.fotos= fotos;
        this.redesSociales= redesSociales;
        this.etiquetas= etiquetas;
        this.fechasImportantes= fechasImportantes;
        
        GeneradorID gID= new GeneradorID();
        
        this.id=gID.generar();
    }
    
    
   
       @Override
    public String toString() {
        return id +";"+ nombre + ";" + isEmpresa + ";" + favorito + ";" + direcciones.get(0)+ ";"+emails.get(0)+";"+telefonos.get(0)+";"+fotos.getStart()+";"+redesSociales.get(0)+";"+etiquetas.get(0)+";"+fechasImportantes.getStart();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    
     public Email getCorreo() {
        return emails.get(0);
    }
     
    public Telefono getTelefono(){
        return telefonos.get(0);
    }
    
    public Direccion getDireccion(){
        return direcciones.get(0);
    }
    
    public Fecha getFechaImportante(){
        return fechasImportantes.getStart();
    }

    public boolean isEmpresa() {
        return isEmpresa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIsEmpresa(boolean isEmpresa) {
        this.isEmpresa = isEmpresa;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public void setFechasImportantes(List<Fecha> fechasImportantes) {
        this.fechasImportantes = fechasImportantes;
    }

    public void setContactosRelacionados(List<Contacto> contactosRelacionados) {
        this.contactosRelacionados = contactosRelacionados;
    }

    public void setRedesSociales(List<RedSocial> redesSociales) {
        this.redesSociales = redesSociales;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public List<Fecha> getFechasImportantes() {
        return fechasImportantes;
    }

    public List<Contacto> getContactosRelacionados() {
        return contactosRelacionados;
    }

    public List<RedSocial> getRedesSociales() {
        return redesSociales;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public boolean isFavorito() {
        return favorito;
    }
    
    
    
    public boolean agregarEmail(String descripcion, String cuenta){
        if(descripcion==null && cuenta == null){
            return false;
        }
        if(descripcion==null && cuenta !=null){
            descripcion="Sin descripcion";
        }
        Email nuevo= new Email(descripcion, cuenta);
        emails.add(nuevo);
        if(nuevo!=null){return true;}
        return false;
    }
    
    public boolean agregarTelefono(String descripcion, String numero){
        if(descripcion==null && numero == null){
            return false;
        }
        if(descripcion==null && numero !=null){
            descripcion="Sin descripcion";
        }
        Telefono nuevo= new Telefono(descripcion, numero);
        telefonos.add(nuevo);
        if(nuevo!=null){return true;}
        return false;
    }
    
    public boolean agregarFechaImportante(String descripcion, LocalDate fecha){
        if(descripcion==null && fecha == null){
            return false;
        }
        if(descripcion==null && fecha !=null){
            descripcion="Sin descripcion";
        }
        Fecha nuevo= new Fecha(descripcion, fecha);
        fechasImportantes.add(nuevo);
        if(nuevo!=null){return true;}
        return false;
    }
    public boolean agregarDireccion(String descripcion, String ubicacion){
        if(descripcion==null && ubicacion == null){
            return false;
        }
        if(descripcion==null && ubicacion !=null){
            descripcion="Sin descripcion";
        }
        Direccion nuevo= new Direccion(descripcion, ubicacion);
        direcciones.add(nuevo);
        if(nuevo!=null){return true;}
        return false;
    }
    
    
    
    
    
    
}
