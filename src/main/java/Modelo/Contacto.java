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
    String idContactoPadre;
    String idcontactoEnListaDePadre;
    
    List<Direccion> direcciones;
    List<Email> emails;
    List<Telefono> telefonos;
    List<Foto>  fotos;
    List<Fecha> fechasImportantes;
    List<Contacto> contactosRelacionados;
    List<RedSocial> redesSociales;
    List<String> etiquetas;
    
    
    public Contacto(String nombre, String idContactoPadre, String idcontactoEnListaDePadre  ){
        
        this.nombre = nombre;
        direcciones=new LinkedCircularDE();
        emails=new LinkedCircularDE();
        telefonos=new LinkedCircularDE();
        redesSociales=new LinkedCircularDE();
        etiquetas=new LinkedCircularDE();
        fechasImportantes=new LinkedCircularDE();
        fotos= new LinkedCircularDE();
        contactosRelacionados= new LinkedCircularDE();
        this.idContactoPadre = idContactoPadre;
        this.idcontactoEnListaDePadre = idcontactoEnListaDePadre;
        
        
        GeneradorID gID= new GeneradorID();
        this.id=gID.generar();
    }

    public String getIdContactoPadre() {
        return idContactoPadre;
    }

    public String getIdcontactoEnListaDePadre() {
        return idcontactoEnListaDePadre;
    }

    public void setIdContactoPadre(String idContactoPadre) {
        this.idContactoPadre = idContactoPadre;
    }

    public void setIdcontactoEnListaDePadre(String idcontactoEnListaDePadre) {
        this.idcontactoEnListaDePadre = idcontactoEnListaDePadre;
    }
    
    
    //Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //ID
    public int getId() {
        return id;
    }
    //Emails
     public Email getCorreoPrincipal() {
        return emails.getStart();
    }

    public List<Email> getEmails() {
        return emails;
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

    //Telefono
    public Telefono getTelefonoPrincipal(){
        return telefonos.getStart();
    }
    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
    public List<Telefono> getTelefonos() {
        return telefonos;
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
    //Direcciones
    public Direccion getDireccionPrincipal(){
        return direcciones.getStart();
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
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
    //Fechas
    public Fecha getPrimeraFechaImportante(){
        return fechasImportantes.getStart();
    }

    public List<Fecha> getFechasImportantes() {
        return fechasImportantes;
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
    //Relacionado a Empresas
    public boolean isEmpresa() {
        return isEmpresa;
    }

    //Favorito
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    public String getEstadoFavorito(){
        if(favorito){
            return "S";
        }else{
            return "N";
        }
    }
    public boolean isFavorito() {
        return favorito;
    }
    //FOTOS

    public List<Foto> getFotos() {
        return fotos;
    }
    public boolean añadirFoto(Foto foto){
        if(foto!=null){
            
            fotos.add(foto);
            return true;
        }
        return false;
    }
    //public boolean añadirFoto(){};
    
    //Etiquetas
    public List<String> getEtiquetas() {
        return etiquetas;
    }
    public boolean añadirEtiqueta(String etiquetaNueva){
        return (etiquetaNueva!=null)?etiquetas.add(etiquetaNueva):false;
    }

    //Redes sociales
 
    public List<RedSocial> getRedesSociales() {
        return redesSociales;
    }
    public boolean añadirRedSocial(String descripcion,String red){
        boolean valido1 = (descripcion!=null)?true:false;
        boolean valido2 = (red!=null)?true:false;
        if(valido1&&valido2){redesSociales.add(new RedSocial(descripcion,red));return true;}
        
        return false;
    }
     //Contactos relacionados
 
    public List<Contacto> getContactosRelacionados() {
        return contactosRelacionados;
    }
        //public boolean añadirContacto(){};


    @Override
    public boolean equals(Object o) {
        Contacto obj=(Contacto)o;
        boolean bandera=true;
        if (obj == null) {
            bandera= false;
        }
        if (getClass() != obj.getClass()) {
            bandera= false;
        }
        
        /*if (!(obj instanceof Contacto)) {
            bandera= false;
        }*/
        if(bandera){
            final Contacto other = (Contacto) obj;
            return this.id == other.id;
        }
        return bandera;
    }

   

   @Override
    public String toString() {
        return id +";"+ nombre + ";" + isEmpresa + ";" + favorito + ";" + direcciones.get(0)+ ";"+emails.get(0)+";"+telefonos.get(0)+";"+fotos.getStart()+";"+redesSociales.get(0)+";"+etiquetas.get(0)+";"+fechasImportantes.getStart();
    }

    

    

    


    
    
    
    
    
    
}
